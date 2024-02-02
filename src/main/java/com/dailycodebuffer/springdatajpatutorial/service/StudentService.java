package com.dailycodebuffer.springdatajpatutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.springdatajpatutorial.customExceptions.BussinessException;
import com.dailycodebuffer.springdatajpatutorial.customExceptions.EmptyInputException;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;
import com.dailycodebuffer.springdatajpatutorial.model.studentRepository;

@Service
public class StudentService {
	@Autowired
	studentRepository studentrepository;

	public Student saveStudent(Student student) {
		Student studentAdded = null;
		if (student.getFirstName().trim() == "" || student.getEmailId() == null) {
			throw new EmptyInputException("601", "first name & emailId is must.");
		}
		try {

			studentAdded = studentrepository.save(student);

		} catch (IllegalArgumentException e) {

			throw new BussinessException("602", e.getMessage());
		} catch (Exception e) {

			throw new BussinessException("603", e.getMessage());
		}
		return studentAdded;

	}

	public List<Student> findAll() {
		List<Student> allStudent = null;
		try {

			allStudent = studentrepository.findAll();

		} catch (Exception e) {

			throw new BussinessException("604", e.getMessage());

		}

		return allStudent;
	}

}
