package com.aiti.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiti.java.project.entities.PastStudentProfile;
import com.aiti.java.project.repository.PastStudentProfileRespository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pastStudents")
public class PastStudentProfileController {
	
	

	
	@Autowired
	PastStudentProfileRespository pastStudentProfileRespository;
	
	
	

	
	
	// PAST STUDENTS UNDER EACH COURSE
  	
  	
  	@GetMapping("/findPastStudentsUnderCourse")
  	public PastStudentProfile[] retrieveStudentsUnderCourse(@RequestParam("course_id") Long course_id) {
  		
		return pastStudentProfileRespository.retrievePastStudentsUnderCourse(course_id);
  						  		
  	}
	
	
	
	
	
	
	
	
	

	
	
	// SELECTING ONLY PAST STUDENT STUDENT ID
	
	@GetMapping("/retrievingOnlyPastStudentStudentID")
	public PastStudentProfile[] retrievingOnlyPastStudentStudentID(@RequestParam ("student_id") Long student_id) {
		
		 return pastStudentProfileRespository.retrievingOnlyPastStudentStudentID(student_id);
	}
	
	
	
	
	
	// SELECTING FROM STUDENT TABLE FOR RESULTS

@GetMapping("/selectingFromPastStudentForResults")
public List<PastStudentProfile> selectingFromPastStudentForResults(@RequestParam ("student_id") String student_id, @RequestParam ("course_id") int course_id){
	
	return pastStudentProfileRespository.selectingFromPastStudentForResults(student_id, course_id);
}



	
	
	
	
	
	
	
	//  FIND STUDENT BY ID
	
	@GetMapping("/findPastStudentById")
	public PastStudentProfile findById(@RequestParam ("id") int id) {
		 return pastStudentProfileRespository.findPastStudentById(id);
	}
	
	
	
	
	
	//  FIND STUDENT BY NAME
	
	  @GetMapping("/findPastStudentByName") 
	  public List<PastStudentProfile> findByName(@RequestParam ("name") String name){ 
		  return pastStudentProfileRespository.findByName(name);
		  
	  }
	  
	  
	  

	  
	  //  COUNT ALL STUDENTS
	  
	  @GetMapping("/countPastStudent")
	  public String countStudent() {
		  return pastStudentProfileRespository.countStudent();
	  }
	 

	  
	  //  COUNT ALL MALE STUDENTS
	  
	  @GetMapping("/countAllMalePastStudent")
	  public String countAllMaleStudent() {
		  return pastStudentProfileRespository.countAllMaleStudent();
	  }
	  
	  
	  
	  
	  
	  //  COUNT ALL FEMALE STUDENTS
	  
	  @GetMapping("/countAllFemalePastStudent")
	  public String countAllFemaleStudent() {
		  return pastStudentProfileRespository.countAllFemaleStudent();
	  }
	  
	  
	  
	  
	  
	  
	  
		// TOTAL NUMBER OF STUDENTS WITH FULL PAYMENT
	  
	  @GetMapping("/totalNumberOfPastStudentWithFullPayment")
	  public String totalNumberOfStudentWithFullPayment() {
		  return pastStudentProfileRespository.totalNumberOfStudentWithFullPayment();
	  }
	  
	  
	  
	  
	  
		// TOTAL NUMBER OF STUDENTS WITH PART PAYMENT
	  
	  @GetMapping("/totalNumberOfPastStudentWithPartPayment")
	  public String totalNumberOfStudentWithPartPayment() {
		  return pastStudentProfileRespository.totalNumberOfStudentWithPartPayment();
	  }
	  
	  
	  	  	
	  	
		// METHOD TO RETRIEVE ONLY STUDENT NAME AND STUDENT ID  ?id=1
	  	
	  	
	  	@GetMapping("/findPastStudentsUnderModule")
	  	public PastStudentProfile[] retrieveStudentsUnderModule(@RequestParam("id") Long id) {
	  		
			return pastStudentProfileRespository.retrieveStudentsUnderModule(id);
	  						  		
	  	}
	  	
	  	
	  	
	  	
	  
		
		
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	@GetMapping("/retrievePastStudentsUnderModule/{id}")
	  	public PastStudentProfile[] findStudentsUnderModule(@PathVariable("id") Long id) {
	  		
			return pastStudentProfileRespository.retrieveStudentsUnderModule(id);
	  						  		
	  	}
		
}
