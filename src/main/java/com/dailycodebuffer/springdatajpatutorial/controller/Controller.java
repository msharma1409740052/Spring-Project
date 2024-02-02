package com.dailycodebuffer.springdatajpatutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.springdatajpatutorial.customExceptions.BussinessException;
import com.dailycodebuffer.springdatajpatutorial.customExceptions.ControllerException;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;
import com.dailycodebuffer.springdatajpatutorial.service.StudentService;

@RestController
@RequestMapping("/action")
public class Controller {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {

		Student addStudent = studentService.saveStudent(student);
		return new ResponseEntity<Student>(addStudent, HttpStatus.ACCEPTED);

	}

	@GetMapping("/allStudent")
	public ResponseEntity<?> allStudent() {
		List<Student> allStudent = null;
		try {
			allStudent = studentService.findAll();
			return new ResponseEntity<List<Student>>(allStudent, HttpStatus.OK);

		} catch (BussinessException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			ControllerException ce = new ControllerException("605", e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}

	}

}
