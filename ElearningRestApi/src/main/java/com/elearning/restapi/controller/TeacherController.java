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
import com.elearning.restapi.mapping.response.StudentAssignmentAnswersDto;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.response.TeacherAssignmentReviewDto;
import com.elearning.restapi.mapping.response.TeacherDto;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.AssignmentService;
import com.elearning.restapi.service.QuestionService;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.service.TeacherService;
import com.elearning.restapi.utils.Constants;

@RestController
@RequestMapping("/elearning-service/v1")
public class TeacherController {

	
	  @Autowired 
	  private TeacherService teacherService;
	  
	  @PostMapping("/teacher")
		public ResponseEntity<ResponsePack<TeacherDto>> createTeacher(@RequestBody RequestWrapper<TeacherDto> payload) {
			ResponsePack<TeacherDto> responseTeacherDto = null;
			try {
				responseTeacherDto = teacherService.createTeacher(payload);
				if (responseTeacherDto != null) {
					return new ResponseEntity<ResponsePack<TeacherDto>>(responseTeacherDto, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<ResponsePack<TeacherDto>>(HttpStatus.FORBIDDEN);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return new ResponseEntity<ResponsePack<TeacherDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	    
	  @PostMapping("/teacher/{teacherId}/student/{studentId}/assignment/{assignmentId}/questionId/{questionId}/review")
	  public ResponseEntity<ResponsePack<TeacherAssignmentReviewDto>> createAssignmrntReview(@PathVariable("teacherId") Integer teacherId,
			  @PathVariable("studentId") Integer studentId,
			  @PathVariable("assignmentId") Integer assignmentId,
			  @PathVariable("questionId") Integer questionId,
			  @RequestBody RequestWrapper<TeacherAssignmentReviewDto> payload)
	  { 
		  ResponsePack<TeacherAssignmentReviewDto> teacherAssignmentReviewDto = null; 
	  try { 
		  teacherAssignmentReviewDto = teacherService.createAssignmrntReview(teacherId,studentId,assignmentId,questionId, payload);	  
		  if (teacherAssignmentReviewDto != null) {
			  return new ResponseEntity<ResponsePack<TeacherAssignmentReviewDto>>(teacherAssignmentReviewDto, HttpStatus.CREATED); 
		  } else {
			  return new ResponseEntity<ResponsePack<TeacherAssignmentReviewDto>>(HttpStatus.FORBIDDEN); 
			  } 
		  } catch (Exception e) { // TODO Auto-generated catch block return new
			  return new ResponseEntity<ResponsePack<TeacherAssignmentReviewDto>> (HttpStatus.INTERNAL_SERVER_ERROR);
		  } 
	  }
	 

}
