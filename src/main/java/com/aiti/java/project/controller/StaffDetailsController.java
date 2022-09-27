package com.aiti.java.project.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiti.java.project.entities.StaffsDetails;
import com.aiti.java.project.repository.ModulesRepository;
import com.aiti.java.project.repository.StaffDetailsRepository;



@Service
@Transactional
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/staffs")
public class StaffDetailsController {
	
	
	@Autowired
	SendingEmailService sendingEmailService;
	
	
	@Autowired
	StaffDetailsRepository staffDetailsRepository;
	
	
	@Autowired
	ModulesRepository modulesRepository;
	
	@Autowired
    private JavaMailSender mailSender;
	
	
	
	

	
	
	
	// SEND RESET PASSWORD LINK TO STAFF EMAIL
	
	@GetMapping("/sendResetPasswordLinkToStaffEmail")
	public String sendResetPasswordLinkToStaffEmail(@RequestParam("email") String email) throws Exception {

		StaffsDetails staff = staffDetailsRepository.findByEmail(email);
		String token = RandomStringUtils.random(45, true, true);
		
		staff.setReset_password_token(token);

					
		String resetPasswordLink = "http://localhost:8081/Frontend_API/aitiKaceModulesCoursesApiConsumption/reset_password?token=" + token;
		
		//String resetPasswordLink = "http://localhost:4200/reset_password?token=" + token;

		
		//sendingResetPasswordTokenLinkToStaffEmail(email, resetPasswordLink);
					
		//System.out.println(resetPasswordLink);
		
		 return  resetPasswordLink;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	//  GET STAFF DETAILS BY STAFF RESET PASSWORD
	
	@GetMapping("/getStaffDetails")
	public StaffsDetails getStaffDetails(@RequestParam("token") String token) throws Exception {

		StaffsDetails staff = staffDetailsRepository.getStaffDetails(token);

		 return staff;
	}
	
	
	
	


	
		
		
		


		
		
		

	
		
		
		// UPDATE STAFF DETAILS AFTER RESET PASSWORD
		
		@PutMapping("/updateStaffDetailsAfterResetPassword")
		public void updateStaffDetailsAfterResetPassword(@RequestBody StaffsDetails staff) {
			
			staffDetailsRepository.save(staff);
			//sendingEmailService.sendEmailToInstructorsAfterBeenAssignedAsACourseCoordinator(staff);
			//sendingEmailService.sendEmailToInstructorsAfterBeenAssignedToAModule(staff);
			//sendingEmailService.sendEmailToInstructorsAfterBeenAssignedToAModule(staff);
		}
		
		
	
	
	
	
	

	
	
	
		// UPDATE STAFF 
		
		@PatchMapping("/updateStaff")
		public void updateStaf(@RequestBody StaffsDetails staff) {
			
			staffDetailsRepository.save(staff);

		}
	
	
	
	

	
	  
	  
	  
	  
	  // FIND BY RESET PASSWORD TOKEN
	  
	  @GetMapping("/findByResetPasswordToken")
	  public StaffsDetails findByResetPasswordToken(String token) {
		  
		  return staffDetailsRepository.findByResetPasswordToken(token);
	  }
	  
	  
	  
	  
	  
	  

	  
	  

	  
	  
	  
	  

	
	
	
	
	
	
	
//	// USERS LOGIN
	
	  @GetMapping("/userLogin") 
	  public List<StaffsDetails> userLoginRole(@RequestParam("email") String email, @RequestParam("password") String password){ 
		  
		  return staffDetailsRepository.userLoginRole(email, password);
		  
	  }
	
	
	
	  
	  
	  
	  
	  
	  
	  
	
	

	



//	// GET ALL STAFFS
	
	@GetMapping("/getAllStaffs")
	public List<StaffsDetails> getAllStaffs(){
		return staffDetailsRepository.findAll();
	}
	
	
		  
		
	
	
	
	

//	// FIND STAFF BY ID
	
	@GetMapping("/findUsersById")
	public StaffsDetails findUsersById(@RequestParam("id") int id) {
		
		return staffDetailsRepository.findById(id).get();
	}	
	
	
	
	
//	//  DELETE STAFF
	
	@DeleteMapping("/deleteStaff")
	public void deleteStaff(@RequestParam ("id") int id) {
		staffDetailsRepository.deleteById(id);
	}
	
	
	



	  
	  
	
	
//	// FIND STAFF BY NAME
	
	  @GetMapping("/findStaffByName") 
	  public List<StaffsDetails> findByName(@RequestParam ("name") String name){ 
		  return staffDetailsRepository.findByName(name);
		  
	  }
	  
	  
	  
	  
	  
	  
	  
		
				
		
		
//	  	// RETRIEVE ONLY STAFF NAME 				  	
	  	
	  	@GetMapping("/retrieveStaffName")
	  	public StaffsDetails retrieveStaffName(@RequestParam("id") int id) {
	  		
	  		
	  		return staffDetailsRepository.retrieveStaffName(id);
	  		
	  	}
		  
	  	
	  	
	  	
	  	
	  	
	  	
	  
	  
//	//  RETRIEVAL OF THE LAST USERTYPE IN THE USERS TABLE
		@GetMapping("/getstaffUserTypeRetrival")
		public String getstaffUserTypeRetrival(String staffUserType) {
			
			
			return staffDetailsRepository.staffUserTypeRetrival(staffUserType);
			
		}
		
	
		
		
		
		// COUNT ALL STAFFS
	
	  @GetMapping("/countStaff")
	  public String countStaff() {
		  return staffDetailsRepository.countStaff();
	  }

	
	
	
	
	
	
	
//		//  RETRIEVAL OF ONLY STAFF NAME FROM STAFF
	  
		@GetMapping("/getAllStaffNames")
		public List<StaffsDetails> getAllStaffNames(){
			return staffDetailsRepository.findAll();
		}
	  
	  
	  
	  
	  
	  
		
	//  GET ONLY INTRUCTORS NAMES
		  
		@GetMapping("/getInstructors")
		public List<StaffsDetails> getInstructorNames(){
			
			return staffDetailsRepository.getInstructorNames();
		}
	  
	
	
	
	
	
	
		
		// SENDING RESET PASSWORD TOKEN LINK TO STAFF EMAIL
		
		public void sendingResetPasswordTokenLinkToStaffEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			helper.setFrom("bismarkotu1006@gmail.com", "GHANA-INDIA KOFI ANNAN CENTRE OF EXCELLENCE IN ICT");
			helper.setTo(email);
			
			String subject = "Here's the link to set your password";
			
			String content = "<p>Hello,</p>"
					+ "<p>You have requested to reset your password.</p>"
					+ "<p>Click the link below to reset your password:</p>"
					+ "<p><b><a href=\"" + resetPasswordLink + "\">Reset my password</a><b></p>"
					+ "<p>Ignore this email if you have not requested to reset your password</p>";
			
			helper.setSubject(subject);
			helper.setText(content, true);
			
			mailSender.send(message);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	  
}
