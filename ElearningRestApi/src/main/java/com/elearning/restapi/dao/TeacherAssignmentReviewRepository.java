package com.elearning.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.elearning.restapi.model.TeacherAssignmentReview;

@Service
public interface TeacherAssignmentReviewRepository extends JpaRepository<TeacherAssignmentReview,Integer> {

}
