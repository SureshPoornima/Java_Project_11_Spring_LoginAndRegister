package com.naveen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.naveen.dao.UserDao;
import com.naveen.model.Login;
import com.naveen.model.User;

public  class UserDaoImpl implements UserDao{

 DataSource datasource;
 
 @Autowired
 JdbcTemplate jdbcTemplate;

public void register(com.naveen.model.User user) {
	// TODO Auto-generated method stub
	 String sql = "Insert into users values(?,?,?,?,?,?,?)";
	 jdbcTemplate.update(sql, new Object[] {user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),
			 user.getEmail(),user.getAddress(),user.getPhone()});
	
}
public com.naveen.model.User validateUser(Login login) {
	// TODO Auto-generated method stub
	String sql = "select * from users where username = '"+login.getUsername()+"' and password= '" + login.getPassword()+"'";
	 List<User> users = jdbcTemplate.query(sql, new UserMapper());
	 return (com.naveen.model.User) (users.size() > 0 ? users.get(0) : null);
}
 
}
 class UserMapper implements RowMapper<User>{
	  public User mapRow(ResultSet rs, int arg1)throws SQLException{
		   User user = new User();
		   user.setUsername(rs.getString("username"));
		   user.setPassword(rs.getString("password"));
		   user.setFirstname(rs.getString("firstname"));
		   user.setLastname(rs.getString("lastname"));
		   user.setEmail(rs.getString("email"));
		   user.setAddress(rs.getString("address"));
		   user.setPhone(rs.getString("phone"));
		   
		   return user;
		   
	  }
 }