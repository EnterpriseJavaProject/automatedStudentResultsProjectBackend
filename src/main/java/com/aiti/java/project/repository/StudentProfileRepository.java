package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
	
	//@Query(value="select full_name from students", nativeQuery=true)
	List<StudentProfile> findByName(String name);
	
	

	
	
	@Query(value="select count(*) from students", nativeQuery=true)
	public String countStudent();
	
	
	
	
}
