package com.boo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.boo.model.Employee;

@Component
public interface EmployeeService {
	
	public int insertRow(Employee employee);

	public List<Employee> getList();

	public Employee getRowById(int id);

	public int updateRow(Employee employee);

	public int deleteRow(int id);
}
