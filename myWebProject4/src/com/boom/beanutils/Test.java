package com.boom.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Test {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//1.��¡����
		//�½�һ����ͨ��Java Bean��������Ϊ����¡�Ķ���
		Person person = new Person();
		person.setName("����");
		person.setAge(22);
		try {
			Person person2=(Person)BeanUtils.cloneBean(person);
			System.out.println(person2.getName()+">>"+person2.getEmail()+">>"+person2.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//ԭ��Ҳ��ͨ��Java�ķ������������
		
		
		//======================================================================
		
		//2.��һ��Map����ת��Ϊһ��Bean
		//���Map�����key������Bean���������Ӧ
		Map map = new HashMap();
		map.put("name","tom");
		map.put("email","tom@");
		map.put("age",21);
		try {
			//��Mapת��Ϊһ��Person����
			Person person3=new Person();
			BeanUtils.populate(person3,map);
			//��һ��Beanת��Ϊһ��Map�����ˡ����£�
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
