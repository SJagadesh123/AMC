package com.zm.ams.services.impl;

import java.sql.SQLException;
import java.util.Optional;

import com.zm.ams.dao.UserDao;
import com.zm.ams.dao.jdbc.impl.UserDaoImpl;
import com.zm.ams.dto.User;
import com.zm.ams.services.UserService;

public class UserServiceImpl implements UserService{

	UserDao dao = new UserDaoImpl();

	@Override
	public boolean validateUser(User user) throws SQLException {

		Optional<User> userOpt = dao.getUser(user);
		
		return userOpt.isPresent();
	}	
	

}
