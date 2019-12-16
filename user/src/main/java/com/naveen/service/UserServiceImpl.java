package com.naveen.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.naveen.dao.UserDao;
import com.naveen.model.Login;
import com.naveen.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDao UserDao;

	public void register(User user) {
		UserDao.register(user);
		
	}
	
	public User validateUser(Login login) {
		return UserDao.validateUser(login);
		
	}

	

}
