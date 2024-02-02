package com.dailycodebuffer.springdatajpatutorial.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.springdatajpatutorial.model.CourseMaterialRepository;

@SpringBootTest
class CourseMaterialTest {
@Autowired
CourseMaterialRepository courseMaterialRepo;


	
	@Test
	public void saveCourseMaterial() {
		Course course1=new Course("hgg", 190, null, null,null);

		CourseMaterial courseMaterial=new CourseMaterial("www.gcg.com",course1 );
		courseMaterialRepo.save(courseMaterial);
	}
	

	@Test
	public void allCourseMaterial() {
		List<CourseMaterial> allCouserMaterial = courseMaterialRepo.findAll();
		System.out.println("allCouserMaterial:::"+allCouserMaterial);
	}

}
