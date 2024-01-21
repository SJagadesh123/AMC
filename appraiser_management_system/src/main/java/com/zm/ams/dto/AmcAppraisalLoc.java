package com.zm.ams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AmcAppraisalLoc implements ValidDto {
	
	private int AmcId;
	private int locid;

	
}
