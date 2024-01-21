package com.zm.ams.dto;

import lombok.Data;

@Data
public class AppraisalManagementCompany implements ValidDto{
	private int amcId;
	private String amcRegId;
	private String amcName;
	private String remarks;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String city;
	private int zipcode;
	private String active;
	
	public AppraisalManagementCompany(String amcRegId, String amcName, String remarks, String addressLine1,
			String addressLine2, String state, String city, int zipcode, String active) {
		super();
		
		this.amcRegId = amcRegId;
		this.amcName = amcName;
		this.remarks = remarks;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.active = active;
	}

	public AppraisalManagementCompany(String amcName) {
		super();
		this.amcName = amcName;
	}

	public AppraisalManagementCompany(int amcId, String amcName, String state, String city, String active) {
		super();
		this.amcId = amcId;
		this.amcName = amcName;
		this.state = state;
		this.city = city;
		this.active = active;
	}
	
	

	

}