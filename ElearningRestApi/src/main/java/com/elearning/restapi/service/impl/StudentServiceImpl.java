package com.elearning.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.dao.AssignmentRepository;
import com.elearning.restapi.dao.StudentAssignmentAnswerRepository;
import com.elearning.restapi.dao.StudentAssignmentRepository;
import com.elearning.restapi.dao.StudentRepository;
import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentAssignmentAnswersDto;
import com.elearning.restapi.mapping.response.StudentAssignmentDto;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.transformer.StudentAssignmentTransformer;
import com.elearning.restapi.mapping.transformer.StudentDetailsTransformer;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.StudentAssignment;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.utils.Constants;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentDetailsTransformer studentDetailsTransformer;
	
	@Autowired
	private StudentAssignmentAnswerRepository studentAssignmentAnswerRepository;
	
	@Autowired
	private StudentAssignmentRepository studentAssignmentRepository;
	
	@Autowired
	private StudentAssignmentTransformer studentAssignmentTransformer;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	
	@Override
	public ResponsePack<StudentDto> createStudent(RequestWrapper<StudentDto> student) throws Exception {
		ResponsePack<StudentDto> res = new ResponsePack<StudentDto>();
		Status status = new Status();
		Student savedStudent = null;
		try {
			if (student.getPayload() != null){
				Student studentDb = studentDetailsTransformer.transformToDao(student.getPayload());	
				savedStudent = studentRepository.save(studentDb);
			} else {
				status.setCode(Constants.NOTFOUND);
				res.setStatus(status);
			}
			
			if (savedStudent.getStudentId() != null) {
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
	public ResponsePack<StudentDto> getStudentById(Integer id) throws Exception {
		ResponsePack<StudentDto> res = new ResponsePack<StudentDto>();
		try {
			Student studentFromDB= null;
			Optional<Student> student = studentRepository.findById(id);
			if (student.isPresent()) {
				studentFromDB = student.get();
			} else {
				studentFromDB = null;
			}				
			StudentDto studentDto =studentDetailsTransformer.transform(studentFromDB);
			List<StudentDto> dtoList = new ArrayList<StudentDto>();
			dtoList.add(studentDto);
			res.setData(dtoList);
			
			return res;
		}catch(Exception ex) {
			throw ex;
		}
	}

	
	@Override
	public ResponsePack<StudentDto> updateStudent(Integer id, RequestWrapper<StudentDto> studentDto) {
		ResponsePack<StudentDto> res = new ResponsePack<StudentDto>();
		Status status = new Status();
		Student savedStudent = null;
		try {
			Student studentFromDB= null;
			Optional<Student> student = studentRepository.findById(id);
			if (student.isPresent()) {
				studentFromDB = student.get();
				 // get payload assignment obj here
				Student studentfromFront = studentDetailsTransformer.transformToDao(studentDto.getPayload()); 
				
				if(studentfromFront.getFirstName()!= null ) {
					studentFromDB.setFirstName(studentfromFront.getFirstName());
				}
				if(studentfromFront.getLastName()!= null ) {
					studentFromDB.setLastName(studentfromFront.getLastName());
				}
				if(studentfromFront.getGrade().getGradeName() != null ) {
					studentfromFront.getGrade().setGradeName(studentfromFront.getGrade().getGradeName());
					//studentFromDB.setGrade(studentfromFront.getGrade());
				}								
				savedStudent = studentRepository.save(studentFromDB);
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


	@Override
	public ResponsePack<StudentAssignmentAnswersDto> getStudentAssignment(Integer studetnId, Integer assignmentId)
			throws Exception {
		ResponsePack<StudentAssignmentAnswersDto> res = new ResponsePack<StudentAssignmentAnswersDto>();
		try {
		Student assignmentList = studentRepository.findByStudentAssignmentAnswer(studetnId);
		
		List<AssignmentDto> assignmentDtoList = new ArrayList<AssignmentDto>();
			/*
			 * for (Assignment assignment : assignmentList) { AssignmentDto assignmentDto
			 * =assignmentDetailsTransformer.transform(assignment);
			 * assignmentDtoList.add(assignmentDto); } res.setData(assignmentDtoList);
			 */
		return res;
		}catch(Exception ex) {
			throw ex;
		}
	}


	@Override
	public ResponsePack<StudentAssignmentAnswersDto> updateStudentAssignmentAnswers(Integer studentId,
			Integer assignmentId, RequestWrapper<StudentDto> payload) {
		ResponsePack<StudentAssignmentAnswersDto> res = new ResponsePack<StudentAssignmentAnswersDto>();
		
		//sAAres= studentAssignmentAnswerRepository.save(entity)
		return null;
	}


	@Override
	public ResponsePack<StudentAssignmentDto> createStudentAssignment(Integer studentId,Integer assignmentId,RequestWrapper<StudentAssignmentDto> studentAssignment) {
		ResponsePack<StudentAssignmentDto> res = new ResponsePack<StudentAssignmentDto>();
		Status status = new Status();
		StudentAssignment savedStudentAssignment = null;
		try {
			if (studentAssignment.getPayload() != null){
				
				Student studentFromDB= null;
				Optional<Student> student = studentRepository.findById(studentId);
				if (student.isPresent()) {
					studentFromDB = student.get();
				} else {
					studentFromDB = null;
				}
				
				Assignment assignmentFromDB= null;
				Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
				if (assignment.isPresent()) {
					assignmentFromDB = assignment.get();
				}
				StudentAssignment studentAssignment2 = studentAssignmentTransformer.transformToDao(studentFromDB,assignmentFromDB,studentAssignment.getPayload());	
				savedStudentAssignment = studentAssignmentRepository.save(studentAssignment2);
			} else {
				status.setCode(Constants.NOTFOUND);
				res.setStatus(status);
			}
			
			if (savedStudentAssignment.getId() != null) {
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
}
