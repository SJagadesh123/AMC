package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zm.ams.dto.PropertyType;

public interface PropertyTypeService {

	List<PropertyType> getAll() throws SQLException;
	Optional<PropertyType> get(int id) throws SQLException;
}
