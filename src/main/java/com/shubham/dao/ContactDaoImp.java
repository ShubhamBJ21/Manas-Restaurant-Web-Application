package com.shubham.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shubham.model.Contact;

public class ContactDaoImp implements ContactDao {

	private String result;

	@Override
	public String saveContact(String name, String email, String subject, String message, String dateTime) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String query = "INSERT INTO contact VALUES(?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, subject);
			preparedStatement.setString(5, message);
			preparedStatement.setString(6, dateTime);

			int executeUpdate = preparedStatement.executeUpdate();

			if (executeUpdate > 0) {
				result = "MESSAGE SENT SUCCESSFULLY";
			} else {
				result = "SOMETHING WENT WRONG";
			}

		} catch (Exception e) {
			result = "SOMETHING WENT WRONG in connection";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Contact> readContact() {
		ArrayList<Contact> arrayList = new ArrayList<Contact>();
		Connection connection = null ;
		
		try {
			connection = ConnectionFactory.getConnection();
			String query = "SELECT * FROM contact";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				arrayList.add(new Contact(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6)));
			}
			
		} catch (Exception e) {
			arrayList.clear();
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return arrayList;
	}

	@Override
	public String deleteContact(int id) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String query = "DELETE FROM contact WHERE cid = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			int executeUpdate = preparedStatement.executeUpdate();
			if(executeUpdate == 1) {
				result = "MESSAGE DELETED SUCCESSFULLY";
			}else {
				result = "SOMETHING WRONG WHEN YOU DELETE A DATA";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "SOMETHING WENT WRONG IN DAO LAYER";
		}
		return result;
	}

}
