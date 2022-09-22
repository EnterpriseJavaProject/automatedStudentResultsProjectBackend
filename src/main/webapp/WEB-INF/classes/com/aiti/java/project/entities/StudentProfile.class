package com.aiti.java.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="students")
public class StudentProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String student_id;
//	@Column(name="full_name")
	private String name;
	private String date_of_birth;
	private String contact;
	private String email;
	private String gender;
	private int course_id;
	private String status;
	private String created_at;
	private String updated_at;
	


	
	public StudentProfile() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StudentProfile(Long id, String student_id, String name, String date_of_birth, String contact, String email,
			String gender, int course_id, String status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.course_id = course_id;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getStudent_id() {
		return student_id;
	}




	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDate_of_birth() {
		return date_of_birth;
	}




	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}




	public String getContact() {
		return contact;
	}




	public void setContact(String contact) {
		this.contact = contact;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public int getCourse_id() {
		return course_id;
	}




	public void setCourse_id(int course_id) {
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
		return "StudentProfile [id=" + id + ", student_id=" + student_id + ", name=" + name + ", date_of_birth="
				+ date_of_birth + ", contact=" + contact + ", email=" + email + ", gender=" + gender + ", course_id="
				+ course_id + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}




	


	
	
	
	
	}
