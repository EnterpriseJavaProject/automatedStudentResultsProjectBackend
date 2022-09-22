package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
	
	
	
	
	
	// SENDING STUDENTS MODULE NAME EMAIL AFTER RESULTS BEEN UPLOADED
	@Query(value="select DISTINCT students_results.module_name from students_results inner join students on students_results.name = students.name and students_results.student_id = students.student_id and students_results.batch_id = students.batch_id where students_results.marks >= 1 and students_results.name = students.name and students_results.student_id = students.student_id and students_results.batch_id = students.batch_id GROUP by students_results.updated_at order by students_results.updated_at DESC LIMIT 1" , nativeQuery = true )
	String sendingStudentModuleNameEmailAfterRestultsBeenUploaded();
	
	
	
	// SENDING STUDENTS COURSE NAME EMAIL AFTER RESULTS BEEN UPLOADED
	@Query(value="select DISTINCT course_batch.course_name from course_batch inner join students_results on course_batch.batch_id = students_results.batch_id and course_batch.coordinator = students_results.staff_name where students_results.marks >= 1 and course_batch.batch_id = students_results.batch_id and course_batch.coordinator = students_results.staff_name GROUP by students_results.updated_at order by students_results.updated_at DESC LIMIT 1" , nativeQuery = true )
	String sendingStudentCourseNameEmailAfterRestultsBeenUploaded();
	
	
	
	
	// SENDING STUDENTS EMAIL AFTER RESULTS BEEN UPLOADED
	@Query(value="select DISTINCT students.email from students INNER join students_results on students.student_id = students_results.student_id and students.batch_id = students_results.batch_id where students_results.marks >= 1 and students.student_id = students_results.student_id and students.batch_id = students_results.batch_id GROUP by students_results.updated_at order by students_results.updated_at" , nativeQuery = true )
	String[] sendingStudentEmailAfterRestultsBeenUploaded();
	
	
	
	
	// SENDING STUDENTS WELCOME EMAIL AFTER BEING ADMTITTED
	@Query(value="SELECT students.email FROM students GROUP by students.updated_at ORDER by students.updated_at desc limit 1" , nativeQuery = true )
	String sendingStudentsWelcomeEmailAfterBeingAdmitted();
	
	
	
	// SELECTING ONLY COURSE NAME AS STUDENT EMAIL SUBJECT
	@Query(value="SELECT course_batch.course_name FROM course_batch INNER join students on course_batch.batch_id = students.batch_id where course_batch.batch_id = students.batch_id GROUP by students.updated_at ORDER by students.updated_at desc limit 1" , nativeQuery = true )
	String selectingOnlyCourseNameAsStudentEmailSubject();
	
	
	
	
	// SELECTING ONLY COURSE LEVEL AS STUDENT EMAIL SUBJECT
	@Query(value="SELECT course_batch.course_level FROM course_batch INNER join students on course_batch.batch_id = students.batch_id where course_batch.batch_id = students.batch_id GROUP by students.updated_at ORDER by students.updated_at desc limit 1" , nativeQuery = true )
	String selectingOnlyCourseLevelAsStudentEmailSubject();
	
	
	
	
	// SELECTING ONLY COURSE START DATE AS STUDENT EMAIL SUBJECT
	@Query(value="SELECT course_batch.course_start_date FROM course_batch INNER join students on course_batch.batch_id = students.batch_id where course_batch.batch_id = students.batch_id GROUP by students.updated_at ORDER by students.updated_at desc limit 1" , nativeQuery = true )
	String selectingOnlyCourseStartDateAsStudentEmailSubject();

	
	
	
	// SELECTING ONLY COURSE END DATE AS STUDENT EMAIL SUBJECT
	@Query(value="SELECT course_batch.course_end_date FROM course_batch INNER join students on course_batch.batch_id = students.batch_id where course_batch.batch_id = students.batch_id GROUP by students.updated_at ORDER by students.updated_at desc limit 1" , nativeQuery = true )
	String selectingOnlyCourseEndDateAsStudentEmailSubject();
	
	
	
	// SELECTING ONLY COORDINATOR AS STUDENT EMAIL SUBJECT
	@Query(value="SELECT course_batch.coordinator FROM course_batch INNER join students on course_batch.batch_id = students.batch_id where course_batch.batch_id = students.batch_id GROUP by students.updated_at ORDER by students.updated_at desc limit 1" , nativeQuery = true )
	String selectingOnlyCoordinatorAsStudentEmailSubject();
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// SELECTING FROM STUDENT TABLE FOR RESULTS
	@Query(value="SELECT DISTINCT students.id, students.batch_id, students.name, students.student_id, students.batch_id, students.date_of_birth, students.contact, students.gender,students.fees, students.email, students.status, students.created_at, students.updated_at FROM students inner join students_results on students.student_id = students_results.student_id where students.student_id = students_results.student_id and students_results.student_id = ? and students_results.batch_id = ?  GROUP by students.id ORDER BY students.id", nativeQuery=true)
	public List<StudentProfile> selectingFromStudentForResults(String student_id, int batch_id);
	
	
	
	
	
	
		// TOTAL NUMBER OF STUDENTS WITH FULL PAYMENT
	@Query(value="select count(*) from students where fees LIKE '%Full%' order by students.fees ", nativeQuery=true)
	public String totalNumberOfStudentWithFullPayment();
	
	
	
	
	
	
	// TOTAL NUMBER OF STUDENTS WITH PART PAYMENT
	@Query(value="select count(*) from students where fees LIKE '%Part%' order by students.fees ", nativeQuery=true)
	public String totalNumberOfStudentWithPartPayment();
	
	
	
	
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
	
	@Query(value="SELECT students.id, students.name, students.batch_id, students.student_id, students.batch_id, students.date_of_birth, students.contact, students.gender,students.fees, students.email, students.status, students.created_at, students.updated_at FROM students INNER JOIN modules ON students.batch_id = modules.batch_id where students.batch_id = modules.batch_id and modules.id = ?", nativeQuery=true)
	public StudentProfile[] retrieveStudentsUnderModule(Long id);
	
	
	
	// METHOD TO RETRIEVE STUDENTS UNDER EACH COURSE 
	
	@Query(value="SELECT  students.id, students.name, students.batch_id, students.student_id, students.date_of_birth, students.contact, students.gender,students.fees, students.email, students.status, students.created_at, students.updated_at FROM students INNER JOIN course_batch ON students.batch_id = course_batch.batch_id where students.batch_id = course_batch.batch_id and course_batch.id = ?", nativeQuery=true)
	public StudentProfile[] retrieveStudentsUnderCourse(Long id);
	
	
	
	
	
	List<StudentProfile> findByName(String name);
	
	
	
	
	
}
