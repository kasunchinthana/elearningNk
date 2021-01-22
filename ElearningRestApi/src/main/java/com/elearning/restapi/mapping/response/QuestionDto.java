package com.elearning.restapi.mapping.response;


import lombok.Data;

@Data
public class QuestionDto {
	
	private Integer questionId;
	private String question;
	private String type;
	private String correctAnswer;
	private String hint;
	private Integer assingnmentId;

}
