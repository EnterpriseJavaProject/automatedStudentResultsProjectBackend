package com.aiti.java.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	
	
	// INSERTING INTO TABLE
	   static final String DB_URL = "jdbc:mysql://localhost/hospital";
	   static final String USER = "root";
	   static final String PASS = "";

	   public static void main(String[] args) {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "	INSERT INTO patient(name, age) VALUES('Nana Kwesi', 20)";
	         stmt.executeUpdate(sql);
	         System.out.println("Record inserted successfully.........");   	  
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
	   
	   
	   
	
	// CREATING TABLE
	   //static final String DB_URL = "jdbc:mysql://localhost/hospital";
	   //static final String USER = "root";
	   //static final String PASS = "";

	  // public static void main(String[] args) {
	      // Open a connection
	     // try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	       //  Statement stmt = conn.createStatement();
	     // ) {		      
	        // String sql = "Create Table patient" + "(id Integer not null AUTO_INCREMENT, " + "name Varchar(255), " + "age Integer,  " + "PRIMARY KEY(id))";
	         //stmt.executeUpdate(sql);
	         //System.out.println("Table created successfully.........");   	  
	      //} catch (SQLException e) {
	        // e.printStackTrace();
	      //} 
	  // }
	   
	   
	   
	   
	   
	   
	   
	   
		// CREATING DATABASE
	   //static final String DB_URL = "jdbc:mysql://localhost/";
	   //static final String USER = "root";
	   //static final String PASS = "";

	   //public static void main(String[] args) {
	      // Open a connection
	     // try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	       //  Statement stmt = conn.createStatement();
	      //) {		      
	       //  String sql = "CREATE DATABASE hospital";
	        // stmt.executeUpdate(sql);
	       //  System.out.println("Database created successfully...");   	  
	      //} catch (SQLException e) {
	      //   e.printStackTrace();
	      //} 
	  // }
	

}
