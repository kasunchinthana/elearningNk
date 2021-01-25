package com.elearning.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.StudentAssignmentAnswer;
import com.elearning.restapi.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	

}
