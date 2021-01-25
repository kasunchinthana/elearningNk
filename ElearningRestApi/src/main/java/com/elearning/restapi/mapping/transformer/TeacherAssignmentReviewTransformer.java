package com.elearning.restapi.mapping.transformer;

import org.springframework.stereotype.Service;

import com.elearning.restapi.mapping.response.StudentAssignmentAnswersDto;
import com.elearning.restapi.mapping.response.TeacherAssignmentReviewDto;
import com.elearning.restapi.model.Assignment;
import com.elearning.restapi.model.Question;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.model.StudentAssignmentAnswer;
import com.elearning.restapi.model.Teacher;
import com.elearning.restapi.model.TeacherAssignmentReview;

@Service
public class TeacherAssignmentReviewTransformer {

	public TeacherAssignmentReview transformToDao(Teacher teacher,Student student,Assignment assignment,Question question,TeacherAssignmentReviewDto teacherAssignmentReviewDto) {
		
		TeacherAssignmentReview teacherAssignmentReview = new TeacherAssignmentReview();
		teacherAssignmentReview.setTeacher(teacher);
		teacherAssignmentReview.setAssignment(assignment);
		teacherAssignmentReview.setStudent(student);
		teacherAssignmentReview.setQuestion(question);
		teacherAssignmentReview.setReview(teacherAssignmentReviewDto.getReview());
		return teacherAssignmentReview;
	}

}
