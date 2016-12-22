package com.markikito.serialize;

import java.math.BigDecimal;
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
	private double decimalDoublePrimitive;
	private Double decimalDouble;
	private float decimalFloatPrimitive;
	private Float decimalFloat;
	private BigDecimal decimalBig;
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
	public double getDecimalDoublePrimitive() {
		return decimalDoublePrimitive;
	}
	public void setDecimalDoublePrimitive(double decimalDoublePrimitive) {
		this.decimalDoublePrimitive = decimalDoublePrimitive;
	}
	public Double getDecimalDouble() {
		return decimalDouble;
	}
	public void setDecimalDouble(Double decimalDouble) {
		this.decimalDouble = decimalDouble;
	}
	public float getDecimalFloatPrimitive() {
		return decimalFloatPrimitive;
	}
	public void setDecimalFloatPrimitive(float decimalFloatPrimitive) {
		this.decimalFloatPrimitive = decimalFloatPrimitive;
	}
	public Float getDecimalFloat() {
		return decimalFloat;
	}
	public void setDecimalFloat(Float decimalFloat) {
		this.decimalFloat = decimalFloat;
	}
	public BigDecimal getDecimalBig() {
		return decimalBig;
	}
	public void setDecimalBig(BigDecimal decimalBig) {
		this.decimalBig = decimalBig;
	}
	public long getContadorLong() {
		return contadorLong;
	}
	public void setContadorLong(long contadorLong) {
		this.contadorLong = contadorLong;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + contador;
		result = prime * result + (int) (contadorLong ^ (contadorLong >>> 32));
		result = prime * result + ((countryBorn == null) ? 0 : countryBorn.hashCode());
		result = prime * result + ((decimalBig == null) ? 0 : decimalBig.hashCode());
		result = prime * result + ((decimalDouble == null) ? 0 : decimalDouble.hashCode());
		long temp;
		temp = Double.doubleToLongBits(decimalDoublePrimitive);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((decimalFloat == null) ? 0 : decimalFloat.hashCode());
		result = prime * result + Float.floatToIntBits(decimalFloatPrimitive);
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((identificationDocument == null) ? 0 : identificationDocument.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.toString().equals(other.birthDate.toString()))
			return false;
		if (contador != other.contador)
			return false;
		if (contadorLong != other.contadorLong)
			return false;
		if (countryBorn == null) {
			if (other.countryBorn != null)
				return false;
		} else if (!countryBorn.equals(other.countryBorn))
			return false;
		if (decimalBig == null) {
			if (other.decimalBig != null)
				return false;
		} else if (!decimalBig.equals(other.decimalBig))
			return false;
		if (decimalDouble == null) {
			if (other.decimalDouble != null)
				return false;
		} else if (!decimalDouble.equals(other.decimalDouble))
			return false;
		if (Double.doubleToLongBits(decimalDoublePrimitive) != Double.doubleToLongBits(other.decimalDoublePrimitive))
			return false;
		if (decimalFloat == null) {
			if (other.decimalFloat != null)
				return false;
		} else if (!decimalFloat.equals(other.decimalFloat))
			return false;
		if (Float.floatToIntBits(decimalFloatPrimitive) != Float.floatToIntBits(other.decimalFloatPrimitive))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", identificationDocument=" + identificationDocument
				+ ", age=" + age + ", countryBorn=" + countryBorn + ", birthDate=" + birthDate + ", height=" + height
				+ ", contador=" + contador + ", contadorLong=" + contadorLong + ", decimalDoublePrimitive="
				+ decimalDoublePrimitive + ", decimalDouble=" + decimalDouble + ", decimalFloatPrimitive="
				+ decimalFloatPrimitive + ", decimalFloat=" + decimalFloat + ", decimalBig=" + decimalBig + "]";
	}	
	
}
