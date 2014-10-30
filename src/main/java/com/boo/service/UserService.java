package com.boo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.boo.model.User;

@Component
public interface UserService {
	
	public int insertRow(User employee);

	public List<User> getList();

	public User getRowById(int id);

	public int updateRow(User employee);

	public int deleteRow(int id);
}
