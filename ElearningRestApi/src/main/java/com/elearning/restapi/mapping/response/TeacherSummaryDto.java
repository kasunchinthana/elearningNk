package com.elearning.restapi.mapping.response;

import lombok.Data;

@Data
public class TeacherSummaryDto {
	
	private int studentId;
	private String firstName;
	private String lastName;

}
