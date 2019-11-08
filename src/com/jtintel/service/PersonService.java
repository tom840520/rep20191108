package com.jtintel.service;

import java.util.List;

import com.jtintel.bean.Person;

public interface PersonService {
	public void save(Person person);
	public void update(Person person);
	public Person getPerson(Integer personId);
	public List<Person> getPersons();
	public void delete(Integer personId);
	public void delete2 (Integer personId) throws Exception;

}
