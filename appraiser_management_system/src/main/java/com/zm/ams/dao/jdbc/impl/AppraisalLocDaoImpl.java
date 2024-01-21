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
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.dto.AppraisalLoc;


public class AppraisalLocDaoImpl implements AmsDao<AppraisalLoc, AmcSearchCriteria> {

	Connection connection;
	PreparedStatement preparedStatement;

	public AppraisalLocDaoImpl() {
		super();
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Optional<AppraisalLoc> get(int id) throws SQLException {
		preparedStatement = connection
				.prepareStatement("select * from ams.appraisal_loc where loc_id = ?");
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next())
		{
			return Optional.of(new AppraisalLoc(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		
		return Optional.empty();
	}

	@Override
	public List<AppraisalLoc> getAll() throws SQLException {

		List<AppraisalLoc> appraisalLoc = new ArrayList<AppraisalLoc>();
		
		preparedStatement = connection.prepareStatement("select * from ams.appraisal_loc");
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next())
		{
			appraisalLoc.add(new AppraisalLoc(rs.getString(2), rs.getString(3)));
		}
		
		return appraisalLoc;
	}

	@Override
	public List<AppraisalLoc> getBySearchCriteria(AmcSearchCriteria criteria) throws SQLException {

		List<AppraisalLoc> appraisalLoc = new ArrayList<AppraisalLoc>();
		
		preparedStatement = connection.prepareStatement
				("select * from ams.appraisal_loc where state = ? and city = ?");
		
		preparedStatement.setString(1, criteria.getState());
		preparedStatement.setString(2, criteria.getCity());
		
		ResultSet rs = preparedStatement.executeQuery();

		while(rs.next())
		{
			appraisalLoc.add(new AppraisalLoc(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return appraisalLoc;
	}

	@Override
	public void save(AppraisalLoc t) throws SQLException {

		preparedStatement = connection.prepareStatement("insert into ams.appraisal_loc(state,city) values(?,?)");

		preparedStatement.setString(1, t.getState());
		preparedStatement.setString(2, t.getCity());

		preparedStatement.executeUpdate();
	}

	@Override
	public void update(AppraisalLoc t, String... params) {

	}

	@Override
	public void delete(AppraisalLoc t) {

	}

	@Override
	public int getId(AppraisalLoc t) throws SQLException {

		int id = 0 ;
		preparedStatement = connection.prepareStatement("select loc_id from ams.appraisal_loc "
								+"where state = ? and city = ?");
		
		preparedStatement.setString(1, t.getState());
		preparedStatement.setString(2, t.getCity());
		
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
		{
			id = rs.getInt(1);
		}
		
		return id;
	}

	@Override
	public boolean isExist(AppraisalLoc t) throws SQLException {

		preparedStatement = connection.prepareStatement("select loc_id from ams.appraisal_loc "
				+"where state = ? and city = ?");	
		
		preparedStatement.setString(1, t.getState());
		preparedStatement.setString(2, t.getCity());
		
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
		{
			return true;
		}
		
		return false;
		
	}

}
