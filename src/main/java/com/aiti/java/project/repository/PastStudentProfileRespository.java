package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.PastStudentProfile;

public interface PastStudentProfileRespository extends JpaRepository<PastStudentProfile, Long> {
	
	
	
	
	// SELECTING ONLY PAST STUDENT STUDENT ID 
	
	@Query(value="SELECT DISTINCT past_students.id, past_students.name, past_students.student_id, past_students.course_id, past_students.date_of_birth, past_students.contact, past_students.gender, past_students.email, past_students.fees, past_students.status, past_students.created_at, past_students.updated_at FROM past_students  WHERE past_students.id = ?", nativeQuery=true)
	public PastStudentProfile findPastStudentById(int id);
	
	

	
	// SELECTING ONLY PAST STUDENT STUDENT ID 
	
	@Query(value="SELECT past_students.id, past_students.name, past_students.student_id, past_students.course_id, past_students.date_of_birth, past_students.contact, past_students.gender, past_students.email, past_students.fees, past_students.status, past_students.created_at, past_students.updated_at FROM past_students inner join students on past_students.id = students.id WHERE past_students.id = students.id and students.id = ?", nativeQuery=true)
	public PastStudentProfile[] retrievingOnlyPastStudentStudentID(Long student_id);
	
	
	
	
	
	// SELECTING FROM STUDENT TABLE FOR RESULTS
	@Query(value="SELECT DISTINCT past_students.id, past_students.name, past_students.student_id, past_students.course_id, past_students.date_of_birth, past_students.contact, past_students.gender,past_students.fees, past_students.email, past_students.status, past_students.created_at, past_students.updated_at FROM past_students inner join students_results on past_students.student_id = students_results.student_id where past_students.student_id = students_results.student_id and students_results.student_id = ? and students_results.course_id = ?  GROUP by past_students.id ORDER BY past_students.id", nativeQuery=true)
	public List<PastStudentProfile> selectingFromPastStudentForResults(String student_id, int course_id);
	
	
	
	
	
	
		// TOTAL NUMBER OF STUDENTS WITH FULL PAYMENT
	@Query(value="select count(*) from past_students where fees LIKE '%Full%' order by past_students.fees ", nativeQuery=true)
	public String totalNumberOfStudentWithFullPayment();
	
	
	
	
	
	
	// TOTAL NUMBER OF STUDENTS WITH PART PAYMENT
	@Query(value="select count(*) from past_students where fees LIKE '%Part%' order by past_students.fees ", nativeQuery=true)
	public String totalNumberOfStudentWithPartPayment();
	
	
	
	
	// COUNT ALL STUDENTS
	@Query(value="select count(*) from past_students", nativeQuery=true)
	public String countStudent();
	
	
	
	
	// COUNT ALL MALE STUDENTS
	@Query(value="select count(*) from past_students where gender = 'Male' ", nativeQuery=true)
	public String countAllMaleStudent();
	
	
	
	
	// COUNT ALL FEMALE STUDENTS
	@Query(value="select count(*) from past_students where gender = 'Female' ", nativeQuery=true)
	public String countAllFemaleStudent();
	
	
	
	// METHOD TO RETRIEVE STUDENTS UNDER EACH MODULE 
	
	@Query(value="SELECT DISTINCT past_students.id, past_students.name, past_students.student_id, past_students.course_id, past_students.date_of_birth, past_students.contact, past_students.gender,past_students.fees, past_students.email, past_students.status, past_students.created_at, past_students.updated_at FROM past_students INNER JOIN modules ON past_students.course_id = modules.course_id where past_students.course_id = modules.course_id and modules.id = ?", nativeQuery=true)
	public PastStudentProfile[] retrieveStudentsUnderModule(Long id);
	
	
	
	
	
	List<PastStudentProfile> findByName(String name);
	
	
	
	
	
}
