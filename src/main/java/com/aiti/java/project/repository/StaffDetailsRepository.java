package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.StaffsDetails;

public interface StaffDetailsRepository extends JpaRepository<StaffsDetails, Integer> {
	
	



//  USERS LOGIN ROLE
	@Query(value="SELECT DISTINCT * from staff_details where staff_details.email = ? and staff_details.password = ? " , nativeQuery = true )
	List<StaffsDetails> userLoginRole(String email, String password);
	
	
	
	
	
	// FIND BY RESET PASSWORD TOKEN BY EMAIL

	@Query(value="SELECT  staff_details.reset_password_token from staff_details where staff_details.reset_password_token = ? GROUP by staff_details.reset_password_token ORDER by staff_details.reset_password_token", nativeQuery=true)
	public String findStaffByResetPasswordToken(String token);
	
	
	
	
	
	// FIND BY RESET PASSWORD TOKEN BY EMAIL

	@Query(value="SELECT DISTINCT * from staff_details where staff_details.reset_password_token = ? GROUP by staff_details.reset_password_token ORDER by staff_details.reset_password_token", nativeQuery=true)
	public StaffsDetails getStaffDetails(String token);
	
	
	

	// FIND BY EMAIL

	@Query(value="SELECT DISTINCT * from staff_details where staff_details.email = ?", nativeQuery=true)
	public StaffsDetails findByEmail(String email);
	

	
	
	
	
	
	
	
	
	
	
	// FIND BY VERIFICATION CODE
	
	@Query(value="select * from staff_details where staff_details.verification_code = ?", nativeQuery=true)
	public StaffsDetails findByVerificationCode(String verificationCode);

	
//	@Query(value="update staff_details set enable = true where staff_details.enable = ?", nativeQuery=true)
//	@Modifying
//	public void enable(int id);
	
	
	@Query(value="select * from staff_details where staff_details.reset_password_token = ?", nativeQuery=true)
	public StaffsDetails findByResetPasswordToken(String token);
	
	
	
	
	
	
	
	
	
	
	
	
	@Query(value="select usertype from users order by id desc limit 1;" , nativeQuery = true )
	String staffUserTypeRetrival(String staffUserType);
	
	

	// SELECTING ONLY EMAIL FORM STAFF AND SENDING THEM EMAIL NOTIFICATIONS
	@Query(value="SELECT staff_details.email FROM staff_details inner join modules on staff_details.batch_id = modules.batch_id and staff_details.name = modules.staff_name where staff_details.batch_id = modules.batch_id and staff_details.name = modules.staff_name GROUP by modules.updated_at order by modules.updated_at DESC limit 1" , nativeQuery = true )
	String selectingStaffEmailtoSendEmailNotification();
	
	
	

	
	
	
//  GET ALL STAFF INFO
	@Query(value="select * from staff_details order by id;" , nativeQuery = true )
	List<StaffsDetails> retrivalOfStaffName(StaffsDetails retrivalOfStaffName);
	
	
	
	
	//  GET ONLY INTRUCTORS NAMES
	@Query(value="SELECT DISTINCT * from staff_details where department = 'Faculty' or staff_details.department = 'Course Cordinator' or staff_details.department = 'Research and Innovation' order by name" , nativeQuery = true )
	List<StaffsDetails> getInstructorNames();
	
	
	
	
	
	
	@Query(value="select department from users order by id desc limit 1;" , nativeQuery = true )
	String staffdepartmentRetrival(String staffdepartment);
	
	
	
	
	List<StaffsDetails> findByName(String name);
	
	
	
	@Query(value="select count(*) from staff_details", nativeQuery=true)
	public String countStaff();
	

	
	
	// RETRIEVE ONLY STAFF NAME 
	
	@Query(value="select staff_details.name from staff_details where staff_details.batch_id = ?", nativeQuery=true)
	public StaffsDetails retrieveStaffName(int id);
	

	
	
	
	
	
	// FIND STAFF BY ID
	
	@Query(value="SELECT `id`, `name`, `staff_id`, `email`, `contact`, `department`, `course_id`, `status`, `created_at`, `updated_at` FROM `staff_details` WHERE staff_details.id = ?", nativeQuery=true)
	public List<Object> findStaffById(int id);
	
	
}
