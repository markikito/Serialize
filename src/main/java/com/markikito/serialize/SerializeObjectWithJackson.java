package com.markikito.serialize;

import java.util.Base64;

import javax.sql.rowset.serial.SerialException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeObjectWithJackson<T> implements SerializeObject<T> {
	
	private T clazz;	

	public SerializeObjectWithJackson(T clazz) {
		super();
		this.clazz = clazz;
	}

	public String serialize(Object object) throws SerializedExeption {
		ObjectMapper mapper=new ObjectMapper();
		String  resultado=null;

		mapper=new ObjectMapper();
		String tmp;
		try {
			tmp = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new SerializedExeption("An exception occurred while processing json.", e);
		}
		resultado = Base64.getEncoder().encodeToString(tmp.getBytes());

		return resultado;		
	}

	public Object desSerialize(String objectAsString) throws SerializedExeption {
		Object resultado=null;
		ObjectMapper mapper = null;
		byte[] valueDecoded=null;
		try{
			valueDecoded= Base64.getDecoder().decode(objectAsString);
			mapper = new ObjectMapper();
			resultado=mapper.readValue(new String(valueDecoded),clazz.getClass());					
		}catch (Exception e) {
			throw new SerializedExeption("An exception occurred while desserialized the string", e);
		} 
		return resultado;
	}

}
