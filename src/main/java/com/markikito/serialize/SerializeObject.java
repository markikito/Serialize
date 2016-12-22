package com.markikito.serialize;

/**
 * 
 * This interface defines operations for serializing or serializing a simple java object.
 * It is necessary that the objects to  serialize/deserialize will be simple and have 
 * implemented the toString () method.
 * 
 * @author Marcos Medina
 *
 * @param <T> This is the class of the object to be serialized
 */
public interface SerializeObject<T> {
	
	
	/**
	 * This method converts the object passed by parameter to String.
	 * It is necessary that the objet has implemented toString(). 
	 * Based on the toString () method, the object will be serialized.
	 * @param object for serialize. The toString () method must be implemented. 
	 * @return 
	 */
	public String serialize(Object object);
	
	
	/**
	 * This method returns an object that is the result of converting the input parameter string 'objectAsString' 
	 *  into an object of class <T>. T is a Class intreface parameter.
	 *  
	 * @param objectAsString
	 * @return
	 */
	public Object desSerialize(String objectAsString);
	

}
