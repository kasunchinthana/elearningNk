package com.elearning.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
import com.elearning.restapi.mapping.response.QuestionDto;
import com.elearning.restapi.mapping.response.RequestWrapper;
import com.elearning.restapi.mapping.response.ResponsePack;
import com.elearning.restapi.mapping.response.Status;
import com.elearning.restapi.mapping.response.StudentDto;
import com.elearning.restapi.model.Student;
import com.elearning.restapi.service.AssignmentService;
import com.elearning.restapi.service.StudentService;
import com.elearning.restapi.utils.Constants;

@RestController
@RequestMapping("/elearning-service/v1")
@CrossOrigin
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	/*
	 * @GetMapping("/assignments") public ResponsePack<AssignmentDto>
	 * getAllAssignments() { ResponsePack<AssignmentDto> assignmentDtoLlist = new
	 * ResponsePack<>(); assignmentDtoLlist=assignmentService.getAllAssignment();
	 * Status responseStatus = new Status();
	 * responseStatus.setCode(Constants.SUCCESS); responseStatus.setMessage("ok");
	 * assignmentDtoLlist.setStatus(responseStatus);
	 * 
	 * return assignmentDtoLlist; }
	 */

	@GetMapping("/assignments")
	public ResponseEntity<ResponsePack<AssignmentDto>> getAllAssignments() {
		ResponsePack<AssignmentDto> assignmentDtoLlist = new ResponsePack<>();
		try {
			assignmentDtoLlist = assignmentService.getAllAssignment();
			Status responseStatus = new Status();
			if (assignmentDtoLlist.getData().size() != 0) {
				responseStatus.setCode(Constants.SUCCESS);
				responseStatus.setMessage("ok");
				assignmentDtoLlist.setStatus(responseStatus);
				return new ResponseEntity<ResponsePack<AssignmentDto>>(assignmentDtoLlist, HttpStatus.ACCEPTED);
			} else {
				responseStatus.setCode(Constants.NOTFOUND);
				responseStatus.setMessage("ok");
				assignmentDtoLlist.setStatus(responseStatus);
				return new ResponseEntity<ResponsePack<AssignmentDto>>(assignmentDtoLlist, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// return assignmentDtoLlist;
	}

	@PostMapping("/assignments")
	public ResponseEntity<ResponsePack<AssignmentDto>> createAssignments(
			@RequestBody RequestWrapper<AssignmentDto> payload) {
		ResponsePack<AssignmentDto> responseAssignmentDto = null;
		try {
			responseAssignmentDto = assignmentService.createAssignment(payload);
			if (responseAssignmentDto != null) {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(responseAssignmentDto, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<ResponsePack<AssignmentDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/assignments/{id}")
	public ResponseEntity<ResponsePack<AssignmentDto>> getAssignmentsById(@PathVariable("id") Integer id) {
		ResponsePack<AssignmentDto> assignmentDto = new ResponsePack<>();
		// ResponsePack<AssignmentDto> assignmentDtoLlist = new ResponsePack<>();
		try {
			assignmentDto = assignmentService.getAssignmentsById(id);
			if (assignmentDto != null) {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(assignmentDto, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/assignments/{id}")
	public ResponseEntity<ResponsePack<AssignmentDto>> deleteAssignmentById(@PathVariable("id") Integer id) {
		ResponsePack<AssignmentDto> assignmentDto = new ResponsePack<>();
		try {
			assignmentDto = assignmentService.deleteAssignmentById(id);
			if (assignmentDto != null) {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(assignmentDto, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/assignments/{id}")
	public ResponseEntity<ResponsePack<AssignmentDto>> updateAssignment(@PathVariable("id") Integer id,
			@RequestBody RequestWrapper<AssignmentDto> payload) {
		ResponsePack<AssignmentDto> updatetAssignment = null;
		try {
			updatetAssignment = assignmentService.updateAssignment(id, payload);
			if (updatetAssignment != null) {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(updatetAssignment, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ResponsePack<AssignmentDto>>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<ResponsePack<AssignmentDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
}
