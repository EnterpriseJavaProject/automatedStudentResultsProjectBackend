package com.aiti.java.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class Application extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}  
	

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    
    
//    @EventListener(ApplicationReadyEvent.class)
//    public Staffs sendMail(int id) throws SQLException, ClassNotFoundException {
//    	
//    	return staffsProfileController.findStaffById(id);
//    }



}
