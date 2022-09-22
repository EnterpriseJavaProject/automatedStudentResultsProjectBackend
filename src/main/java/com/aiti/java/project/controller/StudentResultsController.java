package com.aiti.java.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiti.java.project.entities.StudentResults;
import com.aiti.java.project.repository.StudentResultsRepositry;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/studentResults")
public class StudentResultsController {
	
	
	
	@Autowired
	StudentResultsRepositry studentResultsRepositry;
	
	
	
	
	@Autowired
	SendingEmailService sendingEmailService;
	
	
//	// FIND PAST STUDENT RESULTS BY STUDENT ID AND COURSE ID
	
	  @GetMapping("/findPastStudentResultsByStudentIDandCourseID") 
	  public List<StudentResults> findPastStudentResultsByStudentIDandCourseID(@RequestParam ("student_id") String student_id, @RequestParam ("course_id") int course_id){ 
		  
		  return studentResultsRepositry.findPastStudentResultsByStudentIDandCourseID(student_id, course_id);
		  
	  }
	  
	  
	  
	  
	  
	
	
//	// FIND PAST STUDENT RESULTS BY STUDENT ID
	
	  @GetMapping("/findPastStudentResultsByStudentID") 
	  public List<StudentResults> findPastStudentResultsByStudentID(@RequestParam ("student_id") String student_id){ 
		  
		  return studentResultsRepositry.findPastStudentResultsByStudentID(student_id);
		  
	  }
	
	
	
	
	
	
	
	
	
	// TOTAL NUMBER OF STUDENTS RESULTS UPLOADED
	
	  @GetMapping("/totalNumberOfStudentResultsUploadedUnderEachModule") 
	  public String totalNumberOfStudentResultsUploadedUnderEachModule(@RequestParam ("module_id") Long module_id){ 
		  
		  return studentResultsRepositry.totalNumberOfStudentResultsUploadedUnderEachModule(module_id);
		  
	  }
	
	
	
	
	
	
	  
//	// FIND RESULTS BY STUDENT ID AND COURSE ID
	
	  @GetMapping("/findStudentResultsByStudentIdAndCourseId") 
	  public List<StudentResults> findStudentResultsByStudentIdAndCourseId(@RequestParam ("student_id") String student_id, @RequestParam ("course_id") int course_id){ 
		  
		  return studentResultsRepositry.findResultsByStudentID(student_id, course_id);
		  
	  }
	  	
	  	
	

//	// FIND REULTS BY STUDENT NAME
	
	  @GetMapping("/findResultsByStudentName") 
	  public List<StudentResults> retrieveResultsByStudentName(@RequestParam ("student_name") String student_name){ 
		  
		  return studentResultsRepositry.findResultsByStudentName(student_name);
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	
	//  GET ALL RESULTS
	
	@GetMapping("/getAllResults")
	public List<StudentResults> findAllResults(){
		
		return studentResultsRepositry.findAll();
	}
	
	
	
	

	// SAVE ONLY STUDENT INFO INTO RESULTS TABLE
	
	@PostMapping("/saveOnlyStudent")
	public StudentResults saveOnlyStudent(@RequestBody StudentResults save) {
		
		return studentResultsRepositry.save(save);
	}
	
	
	
	
	
	// FIND ALL STUDENTS UNDER RESULTS TABLE
	
	  @GetMapping("/retrieveAllStudentsUnderResults/{id}") 
	  public List<StudentResults> findAllStudentsUnderResults(@PathVariable ("id") Long id){ 
		  
		  return studentResultsRepositry.findAllStudentsUnderResults(id);
		  
	  }
	  
	  
	  
	
	
	// SAVE STUDENT RESULTS
	
	@PatchMapping("saveStudentResults")
	public void saveStudentResults(@RequestBody StudentResults update) {
		
		 studentResultsRepositry.save(update);
		 //sendingEmailService.sendingStudentEmailAfterRestultsBeenUploaded(update);
	}
	
	
	
	
	
	
	
	
	//  SAVE ALL RESULTS
	
	@PatchMapping("/saveAllResults")
	public List<StudentResults> saveAllResults(@RequestBody List<StudentResults> saveResults){
		
		return studentResultsRepositry.saveAll(saveResults);
	}
	

	
//	//  DELETE RESULTS
	@DeleteMapping("/delete")
	public void deleteResults(@RequestParam ("id") Long id) {
		
		studentResultsRepositry.deleteById(id);
		
	}
	
	
	
	
	
//	// FIND RESULTS BY ID
	
	@GetMapping("/findResultsById")
	public List<StudentResults> findById(@RequestParam("id") Long id) {
		
		return studentResultsRepositry.findResultsById(id);
		
	}

	
	
	

	  
	  
	  
	  
	  
//		// FIND REULTS BY COURSE NAME
		
		  @GetMapping("/findResultsByCourseId") 
		  public List<StudentResults> retrieveResultsByCourseId(@RequestParam ("course_name") String course_name){ 
			  
			  return studentResultsRepositry.findResultsByCourseId(course_name);
			  
		  }
		  
		  
		  
		  
		  
		  
		  
//			// FIND REULTS BY MODULE NAME
			
		  @GetMapping("/findResultsByModuleName") 
		  public List<StudentResults> retrieveResultsByModuleName(@RequestParam ("module_name") String module_name){ 
			  
			  return studentResultsRepositry.findResultsByModuleName(module_name);
			  
		  }
		  
		  
		  
		  
		  
		  
//			// FIND REULTS BY STAFF NAME
			
		  @GetMapping("/findResultsByStaffName") 
		  public List<StudentResults> retrieveResultsByStaffName(@RequestParam ("staff_name") String staff_name){ 
			  
			  return studentResultsRepositry.findResultsByStaffName(staff_name);
			  
		  }
	
	
		  
		  
		  
		  
	


	  
	  
	  
	  
	  
	  
//	  //  COUNT ALL RESULTS
	
	  @GetMapping("/countResults")
	  public String countResults() {
		  
		  return studentResultsRepositry.countResults();
	  }

	  
	  
	  
	  
	  
		// METHOD TO INSERT STUDENT NAME,ID,COURSE_ID,MODULE NAME AND STAFF NAME INTO RESULTS TABLE
	  
	  
//	  @GetMapping("/insertIntoStudentNameIDandCourseIdIntoResults") 
//	  public Long insertIntoResults(@RequestParam("module_id") Long module_id) throws SQLException, ClassNotFoundException{ 
//		  
//		 
//		  Long module_idd = module_id;
//			
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/automated_student_results_system", "root", "");
//			
//			
//			PreparedStatement statement = conn.prepareStatement("INSERT into students_results(students_results.studentname, students_results.studentid,students_results.course_id,students_results.staffname, students_results.modulename, students_results.status) SELECT DISTINCT students.name, students.student_id, students.course_id, modules.staff_name, modules.module_name, modules.status FROM students, modules where students.course_id = modules.course_id and modules.id = '"+module_idd+"' GROUP by students.student_id ORDER BY modules.id");
//
//			statement.executeUpdate();
//
//			return module_id;
//
//	  }   
//	  
	  
	  
	  
	  
	  
	  
	  
//	// FIND STUDENT INFO FROM RESULTS TABLE
		
//	  @GetMapping("/findAllStudentsUnderResults") 
//	  public List<StudentResults> findAllStudentsUnderResults(@RequestParam ("module_id") Long module_id){ 
//		  
//		  return studentResultsRepositry.findAllStudentsUnderResults(module_id);
//		  
//	  }
//	
	
	
	
		// METHOD TO INSERT INTO RESULTS TABLE AND SELECT FROM STUDENT TABLE
	  
	  @SuppressWarnings("null")
	  @org.springframework.transaction.annotation.Transactional
	  @GetMapping("/insertIntoStudentNameIDandCourseIdIntoResults/{id}") 
	  public void insertIntoResults(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{ 
		  
		  	 
		  	int module_id = id;
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/automated_student_results_system", "root", "");
			
			Statement stmt = conn.createStatement();
			
			
			ResultSet selectRs = stmt.executeQuery("SELECT students_results.module_id FROM students_results inner join modules on students_results.course_id = modules.course_id where students_results.course_id = modules.course_id and modules.id = '"+module_id+"' GROUP by students_results.id ORDER by students_results.id");


		while(selectRs.next()) {
			
			
			if(selectRs.getInt(1) != id) {

				//PreparedStatement insertstatement = conn.prepareStatement("INSERT into students_results(students_results.name, students_results.student_id,students_results.course_id, students_results.staffname,students_results.module_id, students_results.modulename, students_results.status) SELECT DISTINCT students.name, students.student_id, students.course_id, modules.staff_name, module.id, modules.module_name, modules.status FROM students, modules where students.course_id = modules.course_id and modules.id = '"+module_id+"' GROUP by students.student_id ORDER BY modules.id");
				
				//return insertstatement.executeUpdate();
				
				System.out.println("Inserted Successfully");
				
			}
			
			
			else{
				 
				//conn.close();
				
				//return module_id;
				System.out.println("ID already exist");
				
			}
			
		}	
		
				//System.out.println("Not this one");
			
			}
			
//			else if(selectRs == insertstatement) {
//				
//				return module_id;
//			}


	  
	  
 
	  
	  
	  
	  
		// METHOD TO INSERT INTO RESULTS TABLE AND SELECT FROM STUDENT TABLE
	  
//	  @org.springframework.transaction.annotation.Transactional
//	  @PostMapping("/insertIntoStudentNameIDandCourseIdIntoResults/{id}") 
//	  public Long insertIntoResults(@PathVariable("id") Long id) throws SQLException, ClassNotFoundException{ 
//		  
//		  	
//		  	Long module_id = id;
//			
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/automated_student_results_system", "root", "");
//			
//			
//			PreparedStatement statement = conn.prepareStatement("INSERT into students_results(students_results.studentname, students_results.studentid,students_results.course_id,students_results.staffname, students_results.modulename, students_results.status) SELECT DISTINCT students.name, students.student_id, students.course_id, modules.staff_name, modules.module_name, modules.status FROM students, modules where students.course_id = modules.course_id and modules.id = '"+module_id+"' GROUP by students.student_id ORDER BY modules.id");
//
//			statement.executeUpdate();
//			
//			
//			if(module_id.equals(id)) {
//				
//				
//			}
//
//			return module_id;
//
//	  }   
	  
	  

		 
		// METHOD TO SEARCH FOR STUDENT RESULTS
		
		  @GetMapping("/searchStudentFinalResults/{student_id}") 
		  public StudentResults[] searchStudentFinalResults(@PathVariable("student_id") String student_id){ 
			  
			  return studentResultsRepositry.searchStudentFinalResults(student_id);
			  
		  }

}