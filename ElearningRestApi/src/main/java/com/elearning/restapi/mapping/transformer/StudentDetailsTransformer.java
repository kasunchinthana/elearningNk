package com.elearning.restapi.mapping.transformer;

import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.response.StudentSummaryDto;
import com.elearning.restapi.model.Grade;
import com.elearning.restapi.model.Student;

@Service
public class StudentDetailsTransformer {
	
	public StudentDto transform(Student student) {
		
		StudentDto studentDto = new StudentDto();
		StudentSummaryDto studentSummaryDto = new StudentSummaryDto();
		studentSummaryDto.setStudentId(student.getStudentId());
		studentSummaryDto.setFirstName(student.getFirstName());
		studentDto.setSummary(studentSummaryDto);
		return studentDto;
		
	}

	public Student transformToDao(StudentDto studentDto) {
		
		Student student = new Student();
		student.setFirstName(studentDto.getSummary().getFirstName());
		student.setLastName(studentDto.getSummary().getLastName());
		Grade grade = new Grade();
		grade.setGradeId(studentDto.getSummary().getGrade());
		student.setGrade(grade);
		return student;
	}

}
