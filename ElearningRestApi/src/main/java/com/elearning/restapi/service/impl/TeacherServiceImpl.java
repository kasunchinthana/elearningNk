package com.elearning.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.restapi.dao.AssignmentRepository;
import com.elearning.restapi.dao.QuestionRepository;
import com.elearning.restapi.dao.StudentAssignmentAnswerRepository;
import com.elearning.restapi.dao.StudentAssignmentRepository;
import com.elearning.restapi.dao.StudentRepository;
import com.elearning.restapi.dao.TeacherAssignmentReviewRepository;
import com.elearning.restapi.dao.TeacherRepository;
import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentAssignmentAnswersDto;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.mapping.response.TeacherAssignmentReviewDto;
import com.elearning.restapi.mapping.response.TeacherDto;
import com.elearning.restapi.mapping.transformer.AssignmentDetailsTransformer;
import com.elearning.restapi.mapping.transformer.QuestionDetailsTransformer;
import com.elearning.restapi.mapping.transformer.StudentAssignmentTransformer;
import com.elearning.restapi.mapping.transformer.StudentDetailsTransformer;
import com.elearning.restapi.mapping.transformer.TeacherAssignmentReviewTransformer;
import com.elearning.restapi.mapping.transformer.TeacherDetailsTransformer;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Question;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.StudentAssignmentAnswer;
import com.elearning.restapi.model.Teacher;
import com.elearning.restapi.model.TeacherAssignmentReview;
import com.elearning.restapi.service.AssignmentService;
import com.elearning.restapi.service.QuestionService;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.service.TeacherService;
import com.elearning.restapi.utils.Constants;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private TeacherAssignmentReviewTransformer teacherAssignmentReviewTransformer;
	
	@Autowired
	private TeacherAssignmentReviewRepository teacherAssignmentReviewRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private TeacherDetailsTransformer teacherDetailsTransformer;
	

	@Override
	public ResponsePack<TeacherAssignmentReviewDto> createAssignmrntReview(Integer teacherId,Integer studentId, Integer assignmentId,
			Integer questionId, RequestWrapper<TeacherAssignmentReviewDto> teacherAssignmentReviw) {
		ResponsePack<TeacherAssignmentReviewDto> res = new ResponsePack<TeacherAssignmentReviewDto>();
		Status status = new Status();
		TeacherAssignmentReview savedTeacherAssignmentReview = null;
		try {
			if (teacherAssignmentReviw.getPayload() != null){
				
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
				Question questionFromDb = null;
				Optional<Question> question = questionRepository.findById(questionId);
				if (question.isPresent()) {
					questionFromDb = question.get();
				}
				
				Teacher teacherFromDB= null;
				Optional<Teacher> teacher = teacherRepository.findById(teacherId);
				if (teacher.isPresent()) {
					teacherFromDB = teacher.get();
				} else {
					teacherFromDB = null;
				}
				
				TeacherAssignmentReview teacherAssignmentReview = teacherAssignmentReviewTransformer.transformToDao(teacherFromDB,studentFromDB,assignmentFromDB,questionFromDb,teacherAssignmentReviw.getPayload());	
				savedTeacherAssignmentReview = teacherAssignmentReviewRepository.save(teacherAssignmentReview);
			} else {
				status.setCode(Constants.NOTFOUND);
				res.setStatus(status);
			}
			
			if (savedTeacherAssignmentReview.getId() != null) {
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
	public ResponsePack<TeacherDto> createTeacher(RequestWrapper<TeacherDto> teacher) {
		ResponsePack<TeacherDto> res = new ResponsePack<TeacherDto>();
		Status status = new Status();
		Teacher savedTeacher = null;
		try {
			if (teacher.getPayload() != null){
				Teacher teacherDb = teacherDetailsTransformer.transformToDao(teacher.getPayload());	
				savedTeacher = teacherRepository.save(teacherDb);
			} else {
				status.setCode(Constants.NOTFOUND);
				res.setStatus(status);
			}
			
			if (savedTeacher.getTeacherId() != null) {
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
