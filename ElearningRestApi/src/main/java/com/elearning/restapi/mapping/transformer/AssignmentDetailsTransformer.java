package com.elearning.restapi.mapping.transformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.AssignmentSummaryDto;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.QuestionSummaryDto;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Question;
import com.elearning.restapi.model.Subject;

@Service
public class AssignmentDetailsTransformer {
	
	@Autowired
	QuestionDetailsTransformer questionDetailsTransformer;
	
	public AssignmentDto transform(Assignment assignment) {
		
		if(assignment != null) {
			AssignmentDto assignmentDto = new AssignmentDto();
			AssignmentSummaryDto assignmentSummaryDto = new AssignmentSummaryDto();
			assignmentSummaryDto.setAssingnmentId(assignment.getAssingnmentId());
			assignmentSummaryDto.setName(assignment.getName());
			assignmentSummaryDto.setCutoffMarks(assignment.getCutoffMarks());			
			assignmentSummaryDto.setDescription(assignment.getDescription());
			assignmentSummaryDto.setDevDate(assignment.getDevDate());
			assignmentSummaryDto.setDuration(assignment.getDuration());
			assignmentSummaryDto.setStatus(assignment.getStatus());
			assignmentSummaryDto.setTotalMarks(assignment.getTotalMarks());
			
			assignmentDto.setSummary(assignmentSummaryDto);
			return assignmentDto;
		} else {
			return null;
		}
		
		
	}

	public Assignment transformToDao(AssignmentDto assignmentDto) {
		
		Assignment assignment = new Assignment();
		
		assignment.setAssingnmentId(assignmentDto.getSummary().getAssingnmentId());
		assignment.setCutoffMarks(assignmentDto.getSummary().getCutoffMarks());
		assignment.setDescription(assignmentDto.getSummary().getDescription());
		assignment.setDevDate(assignmentDto.getSummary().getDevDate());
		assignment.setDuration(assignmentDto.getSummary().getDuration());
		assignment.setName(assignmentDto.getSummary().getName());
		assignment.setStatus(assignmentDto.getSummary().getStatus());
		assignment.setTotalMarks(assignmentDto.getSummary().getTotalMarks());
		Subject subject = new Subject();
		
		
		subject.setSubjectCode(assignmentDto.getSummary().getSubjectCode());
		subject.setSubjectName(assignmentDto.getSummary().getSubjectName());
		assignment.setSubject(subject);
		
		if(null != assignmentDto.getQuestions()) {
			List<Question> questionList = new ArrayList<Question>();
		//Question question = null;
		for (QuestionDto questionDto : assignmentDto.getQuestions()) {
			Question  question = questionDetailsTransformer.transformToDao(questionDto);
			
			questionList.add(question);			
		}
		assignment.setQuestion(questionList);
		}
		if(null != assignmentDto.getSummary().getTeacherId()) {
			List<Question> questionList = new ArrayList<Question>();
		}
		return assignment;
		
	}
	
}
