package com.shubham.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDaoImp implements AdminLoginData{
	private String result;

	@Override
	public String checkAdminLoginData(String username, String password) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM adminlogin WHERE username = ? and password = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				result = "EXIST";
			}else {
				result = "NOT EXIST";
			}
			
		}catch(Exception e) {
			result = "ERROR IN CONNECTION";
			e.printStackTrace();
		}
		return result;
	}

}
