package com.elearning.restapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Student;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

	List<Assignment> findByName(String name);
		
}
