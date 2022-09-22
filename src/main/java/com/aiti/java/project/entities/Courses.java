package com.aiti.java.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	
	
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String course_name;
	private String status;
	private String created_at;
	private String updated_at;
	
	
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
//	private List<Modules> modules = new ArrayList<Modules>();
	
	
	
	
	public Courses() {
		
	}



	public Courses(Long id, String course_name, String status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.course_name = course_name;
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
		return "Courses [id=" + id + ", course_name=" + course_name + ", status=" + status + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}



	
	

	
	
	
	

}