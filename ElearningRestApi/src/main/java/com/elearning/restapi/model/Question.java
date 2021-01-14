package com.elearning.restapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.elearning.restapi.model.audit.Auditable;

import lombok.Data;

@Entity(name = "SCL_QUESTION")
@Data
public class Question extends Auditable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionId;
	private String question;
	private String type;
	private String correctAnswer;
	private String hint;
}
