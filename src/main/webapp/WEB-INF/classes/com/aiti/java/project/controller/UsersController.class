package com.aiti.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiti.java.project.entities.Users;
import com.aiti.java.project.repository.UsersRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersRepository usersRepo;
	
	
	
	@PostMapping("/saveUsers")
	public Users saveUsers(@RequestBody Users user) {
		return usersRepo.save(user);
	}
	
	@PatchMapping("/updateUsers")
	public Users updateUsers(@RequestBody Users user) {
		
		return usersRepo.save(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers(){
		return usersRepo.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUsers(@PathVariable ("id") Long id) {
		usersRepo.deleteById(id);
	}
	

	
	
	@GetMapping("/findUsersById/{id}")
	public Users findUsersById(@PathVariable("id") Long id) {
		return usersRepo.findById(id).get();
	}
	
	
	
	
	  @GetMapping("/countUsers")
	  public String countUsers() {
		  return usersRepo.countUsers();
	  }
	  
	  
	

}
