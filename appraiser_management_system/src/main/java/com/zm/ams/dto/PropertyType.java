package com.zm.ams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropertyType implements ValidDto {

	int propertyTypeId;
	String propertyTypeDesc;
	
}
