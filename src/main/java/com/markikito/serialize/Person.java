package com.markikito.serialize;

import java.util.Date;

/**
 * 
 * This class represents the basic data about a person
 * 
 * @author Marcos Medina
 *
 */
public class Person {
	
	private String name;
	private String lastName;
	private String identificationDocument;
	private Integer age;
	private String countryBorn;
	private Date birthDate;
	private Long height;
	private int contador;
	private long contadorLong;
	
	
	/**
	 * The Constructor.	
	 */
	public Person() {
		super();
	}
	

	/** 
	 * 
	 *  GETTERS AND SETTERS
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdentificationDocument() {
		return identificationDocument;
	}
	public void setIdentificationDocument(String identificationDocument) {
		this.identificationDocument = identificationDocument;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountryBorn() {
		return countryBorn;
	}
	public void setCountryBorn(String countryBorn) {
		this.countryBorn = countryBorn;
	}	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Long getHeight() {
		return height;
	}
	public void setHeight(Long height) {
		this.height = height;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}


	/**
	 * @return the contadorLong
	 */
	public long getContadorLong() {
		return contadorLong;
	}


	/**
	 * @param contadorLong the contadorLong to set
	 */
	public void setContadorLong(long contadorLong) {
		this.contadorLong = contadorLong;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((countryBorn == null) ? 0 : countryBorn.hashCode());
		result = prime * result + ((identificationDocument == null) ? 0 : identificationDocument.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (countryBorn == null) {
			if (other.countryBorn != null)
				return false;
		} else if (!countryBorn.equals(other.countryBorn))
			return false;
		if (identificationDocument == null) {
			if (other.identificationDocument != null)
				return false;
		} else if (!identificationDocument.equals(other.identificationDocument))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", identificationDocument=" + identificationDocument
				+ ", age=" + age + ", countryBorn=" + countryBorn + ", birthDate=" + birthDate + ", height=" + height
				+ "]";
	}	
	
}
