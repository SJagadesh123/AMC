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
import com.zm.ams.dto.AmcProject;
import com.zm.ams.dto.AmcSearchCriteria;

public class AmcProjectDaoImpl implements AmsDao<AmcProject, AmcSearchCriteria> {

	Connection connection;
	PreparedStatement preparedStatement;

	public AmcProjectDaoImpl() {
		super();
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Optional<AmcProject> get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<AmcProject> getAll() throws SQLException {

		return null;
	}

	@Override
	public List<AmcProject> getBySearchCriteria(AmcSearchCriteria criteria) throws SQLException {

		List<AmcProject> projectList = new ArrayList<AmcProject>();

		preparedStatement = connection
				.prepareStatement("select * from ams.amc_project where amc_id = ?");

		preparedStatement.setInt(1, criteria.getAmcId());
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next())
		{
			projectList.add(new AmcProject(rs.getInt(1), 
										   rs.getInt(2), 
										   rs.getInt(3), 
										   rs.getString(4), 
										   rs.getString(5), 
										   rs.getString(6), 
										   rs.getDate(7), 
										   rs.getDate(8), 
										   rs.getDouble(9), 
										   rs.getInt(10)));
		}

		return projectList;

	}

	@Override
	public void save(AmcProject t) throws SQLException {

		preparedStatement = connection.prepareStatement(
				"insert into ams.amc_project (amc_id,prop_type_id,proj_client," + "proj_remarks,client_remarks,"
						+ "proj_start_dt,proj_end_dt,estimate_value,loc_id) values(?,?,?,?,?,?,?,?,?)");

		preparedStatement.setInt(1, t.getAmcId());
		preparedStatement.setInt(2, t.getPropertyTypeId());
		preparedStatement.setString(3, t.getProjectClient());
		preparedStatement.setString(4, t.getProjectRemarks());
		preparedStatement.setString(5, t.getClientRemarks());
		preparedStatement.setDate(6, t.getStartDate());
		preparedStatement.setDate(7, t.getEndDate());
		preparedStatement.setDouble(8, t.getEstimatedValue());
		preparedStatement.setInt(9, t.getLocId());

		preparedStatement.executeUpdate();

	}

	@Override
	public void update(AmcProject t, String... params) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AmcProject t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getId(AmcProject t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isExist(AmcProject t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
