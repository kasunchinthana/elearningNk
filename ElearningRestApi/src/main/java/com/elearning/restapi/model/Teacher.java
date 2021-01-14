package com.elearning.restapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.elearning.restapi.model.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "SCL_TEACHER")
@Data
public class Teacher extends Auditable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "SCL_TEACHERS_ASSIGNMENTS", joinColumns = @JoinColumn(name
	 * = "student_id", referencedColumnName = "studentId"), inverseJoinColumns
	 * = @JoinColumn(name = "assingmet_id", referencedColumnName = "assingmetId"))
	 * private Set<Assignment> assignment = new HashSet<>();
	 */

	public Teacher() {

	}
}
