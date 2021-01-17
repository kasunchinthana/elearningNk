package com.elearning.restapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.elearning.restapi.model.audit.Auditable;

import lombok.Data;

@Entity(name = "SCL_STUDENT_ASSIGNMENT_ANSWER")
@Data
public class StudentAssignmentAnswer extends Auditable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// private Integer studentId;
	// private Integer assignmentId;
	// private Integer questionId;
	private String answer;

	// many StudentAssignmentAnswer for one student
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("studentId")
	@JoinColumn(name = "student_id")
	Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("assingnmentId")
	@JoinColumn(name = "assingnment_id")
	Assignment assignment;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("questionId")
	@JoinColumn(name = "question_id")
	Question question;

}