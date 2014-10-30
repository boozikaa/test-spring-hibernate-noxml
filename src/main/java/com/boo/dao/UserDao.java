package com.boo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.boo.model.User;

@Component
public interface UserDao {

	public int insertRow(User employee);

	public List<User> getList();

	public User getRowById(int id);

	public int updateRow(User employee);

	public int deleteRow(int id);

}
