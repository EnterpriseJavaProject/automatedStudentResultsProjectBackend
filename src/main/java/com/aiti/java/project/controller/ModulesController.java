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
@CrossOrigin(origins = "*")
@RequestMapping("/modules")
public class ModulesController {
	
	
	Modules modules = new Modules();
	
	

	  
  
	
	
	@Autowired
	ModulesRepository modulesRepo;
	
	
	
	
	  
		//   ALL MODULES UNDER PAST STUDENT COURSE
	  @GetMapping("/findModulesUnderPastStudentCourse")
	  public List<Modules> findModulesUnderPastStudentCourse(@RequestParam("id") Long id) {
		  
		  return modulesRepo.allModulesUnderPastStudentCourse(id);
		  
	  }
	  
	
	
	
	
	//  TOTAL NUMBER OF STUDENTS UNDER EACH MODULES
	  @GetMapping("/totalNumberOfStudentsUnderEachModule")
public String retrievalOfStudentsUnderEachModuleById(@RequestParam("module_id") int module_id) {
	  
	  return modulesRepo.retrievalOfStudentsUnderEachModuleById(module_id);
}
	  
	  
	  
	  
	  
	  
	  
//  TOTAL NUMBER OF STUDENTS RESULTS UPLOADED
			  	  @GetMapping("/totalNumberOfStudentsResultsUploaded")
			  public String totalNumberOfStudentsResultsUploaded(@RequestParam("module_id") int module_id) {
				  
				  return modulesRepo.totalNumberOfStudentsResultsUploaded(module_id);
			  }
			  	  
					  	  
					  	  
					  	  
					  	  
					  	  
					  	  
					  	  
					  	  
	
	

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
	
	
	
	
	
	// FIND MODULE BY MODULE NAME
	
	  @GetMapping("/findModuleByModuleName") 
	  public List<Modules> findByName(@RequestParam ("modules_name") String modules_name){ 
		  return modulesRepo.findModuleByModuleName(modules_name);
		  
	  }
	  
	  
	  
	  
	  
	  
		// FIND MODULE BY COURSE NAME
		
	  @GetMapping("/findModuleByCourseName") 
	  public List<Modules> findByCourseName(@RequestParam ("course_name") String course_name){ 
		  return modulesRepo.findModuleByCourseName(course_name);
		  
	  }  
	  
	  
	  
	  
	  
	  
	  
		// FIND MODULE BY COURSE NAME
		
	  @GetMapping("/findByCourseID") 
	  public List<Modules> findByCourseID(@RequestParam ("course_id") Long course_id){ 
		  return modulesRepo.findModuleByCourseID(course_id);
		  
	  }  
	  
	  
	  
	  
	  
	
	  
	  
	  // COUNT ALL MODULE
	
	  @GetMapping("/countModule")
	  public String countModule() {
		  
		  return modulesRepo.countModule();
	  }
	
	
	  
	  
	 
	  
	  
		
		
 	  
		//   ALL MODULES UNDER EACH COURSE
	  @GetMapping("/findModulesUnderEachCourse")
	  public List<Modules> findModulesUnderEachCourseById(@RequestParam("id") Long id) {
		  
		  return modulesRepo.allModulesUnderEachCourse(id);
		  
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
				  	  @GetMapping("/totalNumberOfModulesUnderEachCourse")
				  public String findTotalNumberOfModulesUnderEachCourseById(@RequestParam("course_id") int course_id) {
					  
					  return modulesRepo.findTotalNumberOfModulesUnderEachCourseById(course_id);
				  }

				  	  
		
				  	  
				  	  
				  	  
				  	



				  	  
				  	  
				  	  

			//  RETRIEVE THE TOTAL NUMBER OF STUDENTS UNDER EACH MODULE
				  	 // @GetMapping("/totalNumberOfStudentsUnderEachModule/{id}")
				  //public List<String> findTotalNumberOfStudentsUnderEachModuleById(@PathVariable("id") int id) {
					  
					  //return modulesRepo.findTotalNumberOfStudentsUnderEachModuleById(id);
				  //}
			
				
				
	
				  	  
				  	  
				  	  
				  	  
				  	  
				  	  
				  	  
				  	
				  	  
				  	  

}
