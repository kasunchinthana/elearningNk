package com.elearning.restapi.service;

import java.util.List;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.TeacherAssignmentReviewDto;
import com.elearning.restapi.mapping.response.TeacherDto;


public interface TeacherService {
  


  ResponsePack<TeacherAssignmentReviewDto> createAssignmrntReview(Integer teacherId,Integer studentId, Integer assignmentId, Integer questionId,
		RequestWrapper<TeacherAssignmentReviewDto> payload);

  ResponsePack<TeacherDto> createTeacher(RequestWrapper<TeacherDto> payload);
      
}
