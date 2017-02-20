package com.boom.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.boom.entity.Course;
import com.boom.entity.Student;
import com.boom.utils.HibernateUtils;

public class CsManyToMany {
	
		//��Զ༶������  ����ѧ������
		@Test
		public void testMtmSave1(){
			SessionFactory sessionFactory=null;
			Session session=null;
			Transaction tx=null;
			try {
				sessionFactory=HibernateUtils.getSessionFactory();
				session=HibernateUtils.getSessionObject();
				tx=session.beginTransaction();
				//��������ѧ��
				Student s1 =new Student();
				s1.setSname("Tom");
				s1.setAddress("china");
				Student s2 =new Student();
				s2.setSname("jack");
				s2.setAddress("usa");
				//���������γ�
				Course c1 =new Course();
				c1.setCname("design");
				Course c2=new Course();
				c2.setCname("write");
				Course c3=new Course();
				c3.setCname("computer");
				//Ϊѧ�����ÿγ�
				s1.getCourses().add(c1);
				s1.getCourses().add(c2);
				s2.getCourses().add(c3);
				s2.getCourses().add(c1);
				
				//����γ����ݵ����ݿ�
				session.save(s1);
				session.save(s2);
				
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}finally{
			if (session!=null) {
				session.close();
			}
			if (sessionFactory!=null) {
				sessionFactory.close();
			}	
			}	
		}
		
		
		//��Զ༶������  ���ݿγ̱���
				@Test
				public void testMtmSave2(){
					SessionFactory sessionFactory=null;
					Session session=null;
					Transaction tx=null;
					try {
						sessionFactory=HibernateUtils.getSessionFactory();
						session=HibernateUtils.getSessionObject();
						tx=session.beginTransaction();
						//��������ѧ��
						Student s1 =new Student();
						s1.setSname("lucy");
						s1.setAddress("china");
						Student s2 =new Student();
						s2.setSname("boom");
						s2.setAddress("usa");
						//���������γ�
						Course c1 =new Course();
						c1.setCname("design");
						Course c2=new Course();
						c2.setCname("write");
						Course c3=new Course();
						c3.setCname("computer");
						
						//��ѡÿ���γ̵��û����ѧ��
						c1.getStudents().add(s1);
						c1.getStudents().add(s2);
						c2.getStudents().add(s1);
						c3.getStudents().add(s2);
						
						//����γ����ݵ����ݿ�
						session.save(c1);
						session.save(c2);
						session.save(c3);
						//�����ύ
						tx.commit();
					} catch (Exception e) {
						e.printStackTrace();
						//����ع�
						tx.rollback();
					}finally{
					if (session!=null) {
						session.close();
					}
					if (sessionFactory!=null) {
						sessionFactory.close();
					}	
					}	
				}
				
				//��Զ༶��ɾ��
				@Test
				public void testMtmDelete(){
					SessionFactory sessionFactory=null;
					Session session=null;
					Transaction tx=null;
					try {
						sessionFactory=HibernateUtils.getSessionFactory();
						session=HibernateUtils.getSessionObject();
						tx=session.beginTransaction();
						
						//����id�ҵ�����
						Student s1=(Student)session.get(Student.class,1);
						//ɾ������
						session.delete(s1);
						
						tx.commit();
					} catch (Exception e) {
						e.printStackTrace();
						tx.rollback();
					}finally{
					if (session!=null) {
						session.close();
					}
					if (sessionFactory!=null) {
						sessionFactory.close();
					}	
					}	
				}

}
