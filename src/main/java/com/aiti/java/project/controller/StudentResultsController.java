package com.aiti.java.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

import com.aiti.java.project.entities.StudentResults;
import com.aiti.java.project.repository.StudentResultsRepositry;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
@RequestMapping("/studentResults")
public class StudentResultsController {
	
	
	
	@Autowired
	StudentResultsRepositry studentResultsRepositry;
	
	
	
	
	
	
	
	//  GET ALL RESULTS
	
	@GetMapping("/getAllResults")
	public List<StudentResults> findAllResults(){
		
		return studentResultsRepositry.findAll();
	}
	
	
	
	

	
	//  SAVE ALL RESULTS
	
	@PostMapping("/saveAllResults")
	public List<StudentResults> saveAllResults(@RequestBody List<StudentResults> saveResults){
		
		return studentResultsRepositry.saveAll(saveResults);
	}
	
	
	
	
	
	
	// SAVE A SINGLE RESULTS
	
	@PostMapping("/saveResults")
	public StudentResults saveResults(@RequestBody StudentResults save) {
		
		return studentResultsRepositry.save(save);
	}
	
	
	
	
	
	
	// UPDATE RESULTS
	
	@PatchMapping("updateResults")
	public StudentResults updateResults(@RequestBody StudentResults update) {
		
		return studentResultsRepositry.save(update);
	}
	
	
	
	
	
	
//	//  DELETE RESULTS
	@DeleteMapping("/delete")
	public void deleteResults(@RequestParam ("id") Long id) {
		
		studentResultsRepositry.deleteById(id);
		
	}
	
	
	
	
	
//	// FIND RESULTS BY ID
	
	@GetMapping("/findResultsById")
	public StudentResults findById(@RequestParam("id") Long id) {
		
		return studentResultsRepositry.findById(id).get();
		
	}

	
	
	
	
	

//	// FIND REULTS BY STUDENT NAME
	
	  @GetMapping("/findResultsByStudentName") 
	  public List<StudentResults> retrieveResultsByStudentName(@RequestParam ("student_name") String student_name){ 
		  
		  return studentResultsRepositry.findResultsByStudentName(student_name);
		  
	  }
	  
	  
	  
	  
	  
	  
	  
//		// FIND REULTS BY COURSE NAME
		
		  @GetMapping("/findResultsByCourseName") 
		  public List<StudentResults> retrieveResultsByCourseName(@RequestParam ("course_name") String course_name){ 
			  
			  return studentResultsRepositry.findResultsByCourseName(course_name);
			  
		  }
		  
		  
		  
		  
		  
		  
		  
//			// FIND REULTS BY MODULE NAME
			
		  @GetMapping("/findResultsByModuleName") 
		  public List<StudentResults> retrieveResultsByModuleName(@RequestParam ("module_name") String module_name){ 
			  
			  return studentResultsRepositry.findResultsByModuleName(module_name);
			  
		  }
		  
		  
		  
		  
		  
		  
//			// FIND REULTS BY STAFF NAME
			
		  @GetMapping("/findResultsByStaffName") 
		  public List<StudentResults> retrieveResultsByStaffName(@RequestParam ("staff_name") String staff_name){ 
			  
			  return studentResultsRepositry.findResultsByStaffName(staff_name);
			  
		  }
	
	
		  
		  
		  
		  
	
//	// FIND REULTS BY STUDENT ID
	
	  @GetMapping("/findResultsByStudentID") 
	  public List<StudentResults> findByName(@RequestParam ("student_id") String student_id){ 
		  
		  return studentResultsRepositry.findResultsByStudentID(student_id);
		  
	  }
	  

	  
	  
	  
	  
	  
	  
//	  //  COUNT ALL RESULTS
	
	  @GetMapping("/countResults")
	  public String countResults() {
		  
		  return studentResultsRepositry.countResults();
	  }

	  
	  
	  
	 
	  
	  
	  
	  
	  
//	// FIND STUDENT INFO FROM RESULTS TABLE
		
	  @GetMapping("/findAllStudentsUnderResults") 
	  public List<StudentResults> findAllStudentsUnderResults(@RequestParam ("module_id") Long module_id){ 
		  
		  return studentResultsRepositry.findAllStudentsUnderResults(module_id);
		  
	  }
	
	
	
	
	  


		 
	

}
