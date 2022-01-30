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

import com.aiti.java.project.entities.Results;
import com.aiti.java.project.repository.ResultsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/results")
public class ResultsController {
	
	@Autowired
	ResultsRepository resultsRepos;
	
	
	
	
	
	
	
	
	
		//  SAVE ALL RESULTS
	
	@PostMapping("/saveAllResults")
	public void saveAllResults(@RequestBody List<Results> results) {
		
		resultsRepos.saveAll(results);
			
	}
	
	
	
	
	
	// SAVE A SINGLE RESULTS
	
	@PostMapping("/saveResults")
	public Results saveResults(@RequestBody Results results) {
		
	  return resultsRepos.save(results);
			
	}
	
	
	
	
	// UPDATE RESULTS
	
	@PatchMapping("updateResults")
	public Results updateResults(@RequestBody Results results) {
		return resultsRepos.save(results);
	}
	
	
	
	@GetMapping("/getAllResults")
	public Iterable<Results> getAllResults(){
		return resultsRepos.findAll();
	}
	
	
	
	
	//  DELETE RESULTS
	@DeleteMapping("/delete/{id}")
	public void deleteResults(@PathVariable ("id") Long id) {
		resultsRepos.deleteById(id);
	}
	
	
	
	
	// FIND RESULTS BY ID
	
	@GetMapping("/findResultsById/{id}")
	public Results findById(@PathVariable("id") Long id) {
		return resultsRepos.findById(id).get();
	}
	
	
	
	
	
	// FIND REULTS BY STUDENT ID
	
	  @GetMapping("/findResultsByStudentID/{name}") 
	  public List<Results> findByName(@PathVariable ("name") String student_id){ 
		  return resultsRepos.findResultsByStudentID(student_id);
		  
	  }
	  
	  
	  
	  
	  //  COUNT ALL RESULTS
	
	  @GetMapping("/countResults")
	  public String countResults() {
		  return resultsRepos.countResults();
	  }
	  
	
	
	
	
	
}
