package com.elearning.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.StudentService;

@RestController
@RequestMapping("/elearning-service/v1")
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/*
	 * @GetMapping("/students") public List<Student> getAllStudents() {
	 * 
	 * return studentService.getAllStudents();
	 * 
	 * }
	 */
	
	@GetMapping("/students") 
	public ResponsePack<StudentDto> getAllStudents() {
		ResponsePack<StudentDto> studentDtoLlist = new ResponsePack<>();
		studentDtoLlist=studentService.getAllStudent();
		Status responseStatus = new Status();
		responseStatus.setCode(200);
		responseStatus.setMessage("ok");
		studentDtoLlist.setStatus(responseStatus);
		
		return studentDtoLlist;
	}

}
