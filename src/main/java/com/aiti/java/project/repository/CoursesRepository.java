package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

	






		
@Query(value="select count(*) from courses", nativeQuery=true)
public String countCourses();

















//	// SELECTING FROM COURSE BATCH TABLE FOR RESULTS
//	
//@Query(value="SELECT DISTINCT * FROM course_batch inner join students_results on course_batch.id = students_results.batch_id where course_batch.id = students_results.course_batch_id and students_results.student_id = ? and students_results.batch_id = ?", nativeQuery=true)
//public List<Courses> selectingFromCourseForResults(String student_id, int batch_id);
//
//
//
//
//
//
//
//
//	//	FIND STUDENT COURSE BATCHES
//	
//	@Query(value="SELECT * FROM courses inner join students on courses.id = students.batch_id WHERE courses.id = students.batch_id and students.id = ? GROUP by courses.id order by courses.id", nativeQuery=true)
//	public List<Courses> findStudentCourses(Long student_id);
//	
//	
//	
//	
//	
//	//	FIND PAST STUDENT COURSES
//	
//	@Query(value="SELECT * FROM courses inner join past_students on courses.id = past_students.batch_id WHERE courses.id = past_students.batch_id and past_students.id = ? GROUP by courses.id order by courses.id", nativeQuery=true)
//	public List<Courses> findPastStudentCourses(Long student_id);
//	
//	
//	
//	
////	FIND STAFF COURSES
//	
//	@Query(value="SELECT * FROM courses inner join staff_details on courses.id = staff_details.batch_id WHERE courses.id = staff_details.batch_id and staff_details.id = ? GROUP by courses.id order by courses.id", nativeQuery=true)
//	public List<Courses> findStaffCourses(Long staff_id);
//	
//	
//	
//	
//	
//	
//	// FIND COURSE BY COURSE NAME
//	@Query(value="select id,course_name,status,created_at,updated_at from courses where courses.course_name = ? order by id" , nativeQuery = true )
//	List<Courses> findCourseByCourseName(String course_name);
//	
//	
//	
//	
//	
//	// FIND COURSE BY COURSE LEVEL
//	@Query(value="select id,course_name,status,created_at,updated_at from courses where courses.course_level = ? order by id" , nativeQuery = true )
//	List<Courses> findCourseByCourseLevel(String course_level);
//	
//	
//	
//	
//	
//	
//	
//	//  GET ONLY COURSE NAME AND COURSE LEVEL
//	@Query(value="SELECT `id`, `course_name`, `status`, `created_at`, `updated_at` FROM `courses` order by id" , nativeQuery = true )
//	List<Courses> getCourseNameAndCourseLevel();
//	
//	
//	
//	
//	@Query(value="SELECT modules.module_name, modules.staff_name FROM `courses` INNER JOIN `modules` WHERE courses.id = modules.batch_id", nativeQuery=true)
//	public List<String> findCoursesModules(Long id);
//	
//	
//	
//	
//	
//	@Query(value="select id,course_name, staff_name,status,created_at,updated_at from courses order by id;", nativeQuery=true)
//	public List<Courses> findAllCourses();
//	
//	
//
//	
//	
//	
//	
//	// MODULES UNDER EACH COURSE
//	
//	@Query(value="select modules.module_name, modules.module_start_date, modules.module_end_date from  modules inner join courses on modules.batch_id = courses.id where modules.batch_id = courses.id and courses.id = ? GROUP by modules.module_name order by modules.module_name", nativeQuery=true)
//	public Long allModulesUnderEachCourse(Long id);
//	
//	
//	
//	
//	
//	
//	
//	// TOTAL NUMBER OF MODULES UNDER EACH COURSE
//	
//	@Query(value="select count(modules.module_name) from  modules inner join courses on modules.batch_id = courses.id where modules.batch_id = courses.id and courses.id = ? GROUP by modules.module_name", nativeQuery=true)
//	public Long totalNumberOfModulesUnderEachCourse(Long id);
//	
//	
//	
//	
//	
//	//  STUDENTS UNDER EACH COURSE
//	
//	@Query(value="select count(students.name) from students inner join courses on students.batch_id = courses.id where students.batch_id = courses.id and courses.id = ? GROUP by courses.id order by courses.id", nativeQuery=true)
//	public Long totalNumberOfStudentsUnderEachCourse(Long id);

	
	
}
