package com.elearning.restapi.service;

import java.util.List;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;

public interface AssignmentService {
  
  ResponsePack<AssignmentDto> getAllAssignment() throws Exception; 

  ResponsePack<AssignmentDto> createAssignment(RequestWrapper<AssignmentDto> payload);

  ResponsePack<AssignmentDto> getAssignmentsById(Integer id) throws Exception;

  ResponsePack<AssignmentDto> deleteAssignmentById(Integer id) throws Exception;

  ResponsePack<AssignmentDto> updateAssignment(Integer id, RequestWrapper<Payload<AssignmentDto>> assignmentDto);
  
  
}
