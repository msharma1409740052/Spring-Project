package com.dailycodebuffer.springdatajpatutorial.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	 Page<Course>findByTitleContaining(String title,PageRequest pageRequest);

	
}
