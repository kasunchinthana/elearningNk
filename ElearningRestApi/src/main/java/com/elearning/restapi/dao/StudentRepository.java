package com.elearning.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.restapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
