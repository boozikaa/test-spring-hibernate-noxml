package com.boo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boo.dao.EmployeeDao;
import com.boo.model.Employee;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired  
	 EmployeeDao employeeDao;  
	  
	 public int insertRow(Employee employee) {  
	  return employeeDao.insertRow(employee);  
	 }  

	  public List<Employee> getList() {  
	   return employeeDao.getList();  
	  }  

	  public Employee getRowById(int id) {  
	   return employeeDao.getRowById(id);  
	  }  

	  public int updateRow(Employee employee) {  
	   return employeeDao.updateRow(employee);  
	  }  
 
	  public int deleteRow(int id) {  
	   return employeeDao.deleteRow(id);  
	  }  

}
