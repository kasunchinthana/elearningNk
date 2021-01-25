package com.elearning.restapi.mapping.transformer;

import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.response.TeacherDto;
import com.elearning.restapi.model.Grade;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.Teacher;

@Service
public class TeacherDetailsTransformer  {

	public Teacher transformToDao(TeacherDto teacherDto) {
		
		Teacher teacher = new Teacher();
		teacher.setFirstName(teacherDto.getSummary().getFirstName());
		teacher.setLastName(teacherDto.getSummary().getLastName());

		return teacher;
	}
}
