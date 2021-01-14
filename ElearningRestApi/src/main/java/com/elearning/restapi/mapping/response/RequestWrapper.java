package com.elearning.restapi.mapping.response;


import lombok.Data;

@Data
public class RequestWrapper<T> {

	Payload<T> payload;
}
