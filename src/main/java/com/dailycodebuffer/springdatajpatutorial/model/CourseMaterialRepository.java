package com.dailycodebuffer.springdatajpatutorial.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springdatajpatutorial.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepository  extends JpaRepository<CourseMaterial, Long>{

}
