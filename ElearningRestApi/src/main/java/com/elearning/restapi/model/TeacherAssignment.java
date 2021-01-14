package com.elearning.restapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.elearning.restapi.model.audit.Auditable;

import lombok.Data;

@Entity(name = "SCL_TEACHERS_ASSIGNMENTS")
@Data
public class TeacherAssignment extends Auditable implements Serializable{
	
	@Id
	@Column(name="teacher_assignment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer assigmnetId;
	private Integer teacherId;

}
