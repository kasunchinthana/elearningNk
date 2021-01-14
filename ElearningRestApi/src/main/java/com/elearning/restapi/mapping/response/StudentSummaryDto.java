package com.elearning.restapi.mapping.response;

import lombok.Data;

@Data
public class StudentSummaryDto {

	private int studentId;
	private String firstName;
	private String lastName;
	private int grade;
}
