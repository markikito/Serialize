/**
 * 
 */
package com.markikito.serialize;

/**
 * This class is the root exception for serialization module.
 * @author Marcos Medina
 *
 */
public class SerializedExeption extends Exception {

	private static final long serialVersionUID = 5439300020669089765L;

	public SerializedExeption() {
		super();
	}

	public SerializedExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public SerializedExeption(String message) {
		super(message);
	}

	public SerializedExeption(Throwable cause) {
		super(cause);
	}

}
