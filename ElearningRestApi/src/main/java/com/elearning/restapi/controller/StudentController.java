package com.elearning.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.utils.Constants;

@RestController
@RequestMapping("/elearning-service/v1")
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping("/students")
	public ResponseEntity<ResponsePack<StudentDto>> createStudent(
			@RequestBody RequestWrapper<StudentDto> payload) {
		ResponsePack<StudentDto> responseStudentDto = null;
		try {
			responseStudentDto = studentService.createStudent(payload);
			if (responseStudentDto != null) {
				return new ResponseEntity<ResponsePack<StudentDto>>(responseStudentDto, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ResponsePack<StudentDto>>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<ResponsePack<StudentDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<ResponsePack<StudentDto>> getStudentById(@PathVariable("id") Integer id) {
		ResponsePack<StudentDto> studentDto = new ResponsePack<>();
		// ResponsePack<AssignmentDto> assignmentDtoLlist = new ResponsePack<>();
		try {
			studentDto = studentService.getStudentById(id);
			if (studentDto != null) {
				return new ResponseEntity<ResponsePack<StudentDto>>(studentDto, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<ResponsePack<StudentDto>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<ResponsePack<StudentDto>> updateStudent(@PathVariable("id") Integer id,
			@RequestBody RequestWrapper<StudentDto> payload) {
		ResponsePack<StudentDto> updatetStudent = null;
		try {
			updatetStudent = studentService.updateStudent(id, payload);
			if (updatetStudent != null) {
				return new ResponseEntity<ResponsePack<StudentDto>>(updatetStudent, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ResponsePack<StudentDto>>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<ResponsePack<StudentDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
