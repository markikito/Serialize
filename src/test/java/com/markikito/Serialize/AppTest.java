package com.markikito.Serialize;

import java.math.BigDecimal;
import java.util.Date;

import com.markikito.serialize.Person;
import com.markikito.serialize.SerializeObject;
import com.markikito.serialize.SerializeObjectWithJackson;
import com.markikito.serialize.SerializeSimpleObject;
import com.markikito.serialize.SerializedExeption;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    
	
	Person person;
	
	SerializeObject<Person> serializer;
	
	SerializeObject<Person> serializerSimple;
	
	/**
     * Create the test case and initialized objects for tests
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        
        person=new Person();
        person.setName("Bridget");
        person.setLastName("Evanson");
        person.setAge(27);
        person.setIdentificationDocument("78495761");
        person.setCountryBorn("England");
        person.setBirthDate(new Date());
        person.setHeight(2L);
        person.setDecimalBig(new BigDecimal("4000.35"));
        person.setDecimalDouble(new Double(40.44444));
        person.setDecimalFloatPrimitive(new Float("30.54"));
        person.setDecimalFloat(new Float("30.54"));
        
        
        serializer= new  SerializeObjectWithJackson<Person>(new Person());
        serializerSimple=new SerializeSimpleObject<Person>(new Person());
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
  
    /**
     * This test verify that the objet to serialized is the same when is desserialized.
     * 
     */
    public void testSerializingAPersonWithJackson(){
    	Person personPrime=null;    	
    	String objetSerialized=null;
    	
    	try {    	
    		System.out.println("Object to serialize:" + person.toString());
			objetSerialized=serializer.serialize(person);
			System.out.println("Object serielized as String:" + objetSerialized);
			personPrime=(Person)serializer.desSerialize(objetSerialized);
			System.out.println("Object desserielized:" + personPrime.toString());
		} catch (SerializedExeption e) {
			e.printStackTrace();
		}
    	
    	assertEquals(true, person.equals(personPrime));
    }
    
    
    public void testSerializingAPersonWithSimpleImplementation(){
    	Person personPrime=null;    	
    	String objetSerialized=null;

    	try {  
	    	System.out.println("Object to serialize:" + person.toString());
	    	objetSerialized=serializerSimple.serialize(person);
	    	System.out.println("Object serielized as String:" + objetSerialized);
	    	personPrime=(Person)serializerSimple.desSerialize(objetSerialized);
	    	System.out.println("Object desserielized:" + personPrime.toString());
		} catch (SerializedExeption e) {
			e.printStackTrace();
		}    	
    	assertEquals(true, person.equals(personPrime));
    }
    
    
    
}
