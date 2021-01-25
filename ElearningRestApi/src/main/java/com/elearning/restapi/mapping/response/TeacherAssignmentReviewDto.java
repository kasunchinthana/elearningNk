package com.elearning.restapi.mapping.response;

import org.springframework.web.bind.annotation.PathVariable;

import lombok.Data;

@Data
public class TeacherAssignmentReviewDto {

	private Integer studentId;
	private Integer assignmentId;
	private Integer questionId;
	private String review;
}
