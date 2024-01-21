package com.zm.ams.services;

import java.sql.SQLException;

import com.zm.ams.dto.User;

public interface UserService {
	
	boolean validateUser(User user) throws SQLException;
	
}