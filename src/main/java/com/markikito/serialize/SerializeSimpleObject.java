/**
 * 
 */
package com.markikito.serialize;

import java.lang.reflect.Method;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This implementation is based java reflection. Only works with simple objects, that is, 
 *  objects with primitive or simple type attributes: *  int, char, boolean, Integer, Long, String, Date
 *  The getter methods of the classes must follow the java standard.
 * @author Marcos Medina
 *
 */
public class SerializeSimpleObject<T> implements SerializeObject<T> {

	private T clazz;	

	public SerializeSimpleObject(T clazz) {
		super();
		this.clazz = clazz;
	}
	
	@Override
	public String serialize(Object object) throws SerializedExeption {
		Method[] methods = clazz.getClass().getMethods();
		StringBuilder result=new StringBuilder(20);
		try {		
		 for(Method method : methods){
			 if(isGetter(method)){
				 String nameAtributo=null;
				 Object valorAtributo=null;
				 if (! method.getName().equals("getClass")){
					 nameAtributo=method.getName().substring(3);
					 valorAtributo=method.invoke(object,null);		
					 if (valorAtributo != null){
						 result.append(",\"" + nameAtributo + "\":\""+ valorAtributo.toString() + "\"");
					 }
		    	}			    	
		    }
		 }
		 result.deleteCharAt(0);
		} catch (Exception  e) {
			throw new SerializedExeption(e);
		}		 
		return Base64.getEncoder().encodeToString(result.toString().getBytes());
	}

	
	@Override
	public Object desSerialize(String objectAsString) throws SerializedExeption{
		byte[] valueDecoded=null;
		Map<String,String> objetMap=null;		 
		try{
			valueDecoded= Base64.getDecoder().decode(objectAsString);
			objetMap=parseMap(new String(valueDecoded));			
			for (Map.Entry<String, String> entry : objetMap.entrySet()){			
			    setAtribute(entry.getKey(), entry.getValue());
			}
		} catch (Exception  e) {
			throw new SerializedExeption(e);
		}		 
		return clazz;
	}
	
	
	/**
	 * This method parses the string passed by the input parameter in a Map. 
	 * Each element of the map is marked by the comma character.
	 * The key and the value are separated by the character two points.
	 * @param text Input parameter to generate the Map 
	 * @return A map representing the content of the input parameter
	 */
	private  Map<String,String> parseMap(String string) {
	    Map<String,String> map = new LinkedHashMap<String,String>();
	    for(String keyValue: string.split(",")) {
	        String[] parts = keyValue.split(":", 2);
	        map.put(parts[0], parts[1]);
	    }
	    return map;
	}
	
	/**
	 * This method invokes the Setter method of class <T> which is called 
	 * the same as the parameter "nameSetter" after concatenating "set" at the 
	 * beginning of the String. Invokes the method by passing parameter "value".
	 * @param nameSet the name of setter method without the "set" the word.
	 * @param value The parameter used to invoke the setter method 
	 * @throws Exception
	 */
	private void setAtribute(String nameSetter, String value) throws Exception{
		Class<?> typeParameter=null;
		Object parameter=null;
		Method[] methods = clazz.getClass().getMethods();				
		String setMethod="set" + nameSetter.replaceAll("\"", "");		
		value=value.replaceAll("\"","");
		
		 for(Method method : methods){		 	
			 if (method.getName().equals(setMethod)){
				 typeParameter=method.getParameterTypes()[0];
				 parameter=StringToAnotherType.stringToAnotherType(value, typeParameter);
				 method.invoke(clazz,parameter);
				 break;
			 }	 
		 }		
	}
	
	/**
	 * This method indicates if the method passed by parameter is a getter ().
	 * @param method The method to verify if it is a getter.
	 * @return Returns true if it is a getter, otherwise false.
	 */
	private  boolean isGetter(Method method){
	  if(!method.getName().startsWith("get"))      
		  return false;
	  if(method.getParameterTypes().length != 0)   
		  return false;  
	  if(void.class.equals(method.getReturnType())) 
			  return false;
	  return true;
	}

	/**
	 * This method indicates if the method passed by parameter is a setter ().
	 * @param method The method to verify if it is a setter.
	 * @return Returns true if it is a setter, otherwise false.
	 */
	private static boolean isSetter(Method method){
		if(!method.getName().startsWith("set")){
			return false;
		}
		if(method.getParameterTypes().length != 1){
			return false;
		}
		return true;
	}

}
