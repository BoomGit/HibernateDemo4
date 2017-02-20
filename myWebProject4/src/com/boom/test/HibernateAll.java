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
	//hibernate查询操作
	@Test
	public void  testHqlQuery(){
		SessionFactory sessionFactory=null;
		Session session =null;
		Transaction tx=null;
		try {
			sessionFactory=HibernateUtils.getSessionFactory();
			session=HibernateUtils.getSessionObject();
			tx=session.beginTransaction();
			//1.导航对象图检索方式,查询出一个用户，查询这个用户的所有订单，直接得到用户的订单集合
	     	Course course=(Course)session.get(Course.class,1);
			Set<Student> students =course.getStudents();
			//2.OID检索方式：根据对象的OID来查询	
			Course course1=(Course)session.get(Course.class,1);
			//3.Hql检索方式：使用面向对象的hql语句
			//3.1  简单查询（查询表里面的全部数据）hql语句
			Query query = session.createQuery("from Course");
			List<Course> list=query.list();
			for(Course course11 : list){
				System.out.println(course11.getCname());
			}
			
			//3.2    别名查询
			Query query2 = session.createQuery("from Customer c where c.cid=1");
			
			//3.3    排序查询（升序降序）
			//查詢表的前四條數據
			Query query3 = session.createQuery("from Customer c order by c.cid desc");
			//3.4    分页查询（查询表里面的那几条数据）
			Query query4 = session.createQuery("from Course");
			//設置開始位置
			query4.setFirstResult(0);
			//設置獲取幾條記錄
			query4.setMaxResults(4);
			//3.5   唯一对象查询（根據對象查詢這條數據）
			Query query5 = session.createQuery("from Customer c where c.cid=2");
			Course course2=(Course)query.uniqueResult();
			//3.6  根据条件查询（根據參數，根據名稱）
			Query query6 = session.createQuery("from Customer c where c.cid=? and c.cname=?");
			query6.setParameter(0, 2);
			query6.setParameter(1, "tom");
			//3.7  根据参数名称传递参数值
			Query query7 = session.createQuery("from Customer c where c.cid=:ccid and c.cname=:ccname");
			query7.setParameter("ccid",2);
			query7.setParameter("ccname","tom");
			//4.QBC（Query By Criteria） 封装了基于字符串形式的查询语句，提供了更加面向对象的查询接口
			//4.1简单查询
			Criteria criteria =session.createCriteria(Course.class);
			List<Course> list2=criteria.list();
			//4.2排序查询
			//4.2.1升序
			Criteria criteria2=session.createCriteria(Course.class);
			criteria.addOrder(Order.asc("cid"));
			//4.2.2降序
			Criteria criteria3=session.createCriteria(Course.class);
			criteria.addOrder(Order.desc("cid"));
			//4.3分页查询
			Criteria criteria4 =session.createCriteria(Course.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(4);
			//4.4条件查询
			Criteria criteria5 =session.createCriteria(Course.class);
			criteria5.add(Restrictions.gt("cid", 1));
			//4.5本地sql查询
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
