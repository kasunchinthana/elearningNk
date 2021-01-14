package com.elearning.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.restapi.mapping.response.AssignmentDto;
import com.elearning.restapi.mapping.response.Payload;
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
	
	@GetMapping("/assignments2") 
	public  ResponseEntity<ResponsePack<AssignmentDto>> getAllAssignments2() {
		ResponsePack<AssignmentDto> assignmentDtoLlist = new ResponsePack<>();
		try {
		assignmentDtoLlist=assignmentService.getAllAssignment();
		Status responseStatus = new Status();
		if(assignmentDtoLlist.getData().size()!=0) {
			responseStatus.setCode(Constants.SUCCESS);
			responseStatus.setMessage("ok");
			assignmentDtoLlist.setStatus(responseStatus);
			 return new ResponseEntity<ResponsePack<AssignmentDto>>(HttpStatus.NO_CONTENT);
		}else {
			responseStatus.setCode(Constants.NOTFOUND);
			responseStatus.setMessage("ok");
			assignmentDtoLlist.setStatus(responseStatus);
			return new ResponseEntity<ResponsePack<AssignmentDto>>(assignmentDtoLlist, HttpStatus.OK);
		}
		
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return assignmentDtoLlist;
	}
	
	
	@PostMapping("/assignments")
	public ResponsePack<AssignmentDto> createAssignments(@RequestBody RequestWrapper<Payload<AssignmentDto>> assignmentDto){
		ResponsePack<AssignmentDto> responseAssignmentDto=assignmentService.createAssignment(assignmentDto);
		return responseAssignmentDto;
		
	}

	/*
	 * ResponseEntity<TBXResponseWrapper<GeneralSupplier>>
	 * ResponseEntity<List<Supplier>>
	 * 
	 * 
	 * 
	 * public ResponseEntity<TBXResponseWrapper<Resource<Client>>>
	 * addClient( @RequestBody TBXRequestWrapper<Client> client
	 * , @RequestParam(required = false) boolean isUpdate) { try { log.debug(
	 * "request to save clients : ", client ); if( isUpdate == false &&
	 * client.getPayload().getId() != 0 ) { TBXResponse response = new TBXResponse(
	 * new BadRequestAlertException( "A new groupMaster cannot already have an ID",
	 * ENTITY_NAME, "idexis } }
	 */
	  
}
