package com.elearning.restapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NaturalIdCache;

import com.elearning.restapi.model.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "SCL_ASSIGNMENT")
@Data
public class Assignment extends Auditable implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assingnment_id")
	private Integer assingnmentId;
	private String name;
	private String status;
	@JsonFormat(pattern = "YYYY-MM-dd")
	private LocalDateTime devDate;
	private Integer totalMarks;
	private Integer cutoffMarks;
	private Integer duration;
	private String description;
	
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="SCL_SUBJECT",referencedColumnName ="subjectId")
	private Subject subject;
	
	@OneToMany(mappedBy = "assignment")
	private List<StudentAssignment> studentAssignment;
	
	@OneToMany(mappedBy = "assignment",cascade = CascadeType.ALL)
	private List<Question> question;
		
	
	//one Assignment have many StudentAssignmentAnswer
	
	  @OneToMany(mappedBy = "assignment") 
	  private List<StudentAssignmentAnswer> studentAssignmentAnswer;
	  
	  @OneToMany(mappedBy = "assignment") 
	  private List<TeacherAssignmentReview> teacherAssignmentReview;
	  
	/*
	 * @OneToMany(mappedBy="assignment") private List<TeacherAssignment>
	 * teacherAssignment;
	 */
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="teacher_id" ) 
	  private Teacher teacher;
	 
}
