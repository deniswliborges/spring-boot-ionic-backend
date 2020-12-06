package com.deniswillian.cursomcc.resources.exeptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deniswillian.cursomcc.services.exceptions.ObjectNotFounfException;

@ControllerAdvice
public class ResourceEceptionHandler {

	@ExceptionHandler(ObjectNotFounfException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFounfException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
}

