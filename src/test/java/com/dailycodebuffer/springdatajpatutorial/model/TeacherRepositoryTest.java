package com.dailycodebuffer.springdatajpatutorial.model;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.Teacher;
@SpringBootTest
class TeacherRepositoryTest {
	@Autowired
	TeacherRepository teacherRepo;

	@Test
	public void saveTeacher() {
		Course course1=new Course("java", 121,null,null,null);
		Course course2=new Course("dsa", 122,null,null,null);

		List<Course> list=Arrays.asList(course1,course2);
		
		Teacher teacher=new Teacher("rahi", "singh", list);
		
		teacherRepo.save(teacher);
		
	}

}
