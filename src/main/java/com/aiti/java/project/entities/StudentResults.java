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
	private String studentname;
	private String coursename;
	private String studentid;
	private String modulename;
	private String staffname;
	private String marks;
	private String status;
	private String created_at;
	private String updated_at;
	
	
	
	
	public StudentResults() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StudentResults(Long id, String studentname, String coursename, String studentid, String modulename,
			String staffname, String marks, String status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.coursename = coursename;
		this.studentid = studentid;
		this.modulename = modulename;
		this.staffname = staffname;
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




	public String getStudentname() {
		return studentname;
	}




	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}




	public String getCoursename() {
		return coursename;
	}




	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}




	public String getStudentid() {
		return studentid;
	}




	public void setStudentid(String studentid) {
		this.studentid = studentid;
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
		return "StudentResults [id=" + id + ", studentname=" + studentname + ", coursename=" + coursename
				+ ", studentid=" + studentid + ", modulename=" + modulename + ", staffname=" + staffname + ", marks="
				+ marks + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}




	
	
	
	
	
	
	
	
	
	

}
