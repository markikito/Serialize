/**
 * 
 */
package com.markikito.serialize;

import java.util.Date;

/**
 * This class transforms a string into any other type
 * @author Marcos Medina
 *
 */
public class StringToAnotherType {

		
	/**
	 * This the main method of the class.
	 * It detects the type that must transform the string and calls the method that implements it.
	 * @param string
	 * @param type
	 * @return
	 */
	public static Object stringToAnotherType(String valueString, Class<?> type)throws SerializedExeption{
		Object result=null;				
		switch(TypesOfJava.getBydescription(type.getName())){		
			case INTEGER:				
				result=stringToInteger(valueString);
				break;
			case DATE:
				result=stringToDate(valueString);
				break;
			case LONG:
				result=stringToLong(valueString);
				break;
			case STRING:
				result=valueString;
				break;
			case BOOL:
				result=stringToBool(valueString);
				break;
			case BOOLEAN:
				result=stringToBoolean(valueString);
				break;
			case CHAR:
				result=stringToChar(valueString);				
				break;
			case INT:
				result=stringToInt(valueString);
				break;
			case LONGPRIMITIVE:
				result=stringToLongPrimitive(valueString);
				break;				
			case NOT_FOUND:
				result=stringToAnything(valueString,type);
				break;				
		}
		return result;
	}

	/**
	 * Transforms a String into a primitive long
	 * @param valueString
	 * @return Returns an long Object.
	 */	
	private static Object stringToLongPrimitive(String valueString) {
		long result=0L;
		result=Long.valueOf(valueString).longValue();
		return result;
	}

	/**
	 * Transforms a String into a int
	 * @param valueString
	 * @return Returns an int Object.
	 */		
	private static Object stringToInt(String valueString) {
		int result=Integer.parseInt(valueString);		
		return result;
	}

	/**
	 * Transforms a String into a char
	 * @param valueString
	 * @return Returns an char Object.
	 */		
	private static Object stringToChar(String valueString) {
		char result=valueString.charAt(0);
		return result;
	}

	/**
	 * Transforms a String into a Boolean
	 * @param valueString
	 * @return Returns an Boolean Object.
	 */		
	private static Object stringToBoolean(String valueString) {
		Boolean result=false;
		if ("true".equalsIgnoreCase(valueString)){
			result=true;
		}
		return result;
	}

	/**
	 * Transforms a String into a boolean
	 * @param valueString
	 * @return Returns an boolean Object.
	 */	
	private static Object stringToBool(String valueString) {
		boolean result=false;
		if ("true".equalsIgnoreCase(valueString)){
			result=true;
		}
		return result;
	}

	/**
	 * Transforms a String into a Long
	 * @param valueString
	 * @return Returns an Long Object.
	 */
	private static Object stringToLong(String valueString) {
		Long result=null;
		result=Long.valueOf((String) valueString).longValue();
		return result;
	}

	/**
	 * Transforms a String into a Date
	 * @param valueString
	 * @return Returns an Date Object.
	 */
	private static Object stringToDate(String valueString) {
		Date result=null;
		result=new java.util.Date(valueString);
		return result;
	}
	
	/**
	 * Transforms a String into an Integer
	 * @param valueString
	 * @return Returns an Integer Object.
	 */
	private static Object stringToInteger(String valueString) {
		System.out.println("Integer");
		Integer result=new Integer(valueString);
		return result;
	}
	
	
	/**
	 * Transforms a String into an Type indicated by type parameter. 
	 * @param valueString The value to be transformed
	 * @param type The type of object to return
	 * @return Returns an object type "type" which is the string transformed to that type.
	 * @throws SerializedExeption If an attempt is made to cast an exception, it will launch a SerializedExeption
	 */
	private static Object stringToAnything(String valueString, Class<?> type) throws SerializedExeption{
		Object result=null;
		try{
			result=type.cast(valueString);
		}catch (Exception e){
			String message="For type:" + type.getClass().getName() + " does not have a specific transformer."  
					+ " When trying to cast the string value:\"" +valueString +"\" to " + type.getClass().getName() 
					+ " an exception occurred ";					
			throw new SerializedExeption(message,e);
		}			
		return result;		
	}
	
	
}
