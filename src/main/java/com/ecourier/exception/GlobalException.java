package com.ecourier.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(TrackingNotFoundException.class)
	public ResponseEntity<String> handleTrackingNotFound(TrackingNotFoundException e) {
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CourierNotFoundException.class)
	public ResponseEntity<String> handleCourierNotFound(CourierNotFoundException e) {
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}

