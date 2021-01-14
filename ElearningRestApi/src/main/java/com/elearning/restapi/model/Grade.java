package com.elearning.restapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.elearning.restapi.model.audit.Auditable;

import lombok.Data;

@Entity(name = "SCL_GRADE")
@Data
public class Grade extends Auditable implements Serializable{
	
	@Id
	private int gradeId;
	private String gradeName;

}
