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
import com.aiti.java.project.entities.Modules;
import com.aiti.java.project.repository.CourseBatchRepository;
import com.aiti.java.project.repository.ModulesRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/courseBatch")
public class CourseBatchController {
	
	
	@Autowired
	ModulesRepository modulesRepo;
	
	
	@Autowired
	CourseBatchRepository courseBatchRepository;
	
	
	
	
	

	
	
	
	
	
	
	// FIND ALL COURSE BATCHES BY COURSE ID
	
	  @GetMapping("/findAllCourseBatchesByCourseID") 
	  public List<CourseBatch> findAllCourseBatchesByCourseID(@RequestParam ("course_name") int course_id){ 
		  
		  return courseBatchRepository.findAllCourseBatchesByCourseID(course_id);
		  
	  }
	
	
	
	
	
	  
	  
	  
	  
		//   ALL MODULES UNDER EACH COURSE
	  @GetMapping("/findModulesUnderEachCourseBatch")
	  public List<Modules> findModulesUnderEachCourseBatchByID(@RequestParam("id") Long id) {
		  
		  return modulesRepo.allModulesUnderEachCourseBatch(id);
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	
	
	
	
	
	
	
	// SELECTING FROM COURSE TABLE FOR RESULTS
	
	@GetMapping("/selectingFromCourseBatchForResults")
	public List<CourseBatch> selectingFromCourseBatchForResults(@RequestParam ("student_id") String student_id, @RequestParam ("course_id") int course_id){
		
		return courseBatchRepository.selectingFromCourseBatchForResults(student_id, course_id);
	}
	
	
	
	
	
	
	
	
	
	
	
//	//	FIND STUDENT COURSE BATCH
	
	@GetMapping("/findStudentCourseBatch")
	public List<CourseBatch> findStudentCourseBatch(@RequestParam("student_id") Long student_id) {

		return courseBatchRepository.findStudentCourseBatch(student_id);

	}




	
	
	
	


		
		  
			//	FIND PAST STUDENT COURSE BATCH
			
		@GetMapping("/findPastStudentCourseBatch")
		public List<CourseBatch> findPastStudentCourseBatch(@RequestParam("student_id") Long student_id) {

			return courseBatchRepository.findPastStudentCoursesBatch(student_id);

		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// GET ALL COURSE BATCHES
	
	@GetMapping("/getAllCourse")
	public List<CourseBatch> getAllCourses(){
		
		return courseBatchRepository.findAll();
		
	}
  
	
	
	
	
	
	
	
	//  SAVE COURSE
	
	@PostMapping("/saveCourseBatch")
	public void saveCourseBatch(@RequestBody CourseBatch courses) {
		
		courseBatchRepository.save(courses);
	}
	
	
	
	
	
	
	
	
	
	
	
	//  UPDATE COURSES
	
	@PatchMapping("/updateCourses")
	public CourseBatch updateCourses(@RequestBody CourseBatch course) {
		
		return courseBatchRepository.save(course);
	}
	
	
	
	
	
	
	
	
	// DELETE COURSE
	
	@DeleteMapping("/deleteCourseById")
	public void deleteCourse(@RequestParam ("id") Long id) {
		courseBatchRepository.deleteById(id);
	}
	
	
	
	// FIND COURSE BY ID
	
	@GetMapping("/findCourseById")
	public CourseBatch findById(@RequestParam("id") Long id) {
		return courseBatchRepository.findById(id).get();
	}
	
	
	
	
	
	// FIND COURSE BATCH BY COURSE NAME
	
	  @GetMapping("/findCourseByCourseName") 
	  public List<CourseBatch> findByName(@RequestParam ("course_name") String course_name){ 
		  return courseBatchRepository.findCourseBatchByCourseName(course_name);
		  
	  }
	  
	
	
	  
	  
	  
	  
		
		// FIND COURSE BY COURSE LEVEL
		
		  @GetMapping("/findCourseByCourseLevel") 
		  public List<CourseBatch> findByCourseLevel(@RequestParam ("course_level") String course_level){ 
			  return courseBatchRepository.findCourseBatchByCourseLevel(course_level);
			  
		  }  
	  
	  
	  
	  
	  
	  
	  
	  // COUNT ALL COURSE BATCHES
	
	  @GetMapping("/countAllCourseBatch")
	  public String countAllCourseBatch() {
		  
		  return courseBatchRepository.countCourseBatches();
	  }
	  
	


	
	  
	  
	  
	
	
	//	FIND STAFF COURSES
	
@GetMapping("/findStaffCourses")
public List<CourseBatch> findStaffCourses(@RequestParam("staff_id") Long staff_id) {

	return courseBatchRepository.findStaffCourses(staff_id);

}


	  
	  
		// TOTAL NUMBER OF MODULES UNDER EACH COURSE
	  
	  @GetMapping("/totalNumberOfModulesUnderEachCourse")
	  public Long totalNumberOfModulesUnderEachCourse(@RequestParam("id") Long id) {
		  
		  return courseBatchRepository.totalNumberOfModulesUnderEachCourseBatch(id);
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		//  STUDENTS UNDER EACH COURSE
	  
	  @GetMapping("/totalNumberOfStudentsUnderEachCourse")
	  public Long totalNumberOfStudentsUnderEachCourse(@RequestParam("id") Long id) {
		  
		  return courseBatchRepository.totalNumberOfStudentsUnderEachCourse(id);
	  }
	  
	  
	  
	  
	
	
	  // GET COURSE NAME AND COURSE LEVEL
		
		@GetMapping("/getCourseNameAndCourseLevel")
		public CourseBatch[] getCourseNameAndCourseLevel(){
			
			return courseBatchRepository.getCourseNameAndCourseLevel();
		}
		
		

}
