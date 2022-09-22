package com.aiti.java.project.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="staff_details")
public class StaffsDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String staff_id;
	private String name;
	private String email;
	private String contact;
	private String department;
	private String password;
	private String reset_password_token;
	private int batch_id;
	private String status;
	private String created_at;
	private String updated_at;
	

	
	
	
	
	public StaffsDetails() {
		
		// TODO Auto-generated constructor stub
	}






	public StaffsDetails(int id, String staff_id, String name, String email, String contact, String department,
			String password, String reset_password_token, int batch_id, String status, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.staff_id = staff_id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.department = department;
		this.password = password;
		this.reset_password_token = reset_password_token;
		this.batch_id = batch_id;
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






	public String getDepartment() {
		return department;
	}






	public void setDepartment(String department) {
		this.department = department;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getReset_password_token() {
		return reset_password_token;
	}






	public void setReset_password_token(String reset_password_token) {
		this.reset_password_token = reset_password_token;
	}






	public int getBatch_id() {
		return batch_id;
	}






	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
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
		return "StaffsDetails [id=" + id + ", staff_id=" + staff_id + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", department=" + department + ", password=" + password
				+ ", reset_password_token=" + reset_password_token + ", batch_id=" + batch_id + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}






	

	
	
	

	

}
