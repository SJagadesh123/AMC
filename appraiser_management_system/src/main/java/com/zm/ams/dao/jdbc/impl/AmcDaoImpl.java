package com.zm.ams.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zm.ams.config.ConnectionFactory;
import com.zm.ams.dao.AmsDao;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.dto.AppraisalManagementCompany;

public class AmcDaoImpl implements AmsDao<AppraisalManagementCompany, AmcSearchCriteria> {

	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;

	public AmcDaoImpl() {
		super();
		connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public Optional<AppraisalManagementCompany> get(int id) throws SQLException {
		
		preparedStatement = connection
				.prepareStatement("select amc_name from ams.amc where amc_id = ?");
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
		{
			return Optional.of(new AppraisalManagementCompany(rs.getString(1)));
			
		}
		
		return Optional.empty();
	}

	@Override
	public List<AppraisalManagementCompany> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraisalManagementCompany> getBySearchCriteria(AmcSearchCriteria criteria) throws SQLException {

		
		List<AppraisalManagementCompany> amcSearchResult = new ArrayList<AppraisalManagementCompany>();
		
		String sql = "select distinct(ams.amc.amc_id), ams.amc.amc_name,ams.amc.state,"
				+ "ams.amc.city, ams.amc.active "
				+ "from ams.amc inner join ams.amc_appraisal_loc "
				+ "on ams.amc.amc_id = ams.amc_appraisal_loc.amc_id "
				+ "inner join ams.appraisal_loc on "
				+ "ams.amc_appraisal_loc.loc_id = ams.appraisal_loc.loc_id "
				+"where 1 = 1 ";
		
		
		if(criteria.getAmcName()!=null)
		{
			sql = sql + "and ams.amc.amc_name like '%" + criteria.getAmcName().toLowerCase() + "%'" ;
			
		}
		if(criteria.getState()!=null)
		{
			
			sql = sql + " and ams.appraisal_loc.state = '"+criteria.getState().toLowerCase()+"'";
		}
		if(criteria.getCity()!=null)
		{
			sql = sql + " and ams.appraisal_loc.city like '%"+criteria.getCity().toLowerCase()+"%'";
			
		}
		
		sql = sql+"order by amc.amc_name";
		
		statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		
		
		while(rs.next())
		{
			
			amcSearchResult.add(new AppraisalManagementCompany(rs.getInt(1),
					rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		
	
		
		return amcSearchResult;
	}

	@Override
	public void save(AppraisalManagementCompany t) throws SQLException {

		
		String sql = "insert into ams.amc "
				+ "(amc_reg_id,amc_name,amc_remarks,addr_line1,addr_line2,"
				+ "state,city,zip_code,created_by,updated_by,active)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?);";
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, t.getAmcRegId());
		preparedStatement.setString(2, t.getAmcName());
		preparedStatement.setString(3, t.getRemarks());
		preparedStatement.setString(4, t.getAddressLine1());
		preparedStatement.setString(5, t.getAddressLine2());
		preparedStatement.setString(6, t.getState());
		preparedStatement.setString(7, t.getCity());
		preparedStatement.setInt(8, t.getZipcode());
		preparedStatement.setInt(9, 1);
		preparedStatement.setInt(10, 1);
		preparedStatement.setString(11, t.getActive());
		
		
		
		System.out.println(preparedStatement.executeUpdate());
	}

	@Override
	public void update(AppraisalManagementCompany t, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AppraisalManagementCompany t) {
		// TODO Auto-generated method stub
		
	}

	public List<String> getAmcName() throws SQLException
	{
		List<String> amcNames = new ArrayList<String>();
		
		preparedStatement = connection.prepareStatement("select amc_name from ams.amc");
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next())
		{
			amcNames.add(rs.getString(1));
		}
		
		return amcNames;
	}

	@Override
	public int getId(AppraisalManagementCompany t) throws SQLException {
		
		int id = 0;

		preparedStatement = connection.prepareStatement("select amc_id from ams.amc where amc_name = ?");
		
		preparedStatement.setString(1, t.getAmcName());
		ResultSet rs = preparedStatement.executeQuery();		
		if(rs.next())
		{
			id = rs.getInt(1);
		}
		
		return id;
	}

	@Override
	public boolean isExist(AppraisalManagementCompany t) {

		return false;
	}
	
	
}
