package com.boom.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.boom.entity.Course;
import com.boom.entity.Student;
import com.boom.utils.HibernateUtils;
import com.sun.org.apache.xpath.internal.functions.FuncSubstringBefore;

import sun.launcher.resources.launcher;

public class HibernateAll {
	//hibernate��ѯ����
	@Test
	public void  testHqlQuery(){
		SessionFactory sessionFactory=null;
		Session session =null;
		Transaction tx=null;
		try {
			sessionFactory=HibernateUtils.getSessionFactory();
			session=HibernateUtils.getSessionObject();
			tx=session.beginTransaction();
			//1.��������ͼ������ʽ,��ѯ��һ���û�����ѯ����û������ж�����ֱ�ӵõ��û��Ķ�������
	     	Course course=(Course)session.get(Course.class,1);
			Set<Student> students =course.getStudents();
			//2.OID������ʽ�����ݶ����OID����ѯ	
			Course course1=(Course)session.get(Course.class,1);
			//3.Hql������ʽ��ʹ����������hql���
			//3.1  �򵥲�ѯ����ѯ�������ȫ�����ݣ�hql���
			Query query = session.createQuery("from Course");
			List<Course> list=query.list();
			for(Course course11 : list){
				System.out.println(course11.getCname());
			}
			
			//3.2    ������ѯ
			Query query2 = session.createQuery("from Customer c where c.cid=1");
			
			//3.3    �����ѯ��������
			//��ԃ���ǰ�ėl����
			Query query3 = session.createQuery("from Customer c order by c.cid desc");
			//3.4    ��ҳ��ѯ����ѯ��������Ǽ������ݣ�
			Query query4 = session.createQuery("from Course");
			//�O���_ʼλ��
			query4.setFirstResult(0);
			//�O�ë@ȡ�חlӛ�
			query4.setMaxResults(4);
			//3.5   Ψһ�����ѯ�����������ԃ�@�l������
			Query query5 = session.createQuery("from Customer c where c.cid=2");
			Course course2=(Course)query.uniqueResult();
			//3.6  ����������ѯ�������������������Q��
			Query query6 = session.createQuery("from Customer c where c.cid=? and c.cname=?");
			query6.setParameter(0, 2);
			query6.setParameter(1, "tom");
			//3.7  ���ݲ������ƴ��ݲ���ֵ
			Query query7 = session.createQuery("from Customer c where c.cid=:ccid and c.cname=:ccname");
			query7.setParameter("ccid",2);
			query7.setParameter("ccname","tom");
			//4.QBC��Query By Criteria�� ��װ�˻����ַ�����ʽ�Ĳ�ѯ��䣬�ṩ�˸����������Ĳ�ѯ�ӿ�
			//4.1�򵥲�ѯ
			Criteria criteria =session.createCriteria(Course.class);
			List<Course> list2=criteria.list();
			//4.2�����ѯ
			//4.2.1����
			Criteria criteria2=session.createCriteria(Course.class);
			criteria.addOrder(Order.asc("cid"));
			//4.2.2����
			Criteria criteria3=session.createCriteria(Course.class);
			criteria.addOrder(Order.desc("cid"));
			//4.3��ҳ��ѯ
			Criteria criteria4 =session.createCriteria(Course.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(4);
			//4.4������ѯ
			Criteria criteria5 =session.createCriteria(Course.class);
			criteria5.add(Restrictions.gt("cid", 1));
			//4.5����sql��ѯ
			SQLQuery sqlQuery=session.createSQLQuery("select * from t_course");
			List<Object[]> list3 =sqlQuery.list();
			for(Object[] objects : list3){
				System.out.println(Arrays.toString(objects));
			}
			//4.6
			
			
			                                                                                                                                                                                                                            
			
			
			tx.commit();
		} catch (Exception e) {
		e.printStackTrace();
		tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	} 
	
	
	
	
	
}
