package com.demo.entrypoint;

public class Person {
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String greetings() {
		return "Hello " + this.getName();
	}

}
