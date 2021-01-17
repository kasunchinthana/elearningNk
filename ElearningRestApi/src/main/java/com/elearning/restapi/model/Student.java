package com.elearning.restapi.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.elearning.restapi.model.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "SCL_STUDENT")
@Data
public class Student extends Auditable implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;
	private String firstName;
	private String lastName;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="SCL_GRADE",referencedColumnName ="gradeId")
	private Grade grade;
	
	@OneToMany(mappedBy = "student")
    List<StudentAssignment> studentAssignment;
	
	public Student() {}

	public Student(int studentId, String firstName, String lastName, Grade grade) {
		//super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}
	
	//one student have many StudentAssignmentAnswer
	@OneToMany(mappedBy = "student")
    List<StudentAssignmentAnswer> studentAssignmentAnswer;
	
	@OneToMany(mappedBy = "student")
    List<TeacherAssignmentReview> teacherAssignmentReview;

}
