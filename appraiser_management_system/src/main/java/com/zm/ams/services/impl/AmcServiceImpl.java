package com.zm.ams.services.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zm.ams.dao.jdbc.impl.AmcDaoImpl;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.dto.AppraisalManagementCompany;
import com.zm.ams.services.AmcService;

public class AmcServiceImpl implements AmcService {
	
	AmcDaoImpl dao = new AmcDaoImpl();

	@Override
	public void save(AppraisalManagementCompany amc) throws SQLException {
		
		dao.save(amc);

	}

	@Override
	public int getId(AppraisalManagementCompany amc) throws SQLException {
		
		return dao.getId(amc);
	}

	@Override
	public List<AppraisalManagementCompany> getBySearchCriteria(AmcSearchCriteria criteria) throws SQLException {
		return dao.getBySearchCriteria(criteria);
	}

	@Override
	public List<String> getAmcNames() throws SQLException {

		return dao.getAmcName();
	}

	@Override
	public Optional<AppraisalManagementCompany> get(int id) throws SQLException {
		
		return dao.get(id);
	}

}
