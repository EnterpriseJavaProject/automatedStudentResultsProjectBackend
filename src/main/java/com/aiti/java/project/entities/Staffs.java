package com.aiti.java.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="staffs")
public class Staffs {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String staff_id;
	private String name;
	private String email;
	private String contact;
	private String usertype;
	private Long course_id;
	private String status;
	private String created_at;
	private String updated_at;
	
	
	
	
	
	
	public Staffs() {
		
		// TODO Auto-generated constructor stub
	}






	public Staffs(int id, String staff_id, String name, String email, String contact, String usertype, Long course_id,
			String status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.staff_id = staff_id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.usertype = usertype;
		this.course_id = course_id;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getStaff_id() {
		return staff_id;
	}






	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getContact() {
		return contact;
	}






	public void setContact(String contact) {
		this.contact = contact;
	}






	public String getUsertype() {
		return usertype;
	}






	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}






	public Long getCourse_id() {
		return course_id;
	}






	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}






	public String getStatus() {
		return status;
	}






	public void setStatus(String status) {
		this.status = status;
	}






	public String getCreated_at() {
		return created_at;
	}






	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}






	public String getUpdated_at() {
		return updated_at;
	}






	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}






	@Override
	public String toString() {
		return "Staffs [id=" + id + ", staff_id=" + staff_id + ", name=" + name + ", email=" + email + ", contact="
				+ contact + ", usertype=" + usertype + ", course_id=" + course_id + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}







	
	


}
