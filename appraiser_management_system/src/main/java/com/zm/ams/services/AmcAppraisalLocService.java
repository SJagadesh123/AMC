package com.zm.ams.services;

import java.sql.SQLException;

import java.util.List;

import com.zm.ams.dto.AmcAppraisalLoc;
import com.zm.ams.dto.AppraisalLoc;

public interface AmcAppraisalLocService {

	void save(AmcAppraisalLoc amcAppraisalLoc) throws SQLException;

	boolean isExist(AmcAppraisalLoc amcAppraisalLoc) throws SQLException;
	
	List<AppraisalLoc> getLocIdByAmc(int amcId) throws SQLException;
}
