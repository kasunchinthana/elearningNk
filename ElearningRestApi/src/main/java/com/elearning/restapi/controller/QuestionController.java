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
import com.elearning.restapi.utils.Constants;

@RestController
@RequestMapping("/elearning-service/v1")
@CrossOrigin
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	

	@PostMapping("/question")
	public ResponseEntity<ResponsePack<QuestionDto>> createQuestion(
			@RequestBody RequestWrapper<QuestionDto> payload) {
		ResponsePack<QuestionDto> responseQuestioDto = null;
		try {
			responseQuestioDto = questionService.createQuestion(payload);
			if (responseQuestioDto != null) {
				return new ResponseEntity<ResponsePack<QuestionDto>>(responseQuestioDto, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ResponsePack<QuestionDto>>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<ResponsePack<QuestionDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@DeleteMapping("/question/{id}")
	public ResponseEntity<ResponsePack<QuestionDto>> deleteQuestionById(@PathVariable("id") Integer id) {
		ResponsePack<QuestionDto> questionDto = new ResponsePack<>();
		try {
			questionDto = questionService.deleteQuestionById(id);
			if (questionDto != null) {
				return new ResponseEntity<ResponsePack<QuestionDto>>(questionDto, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<ResponsePack<QuestionDto>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/question/{id}")
	public ResponseEntity<ResponsePack<QuestionDto>> updateQuestion(@PathVariable("id") Integer id,
			@RequestBody RequestWrapper<QuestionDto> payload) {
		ResponsePack<QuestionDto> updateQuestion = null;
		try {
			updateQuestion = questionService.updateQuestion(id, payload);
			if (updateQuestion != null) {
				return new ResponseEntity<ResponsePack<QuestionDto>>(updateQuestion, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ResponsePack<QuestionDto>>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<ResponsePack<QuestionDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
