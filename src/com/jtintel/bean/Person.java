package com.jtintel.bean;

public class Person {
	
	
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(String name) {
		this.name = name;
	}
	public Person(){
		System.out.print("alex");
	}

}
