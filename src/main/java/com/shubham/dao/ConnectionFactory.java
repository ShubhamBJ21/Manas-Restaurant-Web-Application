package com.shubham.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/manas";
	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() throws Exception{
		Class.forName(driverClassName);
		return DriverManager.getConnection(url, username, password);
	}
}
