package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mariadb://localhost:3306/hb-03-one-to-many";
		String user = "hbstudent";
		String password = "hbstudent";
				
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successful!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
