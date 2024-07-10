package com.spring.orm2.dao;

import java.util.List;

import com.spring.orm2.entities.Person;

public interface PersonDao {
	
	public int insert(Person person);
	
	public Person getPerson(int personId);
	
	public List<Person> getTable();
	
	public void delete(int personId);
	
	public void update(Person person);

}
