package com.elearning.restapi.service;

import java.util.List;

import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Student;

public interface StudentService {
  
  ResponsePack<StudentDto> getAllStudent();
}
