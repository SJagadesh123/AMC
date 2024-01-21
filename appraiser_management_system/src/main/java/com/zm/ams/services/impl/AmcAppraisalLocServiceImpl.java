package com.zm.ams.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dao.jdbc.impl.AmcAppraisalLocDaoImpl;
import com.zm.ams.dto.AmcAppraisalLoc;
import com.zm.ams.dto.AppraisalLoc;
import com.zm.ams.services.AmcAppraisalLocService;

public class AmcAppraisalLocServiceImpl implements AmcAppraisalLocService {

	
	AmcAppraisalLocDaoImpl dao = new AmcAppraisalLocDaoImpl();
	
	@Override
	public void save(AmcAppraisalLoc amcAppraisalLoc) throws SQLException {
		
		dao.save(amcAppraisalLoc);
	}

	@Override
	public boolean isExist(AmcAppraisalLoc amcAppraisalLoc) throws SQLException {
		return dao.isExist(amcAppraisalLoc);
	}

	@Override
	public List<AppraisalLoc> getLocIdByAmc(int amcId) throws SQLException {
		
		
		return dao.getLocIdByAmcId(amcId);
	}

}
