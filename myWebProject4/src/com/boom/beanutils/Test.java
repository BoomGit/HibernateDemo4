package com.boom.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Test {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//1.克隆对象
		//新建一个普通的Java Bean，用来作为被克隆的对象
		Person person = new Person();
		person.setName("张三");
		person.setAge(22);
		try {
			Person person2=(Person)BeanUtils.cloneBean(person);
			System.out.println(person2.getName()+">>"+person2.getEmail()+">>"+person2.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//原理也是通过Java的反射机制来做的
		
		
		//======================================================================
		
		//2.将一个Map对象转化为一个Bean
		//这个Map对象的key必须与Bean的属性相对应
		Map map = new HashMap();
		map.put("name","tom");
		map.put("email","tom@");
		map.put("age",21);
		try {
			//将Map转化为一个Person对象
			Person person3=new Person();
			BeanUtils.populate(person3,map);
			//将一个Bean转化为一个Map对象了。如下：
			Map map2=BeanUtils.describe(person3);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
