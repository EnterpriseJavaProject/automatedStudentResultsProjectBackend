package com.aiti.java.project.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("0")
@Table(name="modules")
public class Modules {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String course_name;
	private String module_name;
	private String staff_name;
	private String course_id;
	private String status;
	private String created_at;
	private String updated_at;
//	private String count;
	
	
	
	
//	@ManyToOne
//	private Courses course;
	
	
	
	
	
	
	public Modules() {

	}




	


	
	
	
	
	
	
	public Modules(Long id, String course_name, String module_name, String staff_name, String course_id, String status,
			String created_at, String updated_at) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.module_name = module_name;
		this.staff_name = staff_name;
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













	public String getCourse_name() {
		return course_name;
	}













	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}













	public String getModule_name() {
		return module_name;
	}













	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}













	public String getStaff_name() {
		return staff_name;
	}













	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}













	public String getCourse_id() {
		return course_id;
	}













	public void setCourse_id(String course_id) {
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
		return "Modules [id=" + id + ", course_name=" + course_name + ", module_name=" + module_name + ", staff_name="
				+ staff_name + ", course_id=" + course_id + ", status=" + status + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}











	public String toString1() {
		return "[course_name=" + course_name + ", module_name=" + module_name + ", staff_name="
				+ staff_name + "]";
	}

	
	
	
	
	

}