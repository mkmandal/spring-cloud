package com.springcloud.microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	private String message;
	private int status;
	private HttpStatus statusMessage;
	private String errorCode;
	

	public NotFoundException(String message) {
		super(message);
		this.message=message;
	}

	public NotFoundException(HttpStatus notFound, int value, String message) {
		this.message= message;
		this.status=value;
		this.statusMessage=notFound;
	}

	public NotFoundException(String errorMessage, String errorCode, int status2) {
		this.message= errorMessage;
		this.status=status2;
		this.errorCode=errorCode;
	}

	
	
	

}
