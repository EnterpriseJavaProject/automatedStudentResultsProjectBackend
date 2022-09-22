package com.aiti.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aiti.java.project.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	
	
	
	@Query(value="select count(*) from users", nativeQuery=true)
	public String countUsers();
	
	
}
