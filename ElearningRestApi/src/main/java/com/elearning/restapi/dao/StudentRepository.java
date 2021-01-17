package com.elearning.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.StudentAssignmentAnswer;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByStudentAssignmentAnswer(Integer studetnId);

}
