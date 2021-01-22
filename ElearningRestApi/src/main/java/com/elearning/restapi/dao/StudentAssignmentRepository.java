package com.elearning.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.restapi.model.StudentAssignment;
import com.elearning.restapi.model.StudentAssignmentId;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, StudentAssignmentId> {

}
