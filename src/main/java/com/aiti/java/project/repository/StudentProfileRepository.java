package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
	
	
	
	
	
	
	@Query(value="select count(*) from students", nativeQuery=true)
	public String countStudent();
	
	
	
	
	
	
	
	
	// METHOD TO RETRIEVE ONLY STUDENT NAME AND ID 

	@Query(value="SELECT DISTINCT students.id, students.name, students.student_id, students.course_id, students.date_of_birth, students.contact, students.gender, students.email, students.status, students.created_at, students.updated_at, modules.module_name, modules.course_name, modules.staff_name FROM students INNER JOIN modules ON modules.course_id = students.course_id where modules.id = ? GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
	public List<StudentProfile> findAllStudentNameAndStudentIDForResults(int id);
	
	
	
	
	
	
	
	
	
	
	//@Query(value="select full_name from students", nativeQuery=true)
	List<StudentProfile> findByName(String name);
	
	
	
	// METHOD TO RETRIEVE ALL STUDENT NAME AND STUDENT ID FROM STUDENT TABLE
	
//	@Query(value="SELECT DISTINCT `id`, `name`, `student_id`, `course_name`, `course_id`, `date_of_birth`, `contact`, `gender`, `email`, `status`, `created_at`, `updated_at` FROM `students`", nativeQuery=true)
//	public List<StudentProfile> getStudentNameAndStudentID();
	
	
	
	
	
	
	
	
	
}
