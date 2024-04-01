package com.vistal.tech.exception;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class AllCatchExceptionHandler {
	

	@ExceptionHandler(SignupNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleSignupNotFoundException(SignupNotFoundException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Signup does not exist into the database", details,
				request.getDescription(false), new Timestamp(new Date().getTime()));
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(org.springframework.security.access.AccessDeniedException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Error while processing the data", details,
				request.getDescription(false), new Timestamp(new Date().getTime()));
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Error while processing the data", details,
				request.getDescription(false), new Timestamp(new Date().getTime()));
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
