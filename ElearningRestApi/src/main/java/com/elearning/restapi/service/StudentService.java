package com.elearning.restapi.service;

import java.util.List;

import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.StudentAssignmentAnswersDto;
import com.elearning.restapi.mapping.response.StudentAssignmentDto;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Student;

public interface StudentService {

  ResponsePack<StudentDto> createStudent(RequestWrapper<StudentDto> payload) throws Exception;

  ResponsePack<StudentDto> getStudentById(Integer id) throws Exception;

  ResponsePack<StudentDto> updateStudent(Integer id, RequestWrapper<StudentDto> payload);

  ResponsePack<StudentAssignmentAnswersDto> getStudentAssignment(Integer studetnId, Integer assignmentId) throws Exception;

  ResponsePack<StudentAssignmentAnswersDto> updateStudentAssignmentAnswers(Integer studentId, Integer assignmentId,
		RequestWrapper<StudentDto> payload);

  ResponsePack<StudentAssignmentDto> createStudentAssignment(Integer studentId, Integer assignmentId,RequestWrapper<StudentAssignmentDto> payload);

  ResponsePack<StudentAssignmentAnswersDto> createStudentAssignmentAnswer(Integer studentId, Integer assignmentId,
		RequestWrapper<StudentAssignmentAnswersDto> payload);

}
