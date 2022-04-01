package com.aiti.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Staffs;

public interface StaffProfileRepository extends JpaRepository<Staffs, Integer> {
	
//  USERS LOGIN ROLE
	@Query(value="SELECT DISTINCT staffs.id, staffs.name, staffs.staff_id, staffs.email, staffs.contact, staffs.usertype, staffs.course_id, staffs.status, staffs.created_at, staffs.updated_at from staffs INNER join users on staffs.staff_id = users.staff_id and staffs.email = users.email and staffs.usertype = users.usertype where staffs.staff_id = users.staff_id and staffs.email = users.email and staffs.usertype = users.usertype and staffs.email = ? and users.password = ? GROUP by staffs.email ORDER by staffs.name" , nativeQuery = true )
	List<Staffs> userLoginRole(String email, String password);
	
	
	
	
//  GET ALL STAFF INFO
	@Query(value="select id,staff_id,name,email,contact,usertype,course_id,status,created_at,updated_at from staffs order by id;" , nativeQuery = true )
	List<Staffs> retrivalOfStaffName(Staffs retrivalOfStaffName);
	
	
	
	
	//  GET ONLY INTRUCTORS NAMES
	@Query(value="select id,staff_id,name,email,contact,usertype,course_id,status,created_at,updated_at from staffs where usertype = 'Instructor' order by name;" , nativeQuery = true )
	List<Staffs> getInstructorNames();
	
	
	
	
	
	
	@Query(value="select usertype from users order by id desc limit 1;" , nativeQuery = true )
	String staffUserTypeRetrival(String staffUserType);
	
	
	
	
	List<Staffs> findByName(String name);
	
	
	
	@Query(value="select count(*) from staffs", nativeQuery=true)
	public String countStaff();
	
	
	
	
	
	
	
	
	
	
	// RETRIEVE ONLY STAFF NAME 
	
	@Query(value="select staffs.name from staffs where staffs.course_id = ?", nativeQuery=true)
	public Staffs retrieveStaffName(int id);
	
}
