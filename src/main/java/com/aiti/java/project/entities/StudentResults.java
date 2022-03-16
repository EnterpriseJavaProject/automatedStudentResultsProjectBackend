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
	private String course_id;
	private String student_id;
	private String modulename;
	private String staffname;
	private String marks;
	private int module_id;
	private String status;
	private String created_at;
	private String updated_at;
	
	
	
	
	public StudentResults() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StudentResults(Long id, String name, String course_id, String student_id, String modulename,
			String staffname, String marks, int module_id, String status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.course_id = course_id;
		this.student_id = student_id;
		this.modulename = modulename;
		this.staffname = staffname;
		this.marks = marks;
		this.module_id = module_id;
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




	public String getCourse_id() {
		return course_id;
	}




	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}




	public String getStudent_id() {
		return student_id;
	}




	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}




	public String getModulename() {
		return modulename;
	}




	public void setModulename(String modulename) {
		this.modulename = modulename;
	}




	public String getStaffname() {
		return staffname;
	}




	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}




	public String getMarks() {
		return marks;
	}




	public void setMarks(String marks) {
		this.marks = marks;
	}




	public int getModule_id() {
		return module_id;
	}




	public void setModule_id(int module_id) {
		this.module_id = module_id;
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
		return "StudentResults [id=" + id + ", name=" + name + ", course_id=" + course_id + ", student_id=" + student_id
				+ ", modulename=" + modulename + ", staffname=" + staffname + ", marks=" + marks + ", module_id="
				+ module_id + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}




	

	
	
}
