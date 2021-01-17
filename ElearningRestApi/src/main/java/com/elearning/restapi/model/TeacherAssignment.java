package com.elearning.restapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import com.elearning.restapi.model.audit.Auditable;

import lombok.Data;

@Entity(name = "SCL_TEACHERS_ASSIGNMENTS")
@Data
public class TeacherAssignment extends Auditable implements Serializable{
	
	@Id
	@Column(name="teacher_assignment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id")
	@JoinColumn(name = "id")
	Teacher teacher;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("assingnmentId")
	@JoinColumn(name = "assingnment_id")
	Assignment assignment;

}
