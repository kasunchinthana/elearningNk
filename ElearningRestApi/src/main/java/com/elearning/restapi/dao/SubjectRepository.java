package com.elearning.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	
	List<Subject> findBySubjectCode(String subjectCode);	

}
