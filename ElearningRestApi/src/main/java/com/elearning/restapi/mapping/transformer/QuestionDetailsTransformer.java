package com.elearning.restapi.mapping.transformer;

import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.AssignmentSummaryDto;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.QuestionSummaryDto;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.response.StudentSummaryDto;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Grade;
import com.elearning.restapi.model.Question;
import com.elearning.restapi.model.Student;

@Service
public class QuestionDetailsTransformer {
	
	public QuestionDto transform(Question question) {
		
		QuestionDto questionDto = new QuestionDto();
		QuestionSummaryDto questionSummaryDto = new QuestionSummaryDto();
		questionSummaryDto.setQuestionId(question.getQuestionId());
		questionSummaryDto.setCorrectAnswer(question.getCorrectAnswer());
		questionSummaryDto.setHint(question.getHint());
		questionSummaryDto.setQuestion(question.getQuestion());
		questionSummaryDto.setType(question.getType());
		questionDto.setSummary(questionSummaryDto);
		return questionDto;
		
	}

	public Question transformToDao(QuestionDto questionDto) {
		
		Question question = new Question();
		question.setCorrectAnswer(questionDto.getSummary().getCorrectAnswer());
		question.setHint(questionDto.getSummary().getHint());
		question.setQuestion(questionDto.getSummary().getQuestion());
		question.setQuestionId(questionDto.getSummary().getQuestionId());
		question.setType(questionDto.getSummary().getType());
		Assignment assignment = new Assignment();
		assignment.setAssingnmentId(questionDto.getSummary().getAssingnmentId());
		question.setAssignment(assignment);
		return question;
	}

}
