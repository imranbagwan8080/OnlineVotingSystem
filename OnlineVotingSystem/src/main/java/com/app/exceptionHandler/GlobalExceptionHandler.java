package com.app.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.customException.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public String resourceNotFoundException(ResourceNotFoundException r){
		return r.getMessage();
	}

}
