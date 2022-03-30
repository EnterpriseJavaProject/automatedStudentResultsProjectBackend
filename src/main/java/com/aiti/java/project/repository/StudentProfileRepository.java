package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
	
	

	
	// COUNT ALL STUDENTS
	@Query(value="select count(*) from students", nativeQuery=true)
	public String countStudent();
	
	
	
	
	// COUNT ALL MALE STUDENTS
	@Query(value="select count(*) from students where gender = 'Male' ", nativeQuery=true)
	public String countAllMaleStudent();
	
	
	
	
	// COUNT ALL FEMALE STUDENTS
	@Query(value="select count(*) from students where gender = 'Female' ", nativeQuery=true)
	public String countAllFemaleStudent();
	
	
	
	// METHOD TO RETRIEVE STUDENTS UNDER EACH MODULE 
	
	@Query(value="SELECT DISTINCT students.id, students.name, students.student_id, students.course_id, students.date_of_birth, students.contact, students.gender,students.fees, students.email, students.status, students.created_at, students.updated_at FROM students INNER JOIN modules ON students.course_id = modules.course_id where students.course_id = modules.course_id and modules.id = ?  GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
	public StudentProfile[] retrieveStudentsUnderModule(Long id);
	
	
	
	
	
	List<StudentProfile> findByName(String name);
	
	
	
	
	
	
	
	
	
	
	
}
