package com.aiti.java.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students_results")
public class StudentResults {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int batch_id;
	private String student_id;
	private String module_name;
	private String staff_name;
	private String marks;
	private String status;
	private String created_at;
	private String updated_at;
	
	
	
	
	public StudentResults() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StudentResults(Long id, String name, int batch_id, String student_id, String module_name, String staff_name,
			String marks, String status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.batch_id = batch_id;
		this.student_id = student_id;
		this.module_name = module_name;
		this.staff_name = staff_name;
		this.marks = marks;
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




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getBatch_id() {
		return batch_id;
	}




	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}




	public String getStudent_id() {
		return student_id;
	}




	public void setStudent_id(String student_id) {
		this.student_id = student_id;
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




	public String getMarks() {
		return marks;
	}




	public void setMarks(String marks) {
		this.marks = marks;
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
		return "StudentResults [id=" + id + ", name=" + name + ", batch_id=" + batch_id + ", student_id=" + student_id
				+ ", module_name=" + module_name + ", staff_name=" + staff_name + ", marks=" + marks + ", status="
				+ status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}




		
	
	
	
	

	
	
}
