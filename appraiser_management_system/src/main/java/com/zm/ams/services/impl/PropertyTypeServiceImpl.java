package com.zm.ams.services.impl;

import java.sql.SQLException;

import java.util.List;
import java.util.Optional;

import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.jdbc.impl.PropertyTypeDaoImpl;
import com.zm.ams.dto.PropertyType;
import com.zm.ams.services.PropertyTypeService;

public class PropertyTypeServiceImpl implements PropertyTypeService {

	AmsDao<PropertyType, ?> dao = new PropertyTypeDaoImpl();
	
	@Override
	public List<PropertyType> getAll() throws SQLException {
		return dao.getAll();
	}

	@Override
	public Optional<PropertyType> get(int id) throws SQLException {
		return dao.get(id);
	}

}
