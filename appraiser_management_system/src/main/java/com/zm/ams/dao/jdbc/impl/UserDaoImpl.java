package com.zm.ams.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.zm.ams.config.ConnectionFactory;
import com.zm.ams.dao.UserDao;
import com.zm.ams.dto.User;

public class UserDaoImpl implements UserDao {

	Connection connection;
	PreparedStatement preparedStatement;
	public UserDaoImpl() {
		super();
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Optional<User> getUser(User user) throws SQLException {
		
		
		preparedStatement = connection.prepareStatement("select first_name from ams.users where user_name = ? and password = ?");
		
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getPassWord());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			user.setFirstName(resultSet.getString(1));
			
			return Optional.of(user);
		}
		return Optional.empty();
		
		
		
		
		
		
	}
	
	
}
