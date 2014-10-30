package com.boo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boo.dao.UserDao;
import com.boo.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public int insertRow(User user) {
		return userDao.insertRow(user);
	}

	@Transactional(readOnly=true)
	public List<User> getList() {
		return userDao.getList();
	}
	
	@Transactional(readOnly=true)
	public User getRowById(int id) {
		return userDao.getRowById(id);
	}
	
	@Transactional
	public int updateRow(User user) {
		return userDao.updateRow(user);
	}

	@Transactional
	public int deleteRow(int id) {
		return userDao.deleteRow(id);
	}

}
