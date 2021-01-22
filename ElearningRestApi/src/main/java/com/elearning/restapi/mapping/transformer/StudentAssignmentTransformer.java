package com.elearning.restapi.mapping.transformer;

import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.StudentAssignmentDto;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Grade;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.StudentAssignment;

@Service
public class StudentAssignmentTransformer {

	public StudentAssignment transformToDao(Student student,Assignment assignment,StudentAssignmentDto studentAssignmentDto) {
		
		StudentAssignment studentAssignment = new StudentAssignment(student,assignment);
		studentAssignment.setAssignment(assignment);
		studentAssignment.setStudent(student);
		studentAssignment.setDuration(studentAssignmentDto.getDuration());
		return studentAssignment;
	}
}
