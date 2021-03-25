package com.astroapi.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class Config {
	private static Config instance;
	private DSLContext database;
	private Connection conn;
	
	private Config() { connectToDatabase(); }
    
	public static synchronized Config getInstance(){
		return (instance == null) ? new Config() : instance;
	}

	public DSLContext getDatabase() { return database; }

	public Connection getConn() { return conn; }
	
	//covert to props later
	public boolean connectToDatabase() {
		final String USERNAME = "root";
		final String PASSWORD = "";
		final String TIMEZONE = "?serverTimezone=UTC";
		final String URL = "jdbc:mysql://localhost:3306/Java" + TIMEZONE;
	  try {
	  	Class.forName("com.mysql.cj.jdbc.Driver");
	  	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	  	database = DSL.using(conn);
	  	return true;
	  } 
	  catch (Exception e) {
	  	e.printStackTrace();
	    return false;
	  }
	}
}

