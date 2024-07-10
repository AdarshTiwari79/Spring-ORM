package com.spring.orm2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_details")
public class Person {
	
	@Id
	@Column(name="person_id")
	private int personId;
	@Column(name="person_name")
	private String personName;
	@Column(name="person_city")
	private String personCity;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String personName, String personCity) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personCity = personCity;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonCity() {
		return personCity;
	}

	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}
	

}

