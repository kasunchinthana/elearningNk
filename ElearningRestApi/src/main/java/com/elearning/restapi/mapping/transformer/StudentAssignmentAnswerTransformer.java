package com.elearning.restapi.mapping.transformer;

import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.StudentAssignmentAnswersDto;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Question;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.StudentAssignmentAnswer;

@Service
public class StudentAssignmentAnswerTransformer {
	
	public StudentAssignmentAnswer transformToDao(Student student,Assignment assignment,Question question,StudentAssignmentAnswersDto studentAssignmentAnswersDto) {
		
		StudentAssignmentAnswer studentAssignmentAnswer = new StudentAssignmentAnswer();
		studentAssignmentAnswer.setAssignment(assignment);
		studentAssignmentAnswer.setStudent(student);
		studentAssignmentAnswer.setAnswer(studentAssignmentAnswersDto.getAnswer());
		studentAssignmentAnswer.setQuestion(question);
		return studentAssignmentAnswer;
	}

}
