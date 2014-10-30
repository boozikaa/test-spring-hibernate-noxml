package com.boo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boo.model.Employee;
import com.boo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("employee/form")
	public ModelAndView getForm(@ModelAttribute Employee employee) {
		System.out.println(employee.getFirstName());
		return new ModelAndView("employee/form");
	}

	@RequestMapping("employee/register")
	public ModelAndView registerUser(@ModelAttribute Employee employee) {
		employeeService.insertRow(employee);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping("employee/list")
	public ModelAndView getList() {
		List<Employee> employeeList = employeeService.getList();
		return new ModelAndView("employee/list", "employeeList", employeeList);
	}

	@RequestMapping("employee/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		employeeService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping("employee/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute Employee employee) {
		Employee employeeObject = employeeService.getRowById(id);
		return new ModelAndView("employee/edit", "employeeObject", employeeObject);
	}

	@RequestMapping("employee/update")
	public ModelAndView updateUser(@ModelAttribute Employee employee) {
		employeeService.updateRow(employee);
		return new ModelAndView("redirect:list");
	}

}
