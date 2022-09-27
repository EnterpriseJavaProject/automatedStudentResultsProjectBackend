package com.aiti.java.project.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Modules;

public interface ModulesRepository extends JpaRepository<Modules, Long>  {
	
	
	
	
	// FIND ALL MODULES HANDLED BY INSTRUCTOR
	@Query(value="SELECT * FROM modules inner join staff_details on modules.batch_id = staff_details.batch_id and modules.staff_name = staff_details.name where  modules.batch_id = staff_details.batch_id and modules.staff_name = staff_details.name GROUP by modules.id ORDER by modules.id", nativeQuery=true)
	List<Modules> findAllModuleHandledByInstructor();
	
	
	
	
	
	
	
	// SELECTING ONLY STAFF NAME FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT DISTINCT * FROM modules inner join staff_details on modules.batch_id = staff_details.batch_id and modules.staff_name = staff_details.name where staff_details.usertype not like '%Academic Secretary%' and staff_details.usertype not like '%Course Cordinator%' and staff_details.usertype not like '%Director of Studies%' and modules.batch_id = staff_details.batch_id and modules.staff_name = staff_details.name GROUP by staff_details.email order by staff_details.updated_at desc limit 1" , nativeQuery = true )
	String selectingStaffNameCourseAndModuleNameModuleStartAndEndDatetoSendEmailNotificationtoInstructors();
	
	
	
	
	
	
	
	
	
	
	// SELECTING ONLY STAFF NAME FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT modules.staff_name FROM modules GROUP by modules.updated_at order by modules.updated_at desc limit 1" , nativeQuery = true )
	String selectingStaffNametoSendEmailNotification();
	



	
	// SELECTING ONLY COURSE NAME FROM MODULE AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT modules.course_id FROM modules GROUP by modules.updated_at order by modules.updated_at desc limit 1" , nativeQuery = true )
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
	@Query(value="SELECT  DISTINCT * FROM modules inner join staff_details on modules.batch_id = staff_details.batch_id and modules.staff_name = staff_details.name where modules.batch_id = staff_details.batch_id and modules.staff_name = staff_details.name GROUP by staff_details.email order by staff_details.updated_at DESC limit 1", nativeQuery=true)
	List<Modules> selectingCourseNameModuleNameStaffNameModuleStartAndEndDate();
	
	
	
	
	
	

	// FIND MODULE BY  MODULE NAME
	@Query(value="SELECT DISTINCT * FROM modules where modules.module_name = ? order by modules.module_name", nativeQuery=true)
	List<Modules> findModuleByModuleName(String modules_name);

	
	
	
	
	
	// FIND MODULE BY  COURSE NAME
	@Query(value="SELECT DISTINCT * FROM modules where modules.batch_id = ? order by modules.batch_id", nativeQuery=true)
	List<Modules> findModuleByCourseName(String batch_id);
	
	
	
	// FIND MODULE BY  COURSE ID
	@Query(value="SELECT DISTINCT * FROM modules where modules.batch_id = ? order by modules.batch_id", nativeQuery=true)
	List<Modules> findModuleByCourseID(Long batch_id);
	
	
	
	
	
	@Query(value="select count(*) from modules", nativeQuery=true)
	public String countModule();
	
	
	
	
	
//  ALL MODULES UNDER EACH COURSE BATCH
	
	@Query(value="select * from modules inner join course_batch on modules.batch_id = course_batch.id where modules.batch_id = course_batch.id and course_batch.id = ?", nativeQuery=true)
	public List<Modules> allModulesUnderEachCourseBatch(Long id);
	
	
	
	
	
	
	
//  ALL MODULES UNDER EACH COURSE
	
	@Query(value="select * from modules inner join course_batch on modules.batch_id = course_batch.id where modules.batch_id = course_batch.id and course_batch.id = ?", nativeQuery=true)
	public List<Modules> allModulesUnderEachCourse(Long id);
	
	
	

	
	
//  ALL MODULES UNDER STUDENT COURSE
	
	@Query(value="select * from modules inner join course_batch on modules.batch_id = course_batch.id where modules.batch_id = course_batch.id and course_batch.id = ?", nativeQuery=true)
	public List<Modules> allModulesUnderStudentCourse(Long id);
	
	
	
	

//  ALL MODULES UNDER PAST STUDENT COURSE
	
	@Query(value="select * from modules inner join course_batch on modules.batch_id = course_batch.id where modules.batch_id = course_batch.id and course_batch.id = ?", nativeQuery=true)
	public List<Modules> allModulesUnderPastStudentCourseBatch(Long id);
	
	
	
	
	
	
	// METHOD TO RETRIEVE ALL COURSE NAME UNDER MODULE TABLE
	
	@Query(value="SELECT DISTINCT * FROM `modules`", nativeQuery=true)
	public List<Modules> getCourseNameAndCourseLevel();
	
	
	
	
	
	
	
	//  METHOD TO RETRIVE ONLY MODULE NAME AFTER STUDENT SEARCH RESULTS
	@Query(value="select modules.course_id, students.name, students.student_id, students.contact, students.gender, modules.module_name, results.marks from students, modules, results, course_batch WHERE students.course_id = modules.course_id AND students.student_id = results.student_id and course_batch.id = students.course_id and modules.id = student_results.module_id and modules.course_id = modules.course_id  AND students.student_id = students.student_id" , nativeQuery=true)
	public List<String> getAllModuleNames();
	
	
	

	
	

	

	
	
	




	//RETRIEVE THE TOTAL NUMBER OF MODULES UNDER EACH COURSE
	@Query(value="SELECT count(modules.module_name) from  modules inner join course_batch on modules.batch_id = course_batch.id where modules.batch_id = course_batch.id and course_batch.id = ?", nativeQuery=true)
	public String findTotalNumberOfModulesUnderEachCourseById(int id);
	
	
	



//  ALL STUDENTS UNDER EACH MODULES
	@Query(value="SELECT count(students.name) from students inner join modules on modules.batch_id = students.batch_id where modules.batch_id = students.batch_id and modules.id = ?", nativeQuery=true)
	public String retrievalOfStudentsUnderEachModuleById(int module_id);


	
	
	
	
//  TOTAL NUMBER OF STUDENTS RESULTS UPLOADED
	@Query(value="SELECT DISTINCT COUNT(students_results.name) from  students_results  inner join modules on students_results.module_name = modules.module_name where students_results.module_name = modules.module_name and marks > 0 and modules.id = ?", nativeQuery=true)
	public String totalNumberOfStudentsResultsUploaded(int module_id);






	
//  RETRIEVE THE TOTAL NUMBER OF STUDENTS UNDER EACH MODULE
//@Query(value="SELECT modules.course_id,  modules.module_name, count(DISTINCT(students.name))from students, course_batch, modules where students.course_id = course_batch.id and course_batch.id = modules.course_id and modules.id = ? ;", nativeQuery=true)
	//public List<String> findTotalNumberOfStudentsUnderEachModuleById(int id);
 
	
	
	
	
	
	public ArrayList<String> findTotalNumberOfStudentsUnderEachModulesById(int id);
	
	
	
	
	
	

	
	
  	// RETRIEVE ONLY MODULE NAME AND COURSE NAME  
	
	@Query(value="SELECT DISTINCT students.name, students.student_id, modules.module_name, modules.course_id, staff_details.name from students,staff_details, course_batch, modules where students.course_id = course_batch.id and course_batch.id = modules.course_id and modules.id = ? GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
	public String retrieveModuleNameAndCourseName(int id);
	
	
	
	
	
	
	
	public Optional<Modules> findById(Long id);
	
	
	
	
	
	
	// METHOD TO RETRIEVE ALL COURSE NAME UNDER MODULE TABLE
	
	@Query(value="SELECT * FROM modules", nativeQuery=true)
	public List<Modules> findAllModules();
	
	
//	// METHOD TO RETRIEVE ONLY STUDENT NAME AND ID 
//
//		@Query(value="SELECT DISTINCT students.name, students.student_id FROM students INNER JOIN modules ON modules.course_id = students.course_id where modules.id = ? GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
//		public List<StudentProfile> findAllStudentResults(int id);
  		
  			  			
	
	
	
		
		// METHOD TO RETRIEVE ONLY STUDENT NAME,ID, COURSE NAME,MODULE NAME AND STAFF NAME 
	
//		@Query(value="SELECT DISTINCT students.name, students.student_id, modules.module_name, modules.course_id, modules.staff_name from students, course_batch, modules where students.course_id = course_batch.id and course_batch.id = modules.course_id and modules.id = ? GROUP by students.student_id ORDER BY modules.id", nativeQuery=true)
//		public ArrayList<String> findAllStudentResults(int id);
	

}
