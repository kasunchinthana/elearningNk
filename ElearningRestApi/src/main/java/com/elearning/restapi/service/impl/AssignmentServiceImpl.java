package com.elearning.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.dao.AssignmentRepository;
import com.elearning.restapi.dao.StudentRepository;
import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.transformer.AssignmentDetailsTransformer;
import com.elearning.restapi.mapping.transformer.StudentDetailsTransformer;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.AssignmentService;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.utils.Constants;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private AssignmentDetailsTransformer assignmentDetailsTransformer;
	
	
	@Override
	public ResponsePack<AssignmentDto> getAllAssignment() {
		ResponsePack<AssignmentDto> res = new ResponsePack<AssignmentDto>();
		try {
		List<Assignment> assignmentList = assignmentRepository.findAll();
		
		List<AssignmentDto> assignmentDtoList = new ArrayList<AssignmentDto>();
		for (Assignment assignment : assignmentList) {
			AssignmentDto assignmentDto =assignmentDetailsTransformer.transform(assignment);
			assignmentDtoList.add(assignmentDto);
		}
		
		res.setData(assignmentDtoList);
		
		return res;
		}catch(Exception ex) {
			throw ex;
		}
	}

	

	@Override
	public ResponsePack<AssignmentDto> createAssignment(RequestWrapper<Payload<AssignmentDto>> assignmentDto) {
		ResponsePack<AssignmentDto> res = new ResponsePack<AssignmentDto>();
		Status status = new Status();
		//Assignment assignment = assignmentDetailsTransformer.transformToDao(assignmentDto.getPayload());
		Assignment assignment = new Assignment();
		Assignment savedAssignment = assignmentRepository.save(assignment);
		if (savedAssignment.getAssingnmentId() != null) {
			status.setCode(Constants.CREATED);
			res.setStatus(status);
			return res;
		}else {
			status.setCode(Constants.ERROR);
			res.setStatus(status);
			return res;
		}
		//AssignmentDto responseAssignmentDto =assignmentDetailsTransformer.transform(savedAssignment);
		
		
	}
	
	
}
