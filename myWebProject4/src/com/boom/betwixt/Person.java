package com.boom.betwixt;

/*
 *1.��JavaBeanתΪXML����
 *�½�һ��Person�� 
 **/
public class Person {
	private String name;
	private int age;
	/*need to allow bean to be created via reflection */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//ʡ��set get����
	
}
