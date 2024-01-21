package com.zm.ams.services;

import java.sql.SQLException;

import java.util.List;

import com.zm.ams.dto.AmcProject;
import com.zm.ams.dto.AmcSearchCriteria;

public interface AmcProjectService {

	void save(AmcProject project) throws SQLException;
	
	List<AmcProject> getAll(AmcSearchCriteria criteria) throws SQLException; 
	
	
	
}
