package com.dailycodebuffer.springdatajpatutorial.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>{

}
