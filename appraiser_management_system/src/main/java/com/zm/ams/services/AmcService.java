package com.zm.ams.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.dto.AppraisalManagementCompany;

public interface AmcService {

	void save(AppraisalManagementCompany amc) throws SQLException;

	int getId(AppraisalManagementCompany amc) throws SQLException;

	List<AppraisalManagementCompany> getBySearchCriteria(AmcSearchCriteria criteria) throws SQLException;

	List<String> getAmcNames() throws SQLException;
	
	Optional<AppraisalManagementCompany> get(int id) throws SQLException;
	

}
