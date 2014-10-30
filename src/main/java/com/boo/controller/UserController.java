package com.boo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boo.model.User;
import com.boo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("user/form")
	public ModelAndView getForm(@ModelAttribute User user) {
		//System.out.println(employee.getFirstName());
		return new ModelAndView("user/form");
	}

	@RequestMapping("user/register")
	public ModelAndView registerUser(@ModelAttribute User user) {
		userService.insertRow(user);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping("user/list")
	public ModelAndView getList() {
		List<User> user = userService.getList();
		return new ModelAndView("user/list", "userList", user);
	}

	@RequestMapping("user/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		userService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}

	@RequestMapping("user/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute User user) {
		User userObject = userService.getRowById(id);
		return new ModelAndView("user/edit", "userObj", userObject);
	}

	@RequestMapping("user/update")
	public ModelAndView updateUser(@ModelAttribute User user) {
		userService.updateRow(user);
		return new ModelAndView("redirect:list");
	}

}
