package com.aiti.java.project.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Modules;

public interface ModulesRepository extends JpaRepository<Modules, Long>  {
	
	
	
	
	
	
	
	// SELECTING ONLY STAFF NAME FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT DISTINCT modules.staff_name, modules.course_name,modules.module_name, modules.module_start_date, modules.module_end_date FROM modules inner join staffs on modules.course_id = staffs.course_id and modules.staff_name = staffs.name where staffs.usertype not like '%Academic Secretary%' and staffs.usertype not like '%Course Cordinator%' and staffs.usertype not like '%Director of Studies%' and modules.course_id = staffs.course_id and modules.staff_name = staffs.name GROUP by staffs.email order by staffs.updated_at desc limit 1" , nativeQuery = true )
	String selectingStaffNameCourseAndModuleNameModuleStartAndEndDatetoSendEmailNotificationtoInstructors();
	
	
	
	
	
	
	
	
	
	
	// SELECTING ONLY STAFF NAME FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT modules.staff_name FROM modules GROUP by modules.updated_at order by modules.updated_at desc limit 1" , nativeQuery = true )
	String selectingStaffNametoSendEmailNotification();
	
	
	// SELECTING ONLY COURSE NAME FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT modules.course_name FROM modules GROUP by modules.updated_at order by modules.updated_at desc limit 1" , nativeQuery = true )
	String selectingCourseNametoSendEmailNotification();
	
	
	// SELECTING ONLY MODULE NAME FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT  modules.module_name FROM modules GROUP by modules.updated_at order by modules.updated_at desc limit 1" , nativeQuery = true )
	String selectingModuleNametoSendEmailNotification();
	
	
	// SELECTING ONLY MODULE START DATE FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT  modules.module_start_date FROM modules GROUP by modules.updated_at order by modules.updated_at desc limit 1" , nativeQuery = true )
	String selectingModuleStartDatetoSendEmailNotification();
	
	
	// SELECTING ONLY MODULE END DATE FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT  modules.module_end_date FROM modules GROUP by modules.updated_at order by modules.updated_at desc limit 1" , nativeQuery = true )
	String selectingModuleEndDatetoSendEmailNotification();
	
	
	
	
	
	
	
	
	
	
	// SELECTING COURSE NAME, MODULE NAME, STAFF NAME, MODULE START AND END DATE
	@Query(value="SELECT  DISTINCT modules.course_name,modules.module_start_date, modules.module_end_date, modules.id, modules.module_name, modules.course_id, modules.staff_name, modules.status, modules.created_at, modules.updated_at FROM modules inner join staffs on modules.course_id = staffs.course_id and modules.staff_name = staffs.name where modules.course_id = staffs.course_id and modules.staff_name = staffs.name GROUP by staffs.email order by staffs.updated_at DESC limit 1", nativeQuery=true)
	List<Modules> selectingCourseNameModuleNameStaffNameModuleStartAndEndDate();
	
	
	
	
	
	

	// FIND MODULE BY  MODULE NAME
	@Query(value="SELECT DISTINCT modules.course_name,modules.module_start_date, modules.module_end_date, modules.id, modules.module_name, modules.course_id, modules.staff_name, modules.status, modules.created_at, modules.updated_at FROM modules where modules.module_name = ? order by modules.module_name", nativeQuery=true)
	List<Modules> findModuleByModuleName(String modules_name);

	
	
	
	
	
	// FIND MODULE BY  COURSE NAME
	@Query(value="SELECT DISTINCT modules.course_name,modules.module_start_date, modules.module_end_date, modules.id, modules.module_name, modules.course_id, modules.staff_name, modules.status, modules.created_at, modules.updated_at FROM modules where modules.course_name = ? order by modules.course_name", nativeQuery=true)
	List<Modules> findModuleByCourseName(String course_name);
	
	
	
	// FIND MODULE BY  COURSE ID
	@Query(value="SELECT DISTINCT modules.course_name,modules.module_start_date, modules.module_end_date, modules.id, modules.module_name, modules.course_id, modules.staff_name, modules.status, modules.created_at, modules.updated_at FROM modules where modules.course_id = ? order by modules.course_id", nativeQuery=true)
	List<Modules> findModuleByCourseID(Long course_id);
	
	
	
	
	
	@Query(value="select count(*) from modules", nativeQuery=true)
	public String countModule();
	
	
	
	
	
	
	
//  ALL MODULES UNDER EACH COURSE
	
	@Query(value="select modules.id, modules.module_name,modules.module_start_date, modules.module_end_date, modules.module_start_date, modules.module_end_date,modules.course_name, modules.course_id, modules.staff_name, modules.status, modules.created_at, modules.updated_at from modules inner join courses on modules.course_id = courses.id where modules.course_id = courses.id and courses.id = ?", nativeQuery=true)
	public List<Modules> allModulesUnderEachCourse(Long id);
	
	
	
	
	

//  ALL MODULES UNDER PAST COURSE
	
	@Query(value="select modules.id, modules.module_name,modules.module_start_date, modules.module_end_date, modules.module_start_date, modules.module_end_date,modules.course_name, modules.course_id, modules.staff_name, modules.status, modules.created_at, modules.updated_at from modules inner join courses on modules.course_id = courses.id where modules.course_id = courses.id and courses.id = ?", nativeQuery=true)
	public List<Modules> allModulesUnderPastStudentCourse(Long id);
	
	
	
	
	
	
	// METHOD TO RETRIEVE ALL COURSE NAME UNDER MODULE TABLE
	
	@Query(value="SELECT DISTINCT modules.course_name, modules.id,modules.module_start_date, modules.module_end_date, modules.module_name, modules.course_id, modules.staff_name, modules.status, modules.created_at, modules.updated_at FROM `modules`", nativeQuery=true)
	public List<Modules> getCourseNameAndCourseLevel();
	
	
	
	
	
	
	
	//  METHOD TO RETRIVE ONLY MODULE NAME AFTER STUDENT SEARCH RESULTS
	@Query(value="select modules.course_name, students.name, students.student_id, students.contact, students.gender, modules.module_name, results.marks from students, modules, results, courses WHERE students.course_id = modules.course_id AND students.student_id = results.student_id and courses.id = students.course_id and modules.id = results.module_id and modules.course_name = modules.course_name  AND students.student_id = students.student_id" , nativeQuery=true)
	public List<String> getAllModuleNames();
	
	
	

	
	

	

	
	
	




	//RETRIEVE THE TOTAL NUMBER OF MODULES UNDER EACH COURSE
	@Query(value="SELECT count(modules.module_name) from  modules inner join courses on modules.course_id = courses.id where modules.course_id = courses.id and courses.id = ?", nativeQuery=true)
	public String findTotalNumberOfModulesUnderEachCourseById(int id);
	
	
	



//  ALL STUDENTS UNDER EACH MODULES
	@Query(value="SELECT count(students.name) from  students inner join modules on modules.course_id = students.course_id where modules.course_id = students.course_id and modules.id = ?", nativeQuery=true)
	public String retrievalOfStudentsUnderEachModuleById(int module_id);


	
	
	
	
//  TOTAL NUMBER OF STUDENTS RESULTS UPLOADED
	@Query(value="SELECT DISTINCT COUNT(students_results.name) from  students_results  inner join modules on students_results.module_id = modules.id where students_results.module_id = modules.id and marks > 0 and modules.id = ?", nativeQuery=true)
	public String totalNumberOfStudentsResultsUploaded(int module_id);






	
//  RETRIEVE THE TOTAL NUMBER OF STUDENTS UNDER EACH MODULE
//@Query(value="SELECT modules.course_name,  modules.module_name, count(DISTINCT(students.name))from students, courses, modules where students.course_id = courses.id and courses.id = modules.course_id and modules.id = ? ;", nativeQuery=true)
	//public List<String> findTotalNumberOfStudentsUnderEachModuleById(int id);
 
	
	
	
	
	
	public ArrayList<String> findTotalNumberOfStudentsUnderEachModulesById(int id);
	
	
	
	
	
	

	
	
  	// RETRIEVE ONLY MODULE NAME AND COURSE NAME  
	
	@Query(value="SELECT DISTINCT students.name, students.student_id, modules.module_name, modules.course_name, staffs.name from students,staffs, courses, modules where students.course_id = courses.id and courses.id = modules.course_id and modules.id = ? GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
	public String retrieveModuleNameAndCourseName(int id);
	
	
	
	
	
	
	
	public Optional<Modules> findById(Long id);
	
	
	
	
	
	
	
	
//	// METHOD TO RETRIEVE ONLY STUDENT NAME AND ID 
//
//		@Query(value="SELECT DISTINCT students.name, students.student_id FROM students INNER JOIN modules ON modules.course_id = students.course_id where modules.id = ? GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
//		public List<StudentProfile> findAllStudentResults(int id);
  		
  			  			
	
	
	
		
		// METHOD TO RETRIEVE ONLY STUDENT NAME,ID, COURSE NAME,MODULE NAME AND STAFF NAME 
	
//		@Query(value="SELECT DISTINCT students.name, students.student_id, modules.module_name, modules.course_name, modules.staff_name from students, courses, modules where students.course_id = courses.id and courses.id = modules.course_id and modules.id = ? GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
//		public ArrayList<String> findAllStudentResults(int id);
	

}
