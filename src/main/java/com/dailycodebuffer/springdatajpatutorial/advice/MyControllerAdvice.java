package com.dailycodebuffer.springdatajpatutorial.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dailycodebuffer.springdatajpatutorial.customExceptions.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
		return new ResponseEntity<String>("Input field is empty",HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> handleNosuchElementException(NoSuchElementException elementException) {
		return new ResponseEntity<String>("No value present in DB",HttpStatus.BAD_REQUEST);
	}

}
