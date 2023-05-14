package com.myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// static Connection object named conn which will hold the db connection
	static Connection conn = null;

	// static method which returns a connection object
	static Connection getConnection() {

		try {
			// 1. the method loads the H2 driver using Class.forName
			Class.forName("org.h2.Driver");
			// establishes a connection using the DriverManager.getConnection method
			conn = DriverManager.getConnection("jdbc:h2:/Users/georginavitanova/databases/myDB", "sa", "123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// if there was an error in the database syntax or the connection could not be
			// established
			e.printStackTrace();
		}

		return conn;
	}

}