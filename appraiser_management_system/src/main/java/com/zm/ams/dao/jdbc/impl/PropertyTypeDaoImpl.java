package com.zm.ams.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zm.ams.config.ConnectionFactory;
import com.zm.ams.dao.AmsDao;
import com.zm.ams.dto.PropertyType;
import com.zm.ams.dto.SearchCriteria;

public class PropertyTypeDaoImpl implements AmsDao<PropertyType, SearchCriteria> {

	Connection connection;
	PreparedStatement preparedStatement;

	public PropertyTypeDaoImpl() {
		super();
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Optional<PropertyType> get(int id) throws SQLException {
		
		preparedStatement = connection
				.prepareStatement("select * from ams.property_type where type_id = ?");
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next())
		{
			return Optional.of(new PropertyType(rs.getInt(1), rs.getString(2)));
		}
		
		return Optional.empty();
	}

	@Override
	public List<PropertyType> getAll() throws SQLException {
		List<PropertyType> propertyTypeList = new ArrayList<PropertyType>();
		
		preparedStatement = connection.prepareStatement("select * from ams.property_type");
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next())
		{
			propertyTypeList.add(new PropertyType(rs.getInt(1), rs.getString(2)));
		}
		
		return propertyTypeList;
	}

	@Override
	public List<PropertyType> getBySearchCriteria(SearchCriteria criteria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(PropertyType t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PropertyType t, String... params) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PropertyType t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getId(PropertyType t) throws SQLException {

		int id = 0;
		preparedStatement = connection.prepareStatement("select type_id from ams.property_type "
				+ "where type_desc = ?");
		
		preparedStatement.setString(1, t.getPropertyTypeDesc());
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
		{
			id = rs.getInt(1);
		}
		
		return id;
	}

	@Override
	public boolean isExist(PropertyType t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
