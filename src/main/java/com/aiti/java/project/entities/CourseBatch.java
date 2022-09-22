package com.aiti.java.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_batch")
public class CourseBatch {
	
	
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int course_id;
	private String course_name;
	private String course_level;
	private String coordinator;
	private String course_start_date;
	private String course_end_date;
	private String certificate_issuedate;
	private String status;
	private String created_at;
	private String updated_at;
	
	
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
//	private List<Modules> modules = new ArrayList<Modules>();
	
	
	
	
	public CourseBatch() {
		
	}



	public CourseBatch(Long id, int course_id, String course_name, String course_level, String coordinator,
			String course_start_date, String course_end_date, String certificate_issuedate, String status,
			String created_at, String updated_at) {
		super();
		this.id = id;
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_level = course_level;
		this.coordinator = coordinator;
		this.course_start_date = course_start_date;
		this.course_end_date = course_end_date;
		this.certificate_issuedate = certificate_issuedate;
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



	public int getCourse_id() {
		return course_id;
	}



	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}



	public String getCourse_name() {
		return course_name;
	}



	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}



	public String getCourse_level() {
		return course_level;
	}



	public void setCourse_level(String course_level) {
		this.course_level = course_level;
	}



	public String getCoordinator() {
		return coordinator;
	}



	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}



	public String getCourse_start_date() {
		return course_start_date;
	}



	public void setCourse_start_date(String course_start_date) {
		this.course_start_date = course_start_date;
	}



	public String getCourse_end_date() {
		return course_end_date;
	}



	public void setCourse_end_date(String course_end_date) {
		this.course_end_date = course_end_date;
	}



	public String getCertificate_issuedate() {
		return certificate_issuedate;
	}



	public void setCertificate_issuedate(String certificate_issuedate) {
		this.certificate_issuedate = certificate_issuedate;
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
		return "CourseBatch [id=" + id + ", course_id=" + course_id + ", course_name=" + course_name + ", course_level="
				+ course_level + ", coordinator=" + coordinator + ", course_start_date=" + course_start_date
				+ ", course_end_date=" + course_end_date + ", certificate_issuedate=" + certificate_issuedate
				+ ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}



	
	
	
	
	
	
	
	

}