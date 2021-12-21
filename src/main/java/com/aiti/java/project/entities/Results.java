package com.aiti.java.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="results")
public class Results {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long course_id;
	private Long module_id;
	private String student_id;
	private String staff_id;
	private Long marks;
	private String status;
	private String created_at;
	private String updated_at;
	
	
	public Results() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Results(Long id, Long course_id, Long module_id, String student_id, String staff_id, Long marks,
			String status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.course_id = course_id;
		this.module_id = module_id;
		this.student_id = student_id;
		this.staff_id = staff_id;
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


	public Long getCourse_id() {
		return course_id;
	}


	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}


	public Long getModule_id() {
		return module_id;
	}


	public void setModule_id(Long module_id) {
		this.module_id = module_id;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}


	public Long getMarks() {
		return marks;
	}


	public void setMarks(Long marks) {
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
		return "Results [id=" + id + ", course_id=" + course_id + ", module_id=" + module_id + ", student_id="
				+ student_id + ", staff_id=" + staff_id + ", marks=" + marks + ", status=" + status + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}


	
}
