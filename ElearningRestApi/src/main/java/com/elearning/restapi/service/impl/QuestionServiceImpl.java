package com.elearning.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.dao.AssignmentRepository;
import com.elearning.restapi.dao.QuestionRepository;
import com.elearning.restapi.dao.StudentRepository;
import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.transformer.AssignmentDetailsTransformer;
import com.elearning.restapi.mapping.transformer.QuestionDetailsTransformer;
import com.elearning.restapi.mapping.transformer.StudentDetailsTransformer;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Question;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.AssignmentService;
import com.elearning.restapi.service.QuestionService;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.utils.Constants;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionDetailsTransformer questionDetailsTransformer;
	


	@Override
	public ResponsePack<QuestionDto> createQuestion(RequestWrapper<QuestionDto> question) throws Exception {
		ResponsePack<QuestionDto> res = new ResponsePack<QuestionDto>();
		Status status = new Status();
		Question savedQuestion = null;
		try {
			if (question.getPayload() != null){
				Question questionDb = questionDetailsTransformer.transformToDao(question.getPayload());	
				savedQuestion = questionRepository.save(questionDb);
			} else {
				status.setCode(Constants.NOTFOUND);
				res.setStatus(status);
			}
			
			if (savedQuestion.getQuestionId() != null) {
				status.setCode(Constants.CREATED);
				res.setStatus(status);
				return res;
			}else {
				status.setCode(Constants.ERROR);
				res.setStatus(status);
				return res;
			}
		}catch(Exception ex) {
			throw ex;
		}
	}


	@Override
	public ResponsePack<QuestionDto> deleteQuestionById(Integer id) throws Exception {
		ResponsePack<QuestionDto> res = new ResponsePack<QuestionDto>();
		Status status = new Status();
		try {			
			questionRepository.deleteById(id);
			status.setCode(200);
			status.setMessage("OK");
			res.setStatus(status);
		}catch(Exception ex){
			throw ex;
		}
		return res;
	}


	@Override
	public ResponsePack<QuestionDto> updateQuestion(Integer id, RequestWrapper<QuestionDto> questionDto)
			throws Exception {
		ResponsePack<QuestionDto> res = new ResponsePack<QuestionDto>();
		Status status = new Status();
		Question savedQuestion = null;
		try {
			Question questionFromDB= null;
			Optional<Question> question = questionRepository.findById(id);
			if (question.isPresent()) {
				questionFromDB = question.get();
				 // get payload assignment obj here
				Question questionfromFront = questionDetailsTransformer.transformToDao(questionDto.getPayload()); 
				
				if(questionfromFront.getCorrectAnswer()!= null ) {
					questionFromDB.setCorrectAnswer(questionfromFront.getCorrectAnswer());
				}
				if(questionfromFront.getHint()!= null ) {
					questionFromDB.setHint(questionfromFront.getHint());
				}
				if(questionfromFront.getQuestion()!= null ) {
					questionFromDB.setQuestion(questionfromFront.getQuestion());
				}
				if(questionfromFront.getType()!= null ) {
					questionFromDB.setType(questionfromFront.getType());
				}			
				savedQuestion = questionRepository.save(questionFromDB);
				status.setCode(Constants.CREATED);
				res.setStatus(status);
				return res;
			} else {
				status.setCode(Constants.NOTFOUND);
				res.setStatus(status);
			}
			
			
		}catch(Exception ex) {
			throw ex;
		}
		return res;
	}	
	
}
