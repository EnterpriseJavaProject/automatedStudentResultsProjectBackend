package com.aiti.java.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.aiti.java.project.repository.ModulesRepository;
import com.aiti.java.project.repository.StaffProfileRepository;
import com.aiti.java.project.repository.StudentProfileRepository;

@Service
public class SendingEmailService {
	
	
	
	@Autowired
	StaffProfileRepository staffRepos;
	
	
	@Autowired
	ModulesRepository modulesRepository;
	
	
	@Autowired
	StudentProfileRepository studentProfileRepository;
	
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	
	
	
	
	
	
	// SENDING STUDENTS EMAIL AFTER RESULTS BEEN UPLOADED
	
	public String sendingStudentEmailAfterRestultsBeenUploaded() {
		
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
        msg.setFrom("bismarkotu1006@gmail.com");

        msg.setTo(studentProfileRepository.sendingStudentEmailAfterRestultsBeenUploaded());
        

         
        
        
        msg.setSubject("Your" + " " + studentProfileRepository.sendingStudentCourseNameEmailAfterRestultsBeenUploaded() + " (" + studentProfileRepository.sendingStudentModuleNameEmailAfterRestultsBeenUploaded() + ") Results is been uploaded");

        //msg.setText("Please take note of the following for commencement of");
        msg.setText("Your" + " " + studentProfileRepository.sendingStudentCourseNameEmailAfterRestultsBeenUploaded() + " (" + studentProfileRepository.sendingStudentModuleNameEmailAfterRestultsBeenUploaded() + ") Results is been uploaded. Login http://dev-1.aiti-kace.com.gh:9060/login to check your results");
        
        
        javaMailSender.send(msg);
        

        System.out.println("Email sent successfully......");


		return null;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// SENDING STUDENTS WELCOME EMAIL AFTER BEING ADMTITTED
	
	public String sendingStudentsWelcomeEmailAfterBeingAdmitted() {
		
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
        msg.setFrom("bismarkotu1006@gmail.com");

        msg.setTo(studentProfileRepository.sendingStudentsWelcomeEmailAfterBeingAdmitted());
        //msg.setCc("obwebsitedesign@gmail.com", "bismarkotu1995@gmail.com");

        
        
        msg.setSubject("Commencement & Admission Requirement for" + " " + studentProfileRepository.selectingOnlyCourseNameAsStudentEmailSubject() + " (" + studentProfileRepository.selectingOnlyCourseLevelAsStudentEmailSubject() + ") ");

        //msg.setText("Please take note of the following for commencement of");
        msg.setText("Please take note of the following for commencement of " + " " + studentProfileRepository.selectingOnlyCourseNameAsStudentEmailSubject() + " (" + studentProfileRepository.selectingOnlyCourseLevelAsStudentEmailSubject() + ") "
        		+ "\n" +
        		"\nCommencement of Lectures: " + " " + studentProfileRepository.selectingOnlyCourseStartDateAsStudentEmailSubject()
        		+ "\n" +
        		"End of Semester 1: " + " " + studentProfileRepository.selectingOnlyCourseEndDateAsStudentEmailSubject()
        		+ "\n" +
        		"Lecture Days: Monday- Friday"
        		+ "\n" +
        		"Lecture Time: 8:00am - 5:00pm"
        		+ "\n" +
        		"Coordinator: " + " " + studentProfileRepository.selectingOnlyCoordinatorAsStudentEmailSubject()
        		+ "\n" +
        		"\nRequired:"
        		+ "\n" +
        		"1. Register on AITI-KACE website: www.aiti-kace.com.gh"
        		+ "\n" +
        		"2. One passport size photograph"
        		+ "\n" +
        		"3. Payment of full Course Fee + Registration Fee before lectures begin"
        		+ "\n" +
        		"4. Ensure that you are issued with a Student ID Number, this will be your only identity whenever you are dealing with the Centre"
        		+ "\n" +
        		"5. Ensure that you are issued with a Student ID Card"
        		+ "\n" +
        		"6. Ensure you have completed a copy of rules & regulations and submit same to the academic office"
        		+ "\n" +
        		"\nBest Regards!"
        		);
        
        
        javaMailSender.send(msg);
        

        System.out.println("Email sent successfully......");


		return null;
	
	}
	
	

	
	
	// SENDING EMAILS TO INSTRUCTORS
	
	public String sendEmail() {
		
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
        msg.setFrom("bismarkotu1006@gmail.com");

        msg.setTo(staffRepos.selectingStaffEmailtoSendEmailNotification());
        //msg.setCc("obwebsitedesign@gmail.com", "bismarkotu1995@gmail.com");

        
        
        msg.setSubject("YOU HAVE BEEN ASSIGNED TO HANDLE THE COURSE AND MODULE BELOW");

        
        msg.setText(
        		 
        		" YOU HAVE BEEN ASSIGNED TO HANDLE: \n\n " 
        		+ "COURSE NAME: " + " " + modulesRepository.selectingCourseNametoSendEmailNotification()
        		+ "\n " 
        		+ "MODULE NAME: " + " " + modulesRepository.selectingModuleNametoSendEmailNotification()
        		+ "\n "
        		+ "MODULE START DATE: " + " " + modulesRepository.selectingModuleStartDatetoSendEmailNotification()
        		+ "\n " 
        		+ "MODULE END DATE: " + " " + modulesRepository.selectingModuleEndDatetoSendEmailNotification() 
        		+ "\n\n " 
        		+ "Login  http://dev-1.aiti-kace.com.gh:9060");
        
        
        
        
        
        
        javaMailSender.send(msg);
        

        System.out.println("Email sent successfully.......");


		return null;
	
	}
	
	
	
}
