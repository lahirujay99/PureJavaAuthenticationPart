package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	private static final String URL = "jdbc:mysql://localhost:3306/hotel";
	private static final String USER = "root";
	private static final String PASS = "1234";
	private static Connection con;
	public static Connection getConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(URL, USER, PASS);
		}catch(Exception ex) {
			System.out.println("Connection failed"+ex.getMessage());
		}
		return con;
	}
}
