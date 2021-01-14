package com.elearning.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.dao.StudentRepository;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.transformer.StudentDetailsTransformer;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentDetailsTransformer studentDetailsTransformer;
	
	
	public ResponsePack<StudentDto> getAllStudent() {
		ResponsePack<StudentDto> res = new ResponsePack<StudentDto>();
		List<Student> studentList = studentRepository.findAll();
		
		List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
		for (Student student : studentList) {
			StudentDto studentDto =studentDetailsTransformer.transform(student);
			studentDtoList.add(studentDto);
		}
		
		res.setData(studentDtoList);
		
		return res;
		
	}
}
