package com.elearning.restapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class StudentAssignmentId implements Serializable{
	
	
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "assingnment_id")
	private Integer assingnmentId;
	
	public StudentAssignmentId(){
		
	}
	
	public StudentAssignmentId(Integer studentId, Integer assingnmentId) {	
		this.studentId = studentId;
		this.assingnmentId = assingnmentId;
	}
	@Override
	public String toString() {
		return "StudentAssignmentId [studentId=" + studentId + ", assingmetId=" + assingnmentId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assingnmentId == null) ? 0 : assingnmentId.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAssignmentId other = (StudentAssignmentId) obj;
		if (assingnmentId == null) {
			if (other.assingnmentId != null)
				return false;
		} else if (!assingnmentId.equals(other.assingnmentId))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	
}
