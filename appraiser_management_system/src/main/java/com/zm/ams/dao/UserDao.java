package com.zm.ams.dao;

import java.sql.SQLException;
import java.util.Optional;

import com.zm.ams.dto.User;

public interface UserDao {
	
	Optional<User> getUser(User user) throws SQLException;
}
