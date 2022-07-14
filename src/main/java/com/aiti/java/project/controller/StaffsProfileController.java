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

import com.aiti.java.project.entities.Staffs;
import com.aiti.java.project.repository.ModulesRepository;
import com.aiti.java.project.repository.StaffProfileRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/staffs")
public class StaffsProfileController {
	
	
	@Autowired
	SendingEmailService sendingEmailService;
	
	
	@Autowired
	StaffProfileRepository staffRepos;
	
	
	@Autowired
	ModulesRepository modulesRepository;
	
	
	

	
	
	
	
	
	
	
	
//	SENDING EMAILS TO INSTRUCTORS AFTER ASSIGNED TO A MODULE
	
	@GetMapping("/sendInstructorEmail") 
	public String sendInstructorEmail() {
		 
		 return sendingEmailService.sendEmail();
	 }
	
	



	
	
	
		  
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// USERS LOGIN
	
	  @GetMapping("/userLogin") 
	  public List<Staffs> userLoginRole(@RequestParam("email") String email, @RequestParam("password") String password){ 
		  
		  return staffRepos.userLoginRole(email, password);
		  
	  }
	  
	
	
	//  SAVE STAFF
	
	@PostMapping("/saveStaff")
	public Staffs saveStaff(@RequestBody Staffs staff) {
		return staffRepos.save(staff);
	}
	
	
	
	
	
	// UPDATE STAFF
	
	@PatchMapping("/updateStaff")
	public Staffs updateStaff(@RequestBody Staffs staff) {
		return staffRepos.save(staff);
	}
	
	
	
	// GET ALL STAFFS
	
	@GetMapping("/getAllStaffs")
	public List<Staffs> getAllStaffs(){
		return staffRepos.findAll();
	}
	
	
	
	
	
	// FIND STAFF BY ID
	
	@GetMapping("/findUsersById")
	public Staffs findUsersById(@RequestParam("id") int id) {
		
		return staffRepos.findById(id).get();
	}	
	
	
	
	
	//  DELETE STAFF
	
	@DeleteMapping("/deleteStaff")
	public void deleteStaff(@RequestParam ("id") int id) {
		staffRepos.deleteById(id);
	}
	
	
	


	
	
	
	// FIND STAFF BY NAME
	
	  @GetMapping("/findStaffByName") 
	  public List<Staffs> findByName(@RequestParam ("name") String name){ 
		  return staffRepos.findByName(name);
		  
	  }
	  
	  
	  
	  
	  
	  
	  
		
				
		
		
	  	// RETRIEVE ONLY STAFF NAME 				  	
	  	
	  //	@GetMapping("/retrieveStaffName")
	  //	public Staffs retrieveStaffName(@RequestParam("id") int id) {
	  		
	  		
	  	//	return staffRepos.retrieveStaffName(id);
	  		
	  	//}
		  
	  	
	  	
	  	
	  	
	  	
	  	
	  
	  
	//  RETRIEVAL OF THE LAST USERTYPE IN THE USERS TABLE
		@GetMapping("/getstaffUserTypeRetrival")
		public String getstaffUserTypeRetrival(String staffUserType) {
			
			
			return staffRepos.staffUserTypeRetrival(staffUserType);
			
		}
		
	
		
		
		
		// COUNT ALL STAFFS
	
	  @GetMapping("/countStaff")
	  public String countStaff() {
		  return staffRepos.countStaff();
	  }
	  
	  
	  
	  
	  
	  
		//  RETRIEVAL OF ONLY STAFF NAME FROM STAFF
	  
		@GetMapping("/getAllStaffNames")
		public List<Staffs> getAllStaffNames(){
			return staffRepos.findAll();
		}
	  
	  
	  
	  
	  
	  
		
	//  GET ONLY INTRUCTORS NAMES
		  
		@GetMapping("/getInstructors")
		public List<Staffs> getInstructorNames(){
			return staffRepos.getInstructorNames();
		}
	  
	  

		
		
		
		
		
	  
	  
}
