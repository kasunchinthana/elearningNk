package com.elearning.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.dao.AssignmentRepository;
import com.elearning.restapi.dao.StudentRepository;
import com.elearning.restapi.dao.SubjectRepository;
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
import com.elearning.restapi.model.Subject;
import com.elearning.restapi.service.AssignmentService;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.utils.Constants;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private AssignmentDetailsTransformer assignmentDetailsTransformer;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	
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
	public ResponsePack<AssignmentDto> createAssignment(RequestWrapper<AssignmentDto> assignment)  throws Exception{
		ResponsePack<AssignmentDto> res = new ResponsePack<AssignmentDto>();
		Status status = new Status();
		Assignment savedAssignment = null;
		try {
			if (assignment.getPayload() != null){
				Assignment assignmentDb = assignmentDetailsTransformer.transformToDao(assignment.getPayload());	
				if(assignmentDb.getSubject().getSubjectCode() != null) {
					//assignmentFromDB.getSubject().setId(id);
					List<Subject> subjectList = subjectRepository.findBySubjectCode(assignmentDb.getSubject().getSubjectCode());
					if(subjectList.size()>0) {
						Subject subject = subjectList.get(0);				
						assignmentDb.getSubject().setSubjectId(subject.getSubjectId());
						assignmentDb.getSubject().setSubjectCode(assignmentDb.getSubject().getSubjectCode());
						assignmentDb.getSubject().setSubjectName(assignmentDb.getSubject().getSubjectName());
					} else {
						status.setCode(Constants.NOTFOUND);
						res.setStatus(status);
					}
					
				} else {
					status.setCode(Constants.NOTFOUND);
					res.setStatus(status);
				}
				savedAssignment = assignmentRepository.save(assignmentDb);
			} else {
				status.setCode(Constants.NOTFOUND);
				res.setStatus(status);
			}
			
			if (savedAssignment.getAssingnmentId() != null) {
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
		//AssignmentDto responseAssignmentDto =assignmentDetailsTransformer.transform(savedAssignment);
			
	}


	@Override
	public ResponsePack<AssignmentDto> getAssignmentsById(Integer id) throws Exception {
		ResponsePack<AssignmentDto> res = new ResponsePack<AssignmentDto>();
		try {
			Assignment assignmentFromDB= null;
			Optional<Assignment> assignment = assignmentRepository.findById(id);
			if (assignment.isPresent()) {
				 assignmentFromDB = assignment.get();
			} else {
				 assignmentFromDB = null;
			}				
			AssignmentDto assignmentDto =assignmentDetailsTransformer.transform(assignmentFromDB);
			List<AssignmentDto> dtoList = new ArrayList<AssignmentDto>();
			dtoList.add(assignmentDto);
			res.setData(dtoList);
			
			return res;
		}catch(Exception ex) {
			throw ex;
		}
	}


	@Override
	public ResponsePack<AssignmentDto> deleteAssignmentById(Integer id) throws Exception {
		ResponsePack<AssignmentDto> res = new ResponsePack<AssignmentDto>();
		Status status = new Status();
		try {			
			assignmentRepository.deleteById(id);
			status.setCode(200);
			status.setMessage("OK");
			res.setStatus(status);
		}catch(Exception ex){
			throw ex;
		}
		return res;
	}


	@Override
	public ResponsePack<AssignmentDto> updateAssignment(Integer id,
			RequestWrapper<AssignmentDto> assignmentDto)  throws Exception {
		ResponsePack<AssignmentDto> res = new ResponsePack<AssignmentDto>();
		Status status = new Status();
		Assignment savedAssignment = null;
		try {
			Assignment assignmentFromDB= null;
			Optional<Assignment> assignment = assignmentRepository.findById(id);
			if (assignment.isPresent()) {
				 assignmentFromDB = assignment.get();
				 // get payload assignment obj here
				Assignment assignmentfromFront = assignmentDetailsTransformer.transformToDao(assignmentDto.getPayload()); 
				
				if(assignmentfromFront.getCutoffMarks()!= null ) {
					assignmentFromDB.setCutoffMarks(assignmentfromFront.getCutoffMarks());
				}
				if(assignmentfromFront.getDescription()!= null ) {
					assignmentFromDB.setDescription(assignmentfromFront.getDescription());
				}
				if(assignmentfromFront.getDevDate()!= null ) {
					assignmentFromDB.setDevDate(assignmentfromFront.getDevDate());
				}
				if(assignmentfromFront.getDuration()!= null ) {
					assignmentFromDB.setDuration(assignmentfromFront.getDuration());
				}
				if(assignmentfromFront.getName()!= null ) {
					assignmentFromDB.setName(assignmentfromFront.getName());
				}
				if(assignmentfromFront.getStatus()!= null ) {
					assignmentFromDB.setStatus(assignmentfromFront.getStatus());
				}
				if(assignmentfromFront.getTotalMarks()!= null ) {
					assignmentFromDB.setTotalMarks(assignmentfromFront.getTotalMarks());
				}
				if(assignmentfromFront.getSubject().getSubjectCode() != null) {
					//assignmentFromDB.getSubject().setId(id);
					List<Subject> subjectList = subjectRepository.findBySubjectCode(assignmentfromFront.getSubject().getSubjectCode());
					if(subjectList.size()>0) {
						Subject subject = subjectList.get(0);										
						assignmentFromDB.setSubject(subject);
						
						savedAssignment = assignmentRepository.save(assignmentFromDB);
						status.setCode(Constants.CREATED);
						res.setStatus(status);
						return res;
					} else {
						status.setCode(Constants.NOTFOUND);
						res.setStatus(status);
						//throw exception here
						//throw 
					}
					
				} else {
					
					status.setCode(Constants.NOTFOUND);
					res.setStatus(status);
					//throw exception here
				}
				
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
