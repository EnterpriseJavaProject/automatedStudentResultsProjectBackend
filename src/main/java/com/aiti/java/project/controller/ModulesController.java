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

import com.aiti.java.project.entities.Modules;
import com.aiti.java.project.repository.ModulesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/modules")
public class ModulesController {
	
	
	Modules modules = new Modules();
	
	

	  
  
	  

	
	
	@Autowired
	ModulesRepository modulesRepo;
	
	
	
	
	@PostMapping("/saveModules")
	public Modules saveModules(@RequestBody Modules module) {
		return modulesRepo.save(module);
	}
	
	
	
	
	@PatchMapping("/updateModules")
	public Modules updateModules(@RequestBody Modules module) {
		
		return modulesRepo.save(module);
	}
	
	
	
	
	@GetMapping("/getAllModules")
	public List<Modules> getAllModules(){
		return modulesRepo.findAll();
	}
	
	
	
	
	@DeleteMapping("/deleteModulesById/{id}")
	public void deleteModules(@PathVariable ("id") Long id) {
		modulesRepo.deleteById(id);
	}
	
	
	
	
	@GetMapping("/findModulesById/{id}")
	public Modules findById(@PathVariable("id") Long id) {
		return modulesRepo.findById(id).get();
	}
	
	
	
	
	
	  @GetMapping("/countModule")
	  public String countModule() {
		  
		  return modulesRepo.countModule();
	  }
	
	
	  
	  
	  
		
		
		
		
		
		
		//	// METHOD TO RETRIEVE ALL COURSE NAME UNDER MODULE TABLE
		
		@GetMapping("/getCourseNameAndCourseLevel")
		public List<Modules> getCourseNameAndCourseLevel(){
			return modulesRepo.getCourseNameAndCourseLevel();
		}
	
	
			
				
				
	
				
				
				  
				  
				//   RETRIEVAL OF ALL MODULES UNDER EACH COURSE
			  @GetMapping("/findModulesUnderEachCourseById/{id}")
			  public List<Modules> findModulesUnderEachCourseById(@PathVariable("id") Long id) {
				  
				  return modulesRepo.findModulesUnderEachCourseById(id);
				  
			  }



			  
			  
			  
			  
			  
			  


				//RETRIEVE THE TOTAL NUMBER OF MODULES UNDER EACH COURSE
				  	  @GetMapping("/totalNumberOfModulesUnderEachCourse/{id}")
				  public List<Modules> findTotalNumberOfModulesUnderEachCourseById(@PathVariable("id") int id) {
					  
					  return modulesRepo.findTotalNumberOfModulesUnderEachCourseById(id);
				  }





			//  RETRIEVAL OF ALL STUDENTS UNDER EACH MODULES
				  	  @GetMapping("/retrievalOfStudentsUnderEachModule/{id}")
				  public List<String> retrievalOfStudentsUnderEachModuleById(@PathVariable("id") int id) {
					  
					  return modulesRepo.retrievalOfStudentsUnderEachModuleById(id);
				  }




			//  RETRIEVE THE TOTAL NUMBER OF STUDENTS UNDER EACH MODULE
				  	  @GetMapping("/totalNumberOfStudentsUnderEachModule/{id}")
				  public List<String> findTotalNumberOfStudentsUnderEachModuleById(@PathVariable("id") int id) {
					  
					  return modulesRepo.findTotalNumberOfStudentsUnderEachModuleById(id);
				  }
			
				
				
		

}
