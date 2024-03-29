package com.springdocker.springdocker.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
	 
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception e, WebRequest re){
		
	  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),e.getMessage(), re.getDescription(false));	
	  
	  return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFountException(Exception e, WebRequest re){
		
	  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),e.getMessage(), re.getDescription(false));	
	  
	  return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
		
	}
	
	

}
