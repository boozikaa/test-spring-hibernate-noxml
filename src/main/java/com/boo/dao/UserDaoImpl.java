package com.boo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boo.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public int insertRow(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		Serializable id = session.getIdentifier(user);
		return (Integer) id;
	}

	public List<User> getList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		//crit.setFirstResult(s);
		//crit.setMaxResults(numberOfRecordsPerPage);
		 
		@SuppressWarnings("unchecked")
		List<User> userList = crit.list();
		return userList;
	}

	public User getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	public int updateRow(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		Serializable id = session.getIdentifier(user);
		return (Integer) id;
	}

	public int deleteRow(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, id);
		session.delete(user);
		Serializable deleteId = session.getIdentifier(user);
		return (Integer) deleteId;
	}

}
