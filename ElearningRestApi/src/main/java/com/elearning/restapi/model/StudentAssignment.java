package com.elearning.restapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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

@Entity(name = "SCL_STUDENT_ASSIGNMENT")
@Data
public class StudentAssignment extends Auditable implements Serializable{
	
	
	@EmbeddedId
	private StudentAssignmentId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("studentId")
	@JoinColumn(name = "student_id")
	Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("assingnmentId")
	@JoinColumn(name = "assingnment_id")
	Assignment assignment;
	
	private Integer duration;
	
	
	public StudentAssignment(Student student, Assignment assignment) {
				
		this.student = student;
		this.assignment = assignment;		
		this.id = new StudentAssignmentId( student.getStudentId(),assignment.getAssingnmentId());
	}
	
	
	
}
