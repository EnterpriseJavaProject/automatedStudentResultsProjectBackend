package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

	
	
	//  GET ONLY COURSE NAME AND COURSE LEVEL
	@Query(value="select id,course_name,course_level,status,created_at,updated_at,course_start_date,course_end_date,certificate_issuedate from courses order by id;" , nativeQuery = true )
	List<Courses> getCourseNameAndCourseLevel();
	
	
	
	
	@Query(value="SELECT courses.course_level, modules.module_name, modules.staff_name FROM `courses` INNER JOIN `modules` WHERE courses.id = modules.course_id", nativeQuery=true)
	public List<String> findCoursesModules(Long id);
	
	
	
	
	
	@Query(value="select id,course_name,course_level,staff_name,status,created_at,updated_at,certificate_issuedate,course_start_date,course_end_date from courses order by id;", nativeQuery=true)
	public List<Courses> findAllCourses();
	
	
	@Query(value="select count(*) from courses", nativeQuery=true)
	public String countCourses();

	
	
}
