package com.dailycodebuffer.springdatajpatutorial.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;
import com.dailycodebuffer.springdatajpatutorial.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	
	@Autowired
	CourseRepository courseReository;

	@Test
	public void getAllCourses() {
		List<Course> allCourse=courseReository.findAll();
//		System.out.println("allCourse::"+allCourse);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher1=new Teacher("kashma", "vishwakarma",null);
		Course course=new Course("c++", 430, null, teacher1,null);
		courseReository.save(course);
		
	}
	
	@Test
	public void findAllPagination() {
		
		PageRequest firstPageWith3Record=PageRequest.of(0, 3);
		PageRequest secondPageWith2Record=PageRequest.of(1,2);
		List<Course>courses=courseReository.findAll(firstPageWith3Record).getContent();
		long totalElement=courseReository.findAll(firstPageWith3Record).getTotalElements();

//		System.out.println("courses:::   "+courses);
//		System.out.println("totalElement:::   "+totalElement);

	}
	
	@Test
	public void findAllSorting() {
	   PageRequest sortByTitle=PageRequest.of(0, 2, Sort.by("title"));
	   PageRequest sortByCraditDesc=PageRequest.of(0, 2,Sort.by("credit").descending());
	   PageRequest sortByTitleAndCreditDesc=PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		
	   List<Course>courses=courseReository.findAll(sortByTitleAndCreditDesc).getContent();
	   
//	   System.out.println("courcesss====>"+courses);
	   
	}
	
	@Test
	public void findByTitleContaining() {
		
		PageRequest findFirstPage10Record=PageRequest.of(0, 10);
		List<Course> courses=courseReository.findByTitleContaining("P", findFirstPage10Record).getContent();
		   System.out.println("courses====>"+courses);

	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher=new Teacher("Riya", "sharma", null);
		Student student=new Student("neha", "sharma", "123@gmail.com",null);
		Student student1=new Student("usha", "sharma", "66653@gmail.com",null);
		List<Student>students=new ArrayList();
		students.add(student1);
		students.add(student);
		Course course=new Course("botnet", 123, null, teacher, students);
		courseReository.save(course);

	}
	
}
