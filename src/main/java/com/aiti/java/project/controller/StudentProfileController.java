package com.aiti.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiti.java.project.entities.StudentProfile;
import com.aiti.java.project.repository.StudentProfileRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentProfileController {
	
	

	
	@Autowired
	StudentProfileRepository studentRepos;
	
	
	

    //private EntityManagerFactory entityManagerFactory;

	
	
	
	
	
	
	
	
	//  SAVE STUDENT
	
	@PostMapping("/saveStudent")
	public StudentProfile saveStudent(@RequestBody StudentProfile student) {
		return studentRepos.save(student);
	}
	
	
	
	
	//  UPDATE STUDENT
	
	@PatchMapping("/updateStudent")
	public StudentProfile updateStudent(@RequestBody StudentProfile student) {
		return studentRepos.save(student);
	}
	
	
	
	
	
	//  GET ALL STUDENTS
	
	@GetMapping("/getAllStudent")
	public List<StudentProfile> getAllStudent(){
		return studentRepos.findAll();
	}
	
	
	
	//  DELETE STUDENT
	
	@DeleteMapping("/delete")
	public void deleteStudent(@RequestParam ("id") Long id) {
		studentRepos.deleteById(id);
	}
	
	
	
	
	//  FIND STUDENT BY ID
	
	@GetMapping("/findStudentById")
	public StudentProfile findById(@RequestParam ("id") Long id) {
		 return studentRepos.findById(id).get();
	}
	
	
	
	
	
	//  FIND STUDENT BY NAME
	
	  @GetMapping("/findStudentByName") 
	  public List<StudentProfile> findByName(@RequestParam ("name") String name){ 
		  return studentRepos.findByName(name);
		  
	  }
	  
	  
	  

	  
	  //  COUNT ALL STUDENTS
	  
	  @GetMapping("/countStudent")
	  public String countStudent() {
		  return studentRepos.countStudent();
	  }
	 

	  
	  //  COUNT ALL MALE STUDENTS
	  
	  @GetMapping("/countAllMaleStudent")
	  public String countAllMaleStudent() {
		  return studentRepos.countAllMaleStudent();
	  }
	  
	  
	  
	  
	  
	  //  COUNT ALL FEMALE STUDENTS
	  
	  @GetMapping("/countAllFemaleStudent")
	  public String countAllFemaleStudent() {
		  return studentRepos.countAllFemaleStudent();
	  }
	  
	  
	  
	  	  	
	  	
		// METHOD TO RETRIEVE ONLY STUDENT NAME AND STUDENT ID  ?id=1
	  	
	  	
	  	@GetMapping("/findStudentsUnderModule")
	  	public StudentProfile[] retrieveStudentsUnderModule(@RequestParam("id") Long id) {
	  		
			return studentRepos.retrieveStudentsUnderModule(id);
	  						  		
	  	}
	  	
	  	
	  	
	  	
	  
		
		
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	
	  	
	  	
	  	
	  	
	  	
	  	@GetMapping("/retrieveStudentsUnderModule/{id}")
	  	public StudentProfile[] findStudentsUnderModule(@PathVariable("id") Long id) {
	  		
			return studentRepos.retrieveStudentsUnderModule(id);
	  						  		
	  	}
		
}
