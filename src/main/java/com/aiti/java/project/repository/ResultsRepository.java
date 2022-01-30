package com.aiti.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Results;

public interface ResultsRepository extends JpaRepository<Results, Long> {
	

	
	// FIND STUDENT BY NAME
	@Query(value="SELECT DISTINCT `id`, `name`, `student_id`, `course_name`, `module_name`, `staff_name`, `marks`, `status`, `created_at`, `updated_at` FROM `results` WHERE results.student_id = ? order by results.student_id" , nativeQuery = true )
	List<Results> findResultsByStudentID(String course_name);
	
	
	
	//  SAVE ALL RESULTS
	
	//public ResponseEntity<Results> saveAll(List<Results> results);
	
	
	
	//public List<Results> saveAll(List<Results> results);
	
	
	
	
	@Query(value="select count(*) from results", nativeQuery=true)
	public String countResults();




	@Query(value="select modules.course_name, students.name, students.student_id, students.contact, students.gender, modules.module_name, results.marks,courses.course_name from students, modules, results, courses WHERE students.course_id = modules.course_id AND students.student_id = results.student_id and courses.id = students.course_id and modules.id = results.module_id and modules.course_name = ?  AND students.student_id = ? ;",  nativeQuery=true )
	public String searchStudentResults();


	
	
	
	
		
	
	// METHOD TO RETRIEVE ONLY STUDENT NAME AND STUDENT ID
	
//	@Query(value="SELECT DISTINCT students.name, students.student_id, modules.module_name, modules.course_name, staffs.name from students,staffs, courses, modules where students.course_id = courses.id and courses.id = modules.course_id and modules.id = ? GROUP by students.student_id ORDER BY modules.id",  nativeQuery=true )
//	public String showAllStudentResults();
//	
	
	
	


	
}
