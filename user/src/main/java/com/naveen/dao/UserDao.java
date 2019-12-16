package com.naveen.dao;

import com.naveen.model.Login;
import com.naveen.model.User;

public interface UserDao {
	
   void register(User user);
   User validateUser(Login login);
 }
