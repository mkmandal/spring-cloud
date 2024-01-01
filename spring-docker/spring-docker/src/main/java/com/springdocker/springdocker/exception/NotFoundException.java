package com.springdocker.springdocker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	private String message;
	private int status;
	private HttpStatus statusMessage;

	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(HttpStatus notFound, int value, String message) {
		this.message= message;
		this.status=value;
		this.statusMessage=notFound;
	}

	
	
	

}
