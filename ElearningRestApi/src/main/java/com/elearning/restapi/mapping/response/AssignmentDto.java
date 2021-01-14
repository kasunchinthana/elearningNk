package com.elearning.restapi.mapping.response;


import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AssignmentDto {
	
	AssignmentSummaryDto summary;
	
	AssignmentDetailDto detail;
	
}
