package com.elearning.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.dao.StudentRepository;
import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.transformer.StudentDetailsTransformer;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.utils.Constants;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentDetailsTransformer studentDetailsTransformer;
	
	
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
				if(studentfromFront.getGrade() != null ) {
					studentFromDB.setGrade(studentfromFront.getGrade());
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
}
