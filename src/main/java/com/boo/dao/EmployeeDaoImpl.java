package com.boo.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.boo.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public int insertRow(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	public List<Employee> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = session
				.createQuery("from Employee").list();
		session.close();
		for (Employee employee : employeeList) {
			System.out.println(employee.toString());
		}
		
		return employeeList;
	}

	public Employee getRowById(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class, id);
		return employee;
	}

	public int updateRow(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		System.out.println(employee.toString());
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.load(
				Employee.class, id);
		session.delete(employee);
		tx.commit();
		Serializable ids = session.getIdentifier(employee);
		session.close();
		return (Integer) ids;
	}

}
