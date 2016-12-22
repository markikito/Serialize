package com.markikito.serialize;

import java.math.BigDecimal;

/**
 * This Enum represents the type of java for which is a String transform to the type in the enum.
 * @author Marcos Medina
 *
 */
public enum TypesOfJava {
	
	INTEGER("java.lang.Integer", 0),
	STRING("java.lang.String", 1),
	DATE("java.util.Date", 2),	
	LONG("java.lang.Long", 3),
	LONGPRIMITIVE("long", 4),
	BOOLEAN("java.lang.Boolean",5),
	BOOL("boolean", 6),
	INT("int", 7),
	CHAR("char", 8),
	DOUBLEPRIMITIVE("double",9),
	DOUBLE("java.lang.Double",10),
	FLOATPRIMITIVE("float",11),
	FLOAT("java.lang.Float",12),
	BIGDECIMAL("java.math.BigDecimal",13),
	NOT_FOUND("java.lang.Not_Found", 14);
		
	private final String description;
	private final int id;
	
	private TypesOfJava(String name, int ordinal) {
		this.id = ordinal;
		this.description = name;
	}
	
	public final int getId(){
		return id;
	}
	
	public final String getDescription(){
		return description; 
	}
	
	public static TypesOfJava getBydescription(String name){
		TypesOfJava result=NOT_FOUND;
		for (TypesOfJava element : TypesOfJava.values()){
			if (element.getDescription().equals(name)){
				result=element;
				break;
			}
		}
		return result;
	}
	
	
	
}
