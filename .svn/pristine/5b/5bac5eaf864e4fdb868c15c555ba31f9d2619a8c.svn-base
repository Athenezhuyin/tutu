package com.common.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class BaseDao {
	
	@Resource
	protected SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/**--增加--**/
	public void save(Object object) {
		System.out.println("dao:"+object);
		Session session = sessionFactory.getCurrentSession();
		session.save(object);
	}

	/**--修改--**/
	public void update(Object object) {
		System.out.println("dao:"+object);
		Session session = sessionFactory.getCurrentSession();
		session.update(object);
	}
	
	/**--删除--**/
	public void delete(Object object) {
		System.out.println("dao:"+object);
		Session session = sessionFactory.getCurrentSession();
		session.delete(object);
	}
	
	/**--增加或修改--**/
	public void saveOrUpdate(Object object) {
		System.out.println("dao:"+object);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(object);
	}
	
	/**--查看--**/
	public Object get(Class clazz, Long id) {
		System.out.println("dao:"+clazz+","+id);
		Session session = sessionFactory.getCurrentSession();
		return session.get(clazz, id);
	}
}
