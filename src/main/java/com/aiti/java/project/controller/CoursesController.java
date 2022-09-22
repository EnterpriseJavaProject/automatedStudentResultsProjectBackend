package com.aiti.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiti.java.project.entities.CourseBatch;
import com.aiti.java.project.entities.Courses;
import com.aiti.java.project.repository.CourseBatchRepository;
import com.aiti.java.project.repository.CoursesRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/courses")
public class CoursesController {
	
	
	
	
	
	@Autowired
	CoursesRepository coursesRepo;
	
	@Autowired
	CourseBatchRepository courseBatchRepository;
	
	
	
	
	
	
	
	
	
	
	
	
	

//	// GET ALL COURSES FOR ANGULAR FRONTEND
	@GetMapping("/getAllCourses")
	public List<Courses> getAllCourse(){
		return coursesRepo.findAll();
	}
	
	
	
	
	
	
	
	
	  // COUNT ALL COURSES
	
	  @GetMapping("/countCourses")
	  public String countCourses() {
		  
		  return coursesRepo.countCourses();
	  }
	
	



//		//  SAVE COURSE
		
		@PostMapping("/saveCourses")
		public void saveCourses(@RequestBody Courses courses) {
			
			coursesRepo.save(courses);
		}
	  
	  
	  
	  
	  
	  
//		//  UPDATE COURSES
		
		@PatchMapping("/updateCourses")
		public Courses updateCourses(@RequestBody Courses course) {
			
			return coursesRepo.save(course);
		}
	  
	  
	  
	  
	  
	  
	  
 
	  
	  
	  
	  
//		// DELETE COURSE
		
		@DeleteMapping("/deleteCourseById")
		public void deleteCourse(@RequestParam ("id") Long id) {
			coursesRepo.deleteById(id);
		}

	  
	  
	  
	  
	  
	  
//		// FIND COURSE BY ID
		
		@GetMapping("/findCourseById")
		public Courses findById(@RequestParam("id") Long id) {
			return coursesRepo.findById(id).get();
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
	
//	// SELECTING FROM COURSE TABLE FOR RESULTS
//	
//	@GetMapping("/selectingFromCourseForResults")
//	public List<CourseBatch> selectingFromCourseForResults(@RequestParam ("student_id") String student_id, @RequestParam ("course_id") int course_id){
//		
//		return courseBatchRepository.selectingFromCourseForResults(student_id, course_id);
//	}
//	
//	


//	
//	
//	
//
//	// FIND ALL COURES
//	
//	@GetMapping("/findAllCourses")
//	public List<Courses> findAllCourses(){
//		return coursesRepo.findAllCourses();
//	}
//	
//	
//	
//	

//	
//	
//	
//	
//	
//	// FIND COURSE BY COURSE NAME
//	
//	  @GetMapping("/findCourseByCourseName") 
//	  public List<Courses> findByName(@RequestParam ("course_name") String course_name){ 
//		  return coursesRepo.findCourseByCourseName(course_name);
//		  
//	  }
//	  
//	
//	
//	  
//	  
//	  
//	  
//		
//		// FIND COURSE BY COURSE LEVEL
//		
//		  @GetMapping("/findCourseByCourseLevel") 
//		  public List<Courses> findByCourseLevel(@RequestParam ("course_level") String course_level){ 
//			  return coursesRepo.findCourseByCourseLevel(course_level);
//			  
//		  }  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//
//	  
//	
//
//
//	  
//	  
//
//	  
//	  
//	  
//	
//	
//	//	FIND STAFF COURSES
//	
//@GetMapping("/findStaffCourses")
//public List<Courses> findStaffCourses(@RequestParam("staff_id") Long staff_id) {
//
//	return coursesRepo.findStaffCourses(staff_id);
//
//}
//
//
//	  
//	  
//		// TOTAL NUMBER OF MODULES UNDER EACH COURSE
//	  
//	  @GetMapping("/totalNumberOfModulesUnderEachCourse")
//	  public Long totalNumberOfModulesUnderEachCourse(@RequestParam("id") Long id) {
//		  
//		  return coursesRepo.totalNumberOfModulesUnderEachCourse(id);
//	  }
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//	  
//		//  STUDENTS UNDER EACH COURSE
//	  
//	  @GetMapping("/totalNumberOfStudentsUnderEachCourse")
//	  public Long totalNumberOfStudentsUnderEachCourse(@RequestParam("id") Long id) {
//		  
//		  return coursesRepo.totalNumberOfStudentsUnderEachCourse(id);
//	  }
//	  
//	  
//	  
//	  
//	
//	
//	  // GET COURSE NAME AND COURSE LEVEL
//		
//		@GetMapping("/getCourseNameAndCourseLevel")
//		public List<Courses> getCourseNameAndCourseLevel(){
//			
//			return coursesRepo.getCourseNameAndCourseLevel();
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		//	FIND STUDENT COURSES
//		
//		@GetMapping("/findStudentCourses")
//		public List<CourseBatch> findStudentCourses(@RequestParam("student_id") Long student_id) {
//
//			return courseBatchRepository.findStudentCourseBatch(student_id);
//
//		}
//
//
//
//
//
//
//			
//			  
//				//	FIND PAST STUDENT COURSES
//				
//			@GetMapping("/findPastStudentCourses")
//			public List<CourseBatch> findPastStudentCourseBatch(@RequestParam("student_id") Long student_id) {
//
//				return courseBatchRepository.findPastStudentCoursesBatch(student_id);
//
//			}
//		
//		
//		
//		
		
		
		
		
		
		
		
		

}
