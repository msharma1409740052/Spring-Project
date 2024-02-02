package com.dailycodebuffer.springdatajpatutorial;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.springdatajpatutorial.entity.Guardian;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;
import com.dailycodebuffer.springdatajpatutorial.model.studentRepository;

@SpringBootTest
class SpringDataJpaTutorialApplicationTests {
	@Autowired
	studentRepository studentrepository;

	/*
	@Test
	public void saveStudent() {
		
		Guardian gur2=	new Guardian("abws","1234@gmail.com","8737216861");
		Student stu1=new Student("mohit","sharma","msharma@.com",gur2);
		studentrepository.save(stu1);
	}
	*/
	
	@Test
	public void printStudentByFirstName() {
		
		List<Student> students=studentrepository.findByFirstName("ravi");
//		System.out.println("students==="+students);
	}
	
	@Test
	public void findByFirstNameContaining() {
		
		List<Student> students=studentrepository.findByFirstNameContaining("vi");
//		System.out.println("students==="+students);
	}
	
	
	@Test
	public void findByLastNotNull() {
		
		List<Student> students=studentrepository.findByLastNameNotNull();
//		System.out.println("student&&==="+students);
	}
	
	
	@Test
	public void findByGuardianName() {
		
		List<Student> students=studentrepository.findByGuardianName("abcd");
//		System.out.println("students7==="+students);
	}
	
	
	@Test
	public void getStudentByEmailAddress() {
		
		Student student=studentrepository.getStudentByEmailAddress("msharma123440@gmail.com");
//		System.out.println("studentEmail==="+student);
	}
	
	
	@Test
	public void getStudentByEmailAddressUsingNative() {
		
		Student student=studentrepository.getStudentByEmailAddressUsingNative("msharma123440@gmail.com");
//		System.out.println("studentEmail_native==="+student);
	}
	
	@Test
	public void getStudentByEmailAddressUsingNativeParam() {
		
		Student student=studentrepository.getStudentByEmailAddressUsingNativeParam("msharma123440@gmail.com");
//		System.out.println("studentEmail_native_param==="+student);
	}
	
	@Test
	public void updateStudentNameByEmailId() {
		
		int rowAffected=studentrepository.updateStudentNameByEmailId("ravi kumar","msharma@.com");
		System.out.println("uppadte==="+rowAffected);
	}
	
	

}
