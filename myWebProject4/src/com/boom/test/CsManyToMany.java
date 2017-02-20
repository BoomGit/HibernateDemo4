package com.boom.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.boom.entity.Course;
import com.boom.entity.Student;
import com.boom.utils.HibernateUtils;

public class CsManyToMany {
	
		//多对多级联保存  根据学生保存
		@Test
		public void testMtmSave1(){
			SessionFactory sessionFactory=null;
			Session session=null;
			Transaction tx=null;
			try {
				sessionFactory=HibernateUtils.getSessionFactory();
				session=HibernateUtils.getSessionObject();
				tx=session.beginTransaction();
				//创建两个学生
				Student s1 =new Student();
				s1.setSname("Tom");
				s1.setAddress("china");
				Student s2 =new Student();
				s2.setSname("jack");
				s2.setAddress("usa");
				//创建三个课程
				Course c1 =new Course();
				c1.setCname("design");
				Course c2=new Course();
				c2.setCname("write");
				Course c3=new Course();
				c3.setCname("computer");
				//为学生设置课程
				s1.getCourses().add(c1);
				s1.getCourses().add(c2);
				s2.getCourses().add(c3);
				s2.getCourses().add(c1);
				
				//保存课程数据到数据库
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
		
		
		//多对多级联保存  根据课程保存
				@Test
				public void testMtmSave2(){
					SessionFactory sessionFactory=null;
					Session session=null;
					Transaction tx=null;
					try {
						sessionFactory=HibernateUtils.getSessionFactory();
						session=HibernateUtils.getSessionObject();
						tx=session.beginTransaction();
						//创建两个学生
						Student s1 =new Student();
						s1.setSname("lucy");
						s1.setAddress("china");
						Student s2 =new Student();
						s2.setSname("boom");
						s2.setAddress("usa");
						//创建三个课程
						Course c1 =new Course();
						c1.setCname("design");
						Course c2=new Course();
						c2.setCname("write");
						Course c3=new Course();
						c3.setCname("computer");
						
						//对选每个课程的用户添加学生
						c1.getStudents().add(s1);
						c1.getStudents().add(s2);
						c2.getStudents().add(s1);
						c3.getStudents().add(s2);
						
						//保存课程数据到数据库
						session.save(c1);
						session.save(c2);
						session.save(c3);
						//事物提交
						tx.commit();
					} catch (Exception e) {
						e.printStackTrace();
						//事物回滚
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
				
				//多对多级联删除
				@Test
				public void testMtmDelete(){
					SessionFactory sessionFactory=null;
					Session session=null;
					Transaction tx=null;
					try {
						sessionFactory=HibernateUtils.getSessionFactory();
						session=HibernateUtils.getSessionObject();
						tx=session.beginTransaction();
						
						//根据id找到对象
						Student s1=(Student)session.get(Student.class,1);
						//删除对象
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
