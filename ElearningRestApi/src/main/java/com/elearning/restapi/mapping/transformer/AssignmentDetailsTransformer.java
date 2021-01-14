package com.elearning.restapi.mapping.transformer;

import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.AssignmentSummaryDto;
import com.elearning.restapi.model.Assignment;

@Service
public class AssignmentDetailsTransformer {
	
	public AssignmentDto transform(Assignment assignment) {
		
		AssignmentDto assignmentDto = new AssignmentDto();
		AssignmentSummaryDto assignmentSummaryDto = new AssignmentSummaryDto();
		assignmentSummaryDto.setAssingnmentId(assignment.getAssingnmentId());
		assignmentSummaryDto.setName(assignment.getName());
		assignmentSummaryDto.setCutoffMarks(assignment.getCutoffMarks());
		assignmentDto.setSummary(assignmentSummaryDto);
		return assignmentDto;
		
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
		
		return assignment;
		
	}
	
}
