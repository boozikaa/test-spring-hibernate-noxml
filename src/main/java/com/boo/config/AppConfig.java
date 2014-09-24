package com.boo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boo.dao.EmployeeDao;
import com.boo.dao.EmployeeDaoImpl;
import com.boo.service.EmployeeService;
import com.boo.service.EmployeeServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImpl();		
	}
	
	@Bean
	public EmployeeDao employeeDao() {
		return new EmployeeDaoImpl();
	}
}
