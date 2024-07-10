package com.spring.orm2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm2.entities.Person;

public class PersonDaoImpl implements PersonDao{
	
	HibernateTemplate hibernateTemplate;
	
	
	// insertion
	@Transactional
	public int insert(Person person) {
		
		// return id 
		int i = (int)this.hibernateTemplate.save(person);
		return i;
		
	}
	
	
	// Selection of single row
	@Override
	public Person getPerson(int personId) {
		
		Person person = this.hibernateTemplate.get(Person.class, personId);
		return person;
	}
	
	// Selection of all students
	@Override
	public List<Person> getTable() {
		
		List<Person> personList = this.hibernateTemplate.loadAll(Person.class);
		return personList;
	}
	
	// Deletion
	@Transactional
	@Override
	public void delete(int personId) {
		Person person = this.hibernateTemplate.get(Person.class,personId);
		this.hibernateTemplate.delete(person);
	}
	
	// Update
	@Transactional
	@Override
	public void update(Person person) {
		this.hibernateTemplate.update(person);
		
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	
	

}

