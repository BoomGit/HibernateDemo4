package com.boom.betwixt;

/*
 *1.将JavaBean转为XML内容
 *新建一个Person类 
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
	//省略set get方法
	
}
