package com.zm.ams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AppraisalLoc implements ValidDto {

	private int locId;
	private String state;
	private String city;
	
	
	public AppraisalLoc(String state, String city) {
		super();
		this.state = state;
		this.city = city;
	}
	
	
	
}
