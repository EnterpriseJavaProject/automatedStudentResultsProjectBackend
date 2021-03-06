package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

	
	// SELECTING FROM COURSE TABLE FOR RESULTS
	
@Query(value="SELECT courses.id, courses.coordinator, courses.course_name, courses.course_level, courses.status, courses.created_at, courses.updated_at, courses.course_start_date, courses.course_end_date, courses.certificate_issuedate FROM courses inner join students_results on courses.id = students_results.course_id where courses.id = students_results.course_id and students_results.student_id = ? and students_results.course_id = ?  GROUP by courses.id ORDER BY courses.id", nativeQuery=true)
public List<Courses> selectingFromCourseForResults(String student_id, int course_id);

	
	
	//	FIND STUDENT COURSES
	
	@Query(value="SELECT courses.id, courses.coordinator, courses.course_name, courses.course_level, courses.status, courses.created_at, courses.updated_at, courses.course_start_date, courses.course_end_date, courses.certificate_issuedate FROM courses inner join students on courses.id = students.course_id WHERE courses.id = students.course_id and students.id = ? GROUP by courses.course_name order by courses.course_name", nativeQuery=true)
	public List<Courses> findStudentCourses(Long student_id);
	
	
	
	
	
	//	FIND PAST STUDENT COURSES
	
	@Query(value="SELECT courses.id, courses.coordinator, courses.course_name, courses.course_level, courses.status, courses.created_at, courses.updated_at, courses.course_start_date, courses.course_end_date, courses.certificate_issuedate FROM courses inner join past_students on courses.id = past_students.course_id WHERE courses.id = past_students.course_id and past_students.id = ? GROUP by courses.course_name order by courses.course_name", nativeQuery=true)
	public List<Courses> findPastStudentCourses(Long student_id);
	
	
	
	
//	FIND STAFF COURSES
	
	@Query(value="SELECT courses.id, courses.coordinator, courses.course_name, courses.course_level, courses.status, courses.created_at, courses.updated_at, courses.course_start_date, courses.course_end_date, courses.certificate_issuedate FROM courses inner join staffs on courses.id = staffs.course_id WHERE courses.id = staffs.course_id and staffs.id = ? GROUP by courses.course_name order by courses.course_name", nativeQuery=true)
	public List<Courses> findStaffCourses(Long staff_id);
	
	
	
	
	
	
	// FIND COURSE BY COURSE NAME
	@Query(value="select id,course_name,coordinator,course_level,status,created_at,updated_at,course_start_date,course_end_date,certificate_issuedate from courses where courses.course_name = ? order by id" , nativeQuery = true )
	List<Courses> findCourseByCourseName(String course_name);
	
	
	
	
	
	// FIND COURSE BY COURSE LEVEL
	@Query(value="select id,course_name,coordinator,course_level,status,created_at,updated_at,course_start_date,course_end_date,certificate_issuedate from courses where courses.course_level = ? order by id" , nativeQuery = true )
	List<Courses> findCourseByCourseLevel(String course_level);
	
	
	
	
	
	
	
	//  GET ONLY COURSE NAME AND COURSE LEVEL
	@Query(value="select id,course_name,course_level,status,created_at,updated_at,course_start_date,course_end_date,certificate_issuedate from courses order by id;" , nativeQuery = true )
	List<Courses> getCourseNameAndCourseLevel();
	
	
	
	
	@Query(value="SELECT courses.course_level, modules.module_name, modules.staff_name FROM `courses` INNER JOIN `modules` WHERE courses.id = modules.course_id", nativeQuery=true)
	public List<String> findCoursesModules(Long id);
	
	
	
	
	
	@Query(value="select id,course_name,coordinator,course_level,staff_name,status,created_at,updated_at,certificate_issuedate,course_start_date,course_end_date from courses order by id;", nativeQuery=true)
	public List<Courses> findAllCourses();
	
	
	@Query(value="select count(*) from courses", nativeQuery=true)
	public String countCourses();
	
	
	
	
	// MODULES UNDER EACH COURSE
	
	@Query(value="select modules.module_name, modules.module_start_date, modules.module_end_date from  modules inner join courses on modules.course_id = courses.id where modules.course_id = courses.id and courses.id = ? GROUP by modules.module_name order by modules.module_name", nativeQuery=true)
	public Long allModulesUnderEachCourse(Long id);
	
	
	
	
	
	
	
	// TOTAL NUMBER OF MODULES UNDER EACH COURSE
	
	@Query(value="select count(modules.module_name) from  modules inner join courses on modules.course_id = courses.id where modules.course_id = courses.id and courses.id = ? GROUP by modules.module_name", nativeQuery=true)
	public Long totalNumberOfModulesUnderEachCourse(Long id);
	
	
	
	
	
	//  STUDENTS UNDER EACH COURSE
	
	@Query(value="select count(students.name) from students inner join courses on students.course_id = courses.id where students.course_id = courses.id and courses.id = ? GROUP by courses.id order by courses.id", nativeQuery=true)
	public Long totalNumberOfStudentsUnderEachCourse(Long id);

	
	
}
