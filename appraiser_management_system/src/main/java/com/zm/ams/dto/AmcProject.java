package com.zm.ams.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AmcProject implements ValidDto {

	int projectId;
	int amcId;
	int propertyTypeId;
	String projectClient;
	String projectRemarks;
	String clientRemarks;
	java.sql.Date startDate;
	java.sql.Date endDate;
	double estimatedValue;
	int locId;
	
	public AmcProject(int amcId, int projectTypeId, String projectClient, String projectRemarks, String clientRemarks,
			Date startDate, Date endDate, double estimatedValue, int locId) {
		super();
		this.amcId = amcId;
		this.propertyTypeId = projectTypeId;
		this.projectClient = projectClient;
		this.projectRemarks = projectRemarks;
		this.clientRemarks = clientRemarks;
		this.startDate = startDate;
		this.endDate = endDate;
		this.estimatedValue = estimatedValue;
		this.locId = locId;
	}
	
	
	
	
}
