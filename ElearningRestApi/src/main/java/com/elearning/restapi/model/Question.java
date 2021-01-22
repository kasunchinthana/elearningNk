package com.elearning.restapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.elearning.restapi.model.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "SCL_QUESTION")
@Data
public class Question extends Auditable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Integer questionId;
	private String question;
	private String type;
	private String correctAnswer;
	private String hint;

	
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="assingnment_id" ) 
	  private Assignment assignment;
	 

	 
	
	/*
	 * // one Question have many StudentAssignmentAnswer
	 * 
	 * @OneToMany(mappedBy = "question") List<StudentAssignmentAnswer>
	 * studentAssignmentAnswer;
	 * 
	 * @OneToMany(mappedBy = "question") List<TeacherAssignmentReview>
	 * teacherAssignmentReview;
	 */
}
