package com.elearning.restapi.service;

import java.util.List;

import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Student;

public interface StudentService {

  ResponsePack<StudentDto> createStudent(RequestWrapper<StudentDto> payload) throws Exception;

  ResponsePack<StudentDto> getStudentById(Integer id) throws Exception;

  ResponsePack<StudentDto> updateStudent(Integer id, RequestWrapper<StudentDto> payload);
}
