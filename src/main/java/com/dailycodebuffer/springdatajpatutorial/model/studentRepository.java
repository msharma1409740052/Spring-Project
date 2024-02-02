package com.dailycodebuffer.springdatajpatutorial.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface studentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String name);

	public List<Student> findByLastNameNotNull();

	public List<Student> findByGuardianName(String guardianNmae);

	// JPQL
    @Query("select s from Student s where s.emailId=?1 ")

	public Student getStudentByEmailAddress(String emailId);

	//Native query
	@Query(value = "select * from tbl_student s where s.email_address=?1", nativeQuery = true)
	public Student getStudentByEmailAddressUsingNative(String emailId);
	
	// QueryNmaeParams
	@Query(value = "select * from tbl_student s where s.email_address=:x", nativeQuery = true)
	public Student getStudentByEmailAddressUsingNativeParam(@Param("x")  String emailId);
	
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name=?1 where email_address=?2 ", nativeQuery = true)
	public int updateStudentNameByEmailId(String firstName,String emailId);
	
	
	
	
	

}
