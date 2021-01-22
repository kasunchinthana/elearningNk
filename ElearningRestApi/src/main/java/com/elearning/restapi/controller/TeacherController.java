package com.elearning.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.AssignmentService;
import com.elearning.restapi.service.QuestionService;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.service.TeacherService;
import com.elearning.restapi.utils.Constants;

@RestController
@RequestMapping("/elearning-service/v1")
@CrossOrigin
public class TeacherController {

	/*
	 * @Autowired private TeacherService teacherService;
	 * 
	 * 
	 * 
	 * @PostMapping("/teacher/student/{studentId}/assignment/{assignmentId}/review")
	 * public ResponseEntity<ResponsePack<QuestionDto>>
	 * createQuestion(@PathVariable("studentId") Integer
	 * studentId,@PathVariable("assignmentId") Integer assignmentId,
	 * 
	 * @RequestBody RequestWrapper<QuestionDto> payload) { ResponsePack<QuestionDto>
	 * responseQuestioDto = null; try { responseQuestioDto =
	 * teacherService.createQuestion(payload); if (responseQuestioDto != null) {
	 * return new ResponseEntity<ResponsePack<QuestionDto>>(responseQuestioDto,
	 * HttpStatus.CREATED); } else { return new
	 * ResponseEntity<ResponsePack<QuestionDto>>(HttpStatus.FORBIDDEN); } } catch
	 * (Exception e) { // TODO Auto-generated catch block return new
	 * ResponseEntity<ResponsePack<QuestionDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
	 * } }
	 */

}
