package com.markikito.serialize;

import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeObjectWithJackson<T> implements SerializeObject<T> {
	
	private T clazz;	

	public SerializeObjectWithJackson(T clazz) {
		super();
		this.clazz = clazz;
	}

	public String serialize(Object object) {
		ObjectMapper mapper=new ObjectMapper();
		String  resultado=null;
		try {
			mapper=new ObjectMapper();
			String tmp=mapper.writeValueAsString(object);
			resultado = Base64.getEncoder().encodeToString(tmp.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return resultado;		
	}

	public Object desSerialize(String objectAsString) {
		Object resultado=null;
		ObjectMapper mapper = null;
		byte[] valueDecoded=null;
		try{
			valueDecoded= Base64.getDecoder().decode(objectAsString);
			mapper = new ObjectMapper();
			resultado=mapper.readValue(new String(valueDecoded),clazz.getClass());					
		}catch (Exception e) {
			e.printStackTrace();
		} 
		return resultado;
	}

}
