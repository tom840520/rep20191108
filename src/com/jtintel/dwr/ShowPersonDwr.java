package com.jtintel.dwr;

import com.jtintel.bean.Person;
import com.jtintel.service.PersonService;

public class ShowPersonDwr {
	 private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	public Person showPerson()
	{
		return personService.getPerson(1);
	}

}
