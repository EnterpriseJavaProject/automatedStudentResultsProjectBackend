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
@CrossOrigin(origins = "http://localhost:4200")
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
	 

	  
	  
	  
	  
	  
	  	  	
	  	
		// METHOD TO RETRIEVE ONLY STUDENT NAME AND STUDENT ID  ?id=1
	  	
	  	
	  	@GetMapping("/findStudentsUnderModule")
	  	public StudentProfile[] retrieveStudentsUnderModule(@RequestParam("id") Long id) {
	  		
			return studentRepos.retrieveStudentsUnderModule(id);
	  						  		
	  	}
	  	
	  	
	  	
	  	
	  	
//	  	@SuppressWarnings("unchecked")
//		@GetMapping("/retrieveStudentsUnderModule/{id}")
//	    public List<Object[]> find(@PathVariable("id") Long id) {
//	    	
//	        EntityManager entityManager = entityManagerFactory.createEntityManager();
//	        Query query = entityManager.createQuery("SELECT DISTINCT results.marks, students.id, students.name, students.student_id, students.course_id, students.date_of_birth, students.contact, students.gender,students.fees, students.email, students.status, students.created_at, students.updated_at FROM students inner JOIN results on students.student_id = results.student_id INNER JOIN modules ON students.course_id = modules.course_id where students.student_id = results.student_id and modules.id = ?  GROUP by students.student_id ORDER BY modules.id");
//	        query.setParameter("id", id);
//
//	        return query.getResultList();
//	        
//	    }
		
		
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	@GetMapping("/retrieveStudentsUnderModule/{id}")
	  	public StudentProfile[] findStudentsUnderModule(@PathVariable("id") Long id) {
	  		
			return studentRepos.retrieveStudentsUnderModule(id);
	  						  		
	  	}
		
}
