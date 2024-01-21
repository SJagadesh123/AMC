package com.zm.ams.services.impl;

import java.sql.SQLException;

import java.util.List;

import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.jdbc.impl.AmcProjectDaoImpl;
import com.zm.ams.dto.AmcProject;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.services.AmcProjectService;

public class AmcProjectServiceImpl implements AmcProjectService {

	AmsDao<AmcProject, AmcSearchCriteria> dao = new AmcProjectDaoImpl();
	
	@Override
	public void save(AmcProject project) throws SQLException {
		
		dao.save(project);
	}

	@Override
	public List<AmcProject> getAll(AmcSearchCriteria criteria) throws SQLException {

		return dao.getBySearchCriteria(criteria);
	}

}
