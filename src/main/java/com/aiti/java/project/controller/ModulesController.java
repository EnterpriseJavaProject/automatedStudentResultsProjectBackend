package com.aiti.java.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	
	
	
	

// SAVE MODULE
	
	@PostMapping("/saveModules")
	public Modules saveModules(@RequestBody Modules module) {
		return modulesRepo.save(module);
	}
	
	
	
	
	// UPDATE MODULE
	
	@PatchMapping("/updateModules")
	public Modules updateModules(@RequestBody Modules module) {
		
		return modulesRepo.save(module);
	}
	
	
	
	 
	// GET ALL MODULES
	
	@GetMapping("/getAllModules")
	public List<Modules> getAllModules(){
		return modulesRepo.findAll();
	}
	
	
	
	
	
	//  DELETE MODULE
	
	@DeleteMapping("/deleteModulesById")
	public void deleteModules(@RequestParam ("id") Long id) {
		modulesRepo.deleteById(id);
	}
	
	
	
	// FIND MODULES BY ID
	
	@GetMapping("/findModulesById")
	public Modules findById(@RequestParam("id") Long id) {
		return modulesRepo.findById(id).get();
	}
	
	
	
	
	
	// FIND MODULE BY NAME
	
	  @GetMapping("/findModuleByModuleName") 
	  public List<Modules> findByName(@RequestParam ("modules_name") String modules_name){ 
		  return modulesRepo.findModuleByModuleName(modules_name);
		  
	  }
	  
	  
	  
	  
	  
	  
		// FIND MODULE BY NAME
		
	  @GetMapping("/findModuleByCourseName") 
	  public List<Modules> findByCourseName(@RequestParam ("course_name") String course_name){ 
		  return modulesRepo.findModuleByCourseName(course_name);
		  
	  }  
	
	  
	  
	  // COUNT ALL MODULE
	
	  @GetMapping("/countModule")
	  public String countModule() {
		  
		  return modulesRepo.countModule();
	  }
	
	
	  
	  
	 
	  
	  
		
		
 	  
		//   ALL MODULES UNDER EACH COURSE
	  @GetMapping("/findModulesUnderEachCourseById")
	  public List<Modules> findModulesUnderEachCourseById(@RequestParam("id") int id) {
		  
		  return modulesRepo.findModulesUnderEachCourseById(id);
		  
	  }
	  
	  
	  
	  
	  
	  
	  
		
		
	// METHOD TO RETRIEVE ALL COURSE NAME UNDER MODULE TABLE
		
		@GetMapping("/getCourseNameAndCourseLevel")
		public List<Modules> getCourseNameAndCourseLevel(){
			return modulesRepo.getCourseNameAndCourseLevel();
		}
	
	
			


		@GetMapping("/findModuleById")
		public Optional<Modules> findAllById(@RequestParam ("id")Long id){
			
			return modulesRepo.findById(id);
		}
			  
			  
			  
			  
			  
			  

//
//				//RETRIEVE THE TOTAL NUMBER OF MODULES UNDER EACH COURSE
//				  	  @GetMapping("/totalNumberOfModulesUnderEachCourse/{id}")
//				  public List<Modules> findTotalNumberOfModulesUnderEachCourseById(@PathVariable("id") int id) {
//					  
//					  return modulesRepo.findTotalNumberOfModulesUnderEachCourseById(id);
//				  }
//
//
//
//
//
//			//  ALL STUDENTS UNDER EACH MODULES
//				  	  @GetMapping("/retrievalOfStudentsUnderEachModule/{id}")
//				  public List<String> retrievalOfStudentsUnderEachModuleById(@PathVariable("id") int id) {
//					  
//					  return modulesRepo.retrievalOfStudentsUnderEachModuleById(id);
//				  }
//
//
//
//				  	  
				  	  
				  	  

			//  RETRIEVE THE TOTAL NUMBER OF STUDENTS UNDER EACH MODULE
				  	 // @GetMapping("/totalNumberOfStudentsUnderEachModule/{id}")
				  //public List<String> findTotalNumberOfStudentsUnderEachModuleById(@PathVariable("id") int id) {
					  
					  //return modulesRepo.findTotalNumberOfStudentsUnderEachModuleById(id);
				  //}
			
				
				
	
				  	  
				  	  
				  	  
				  	  
				  	  
				  	  
				  	  
				  	
				  	  
				  	  

}
