package com.samsung.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class OrderControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException (MethodArgumentNotValidException ex, HttpServletRequest request) {
		List<String> messages = 
				ex.getFieldErrors().stream().map(e -> e.getDefaultMessage())
				.collect(Collectors.toList());
		Map<String, List<String>> errors = new HashMap<>();
		errors.put("errors", messages);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
		return new ResponseEntity<>("Check for null values", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlException(Exception ex, HttpServletRequest request) {
		return new ResponseEntity<>("Check for exception details", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
