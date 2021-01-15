package com.elearning.restapi.service;

import java.util.List;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;

public interface QuestionService {
  

  ResponsePack<QuestionDto> createQuestion(RequestWrapper<QuestionDto> payload) throws Exception;

  ResponsePack<QuestionDto> deleteQuestionById(Integer id) throws Exception;

  ResponsePack<QuestionDto> updateQuestion(Integer id, RequestWrapper<QuestionDto> questionDto) throws Exception;
      
}
