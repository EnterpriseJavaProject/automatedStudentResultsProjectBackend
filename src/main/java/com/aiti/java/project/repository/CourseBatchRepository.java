package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.CourseBatch;


public interface CourseBatchRepository extends JpaRepository<CourseBatch, Long> {
	
	
	
	
	
	
	// FIND ALL COURSE BATCHES BY COURSE ID
	@Query(value="SELECT * FROM course_batch inner join courses on course_batch.course_name = courses.course_name and course_batch.course_id = courses.id where course_batch.course_name = courses.course_name and course_batch.course_id = courses.id and courses.id = ?" , nativeQuery = true )
	List<CourseBatch> findAllCourseBatchesByCourseID(int course_id);
	
	
	
	
	
	
	// SELECTING FROM COURSE TABLE FOR RESULTS
	
	@Query(value="SELECT DISTINCT * FROM course_batch inner join students_results on course_batch.id = students_results.batch_id where course_batch.id = students_results.batch_id and students_results.student_id = ? and students_results.batch_id = ?", nativeQuery=true)
	public List<CourseBatch> selectingFromCourseBatchForResults(String student_id, int course_id);

		




	
		
		//	FIND STUDENT COURSE BATCH
		
		@Query(value="SELECT * FROM course_batch inner join students on course_batch.id = students.batch_id WHERE course_batch.id = students.batch_id and students.id = ? GROUP by course_batch.id order by course_batch.id", nativeQuery=true)
		public List<CourseBatch> findStudentCourseBatch(Long student_id);
		
		
		
		
		
		//	FIND PAST STUDENT COURSE BATCH
		
		@Query(value="SELECT * FROM course_batch inner join past_students on course_batch.id = past_students.batch_id WHERE course_batch.id = past_students.batch_id and past_students.id = ? GROUP by course_batch.id order by course_batch.id", nativeQuery=true)
		public List<CourseBatch> findPastStudentCoursesBatch(Long student_id);
		
		
		
		
//		FIND STAFF COURSES BATCH
		
		@Query(value="SELECT * FROM course_batch inner join staff_details on course_batch.id = staff_details.batch_id WHERE course_batch.id = staff_details.batch_id and staff_details.id = ? GROUP by course_batch.id order by course_batch.id", nativeQuery=true)
		public List<CourseBatch> findStaffCourses(Long staff_id);
		
		
		
		
		
		
		// FIND COURSE BATCH BY COURSE NAME
		@Query(value="select * from course_batch where course_batch.course_name = ?" , nativeQuery = true )
		List<CourseBatch> findCourseBatchByCourseName(String course_id);
		
		
		
		
		
		// FIND COURSE BATCH BY COURSE LEVEL
		@Query(value="select * from course_batch where course_batch.course_level = ?" , nativeQuery = true )
		List<CourseBatch> findCourseBatchByCourseLevel(String course_level);
		
		
		
		
		
		
		
		//  GET ONLY COURSE NAME AND COURSE LEVEL
		@Query(value="SELECT * FROM course_batch ORDER by course_batch.id" , nativeQuery = true )
		CourseBatch[] getCourseNameAndCourseLevel();
		

		
		
		@Query(value="select * from course_batch order by id;", nativeQuery=true)
		public List<CourseBatch> findAllCourseBatches();
		


		
		@Query(value="select count(*) from course_batch", nativeQuery=true)
		public String countCourseBatches();
		
		
		
		
		// MODULES UNDER EACH COURSE BATCH
		
		@Query(value="select modules.module_name, modules.module_start_date, modules.module_end_date from  modules inner join course_batch on modules.batch_id = course_batch.id where modules.batch_id = course_batch.id and course_batch.id = ? GROUP by modules.module_name order by modules.module_name", nativeQuery=true)
		public Long allModulesUnderEachCourse(Long id);
		
		
		
		
		
		
		
		// TOTAL NUMBER OF MODULES UNDER EACH COURSE BATCH
		
		@Query(value="select count(modules.module_name) from  modules inner join course_batch on modules.batch_id = course_batch.id where modules.batch_id = course_batch.id and course_batch.id = ? GROUP by modules.module_name", nativeQuery=true)
		public Long totalNumberOfModulesUnderEachCourseBatch(Long id);
		
		
		
		
		
		//  STUDENTS UNDER EACH COURSE BATCH
		
		@Query(value="select count(students.name) from students inner join course_batch on students.batch_id = course_batch.id where students.batch_id = course_batch.id and course_batch.id = ? GROUP by course_batch.id order by course_batch.id", nativeQuery=true)
		public Long totalNumberOfStudentsUnderEachCourse(Long id);

	
	
	
	
	
	
	
	
	

}
