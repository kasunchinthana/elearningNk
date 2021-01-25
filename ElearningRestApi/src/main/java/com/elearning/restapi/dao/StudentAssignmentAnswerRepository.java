package com.elearning.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.elearning.restapi.model.StudentAssignmentAnswer;

@Service
public interface StudentAssignmentAnswerRepository extends JpaRepository<StudentAssignmentAnswer, Integer>{

}
