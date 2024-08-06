package com.shubham.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shubham.model.Contact;
import com.shubham.model.ServiceModule;

public class ServiceDaoImp implements ServiceDao {

	private String result;
	
	@Override
	public String addService(String iconname, String title, String description, String dateTime) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String query = "INSERT INTO service VALUES(?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, iconname);
			preparedStatement.setString(3, title);
			preparedStatement.setString(4, description);
			preparedStatement.setString(5, dateTime);

			int executeUpdate = preparedStatement.executeUpdate();

			if (executeUpdate > 0) {
				result = "MESSAGE SENT SUCCESSFULLY";
			} else {
				result = "SOMETHING WENT WRONG";
			}

			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			result = "SOMETHING WENT WRONG in connection";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ServiceModule> readAllServices() {
		ArrayList<ServiceModule> arrayList = new ArrayList<ServiceModule>();
		Connection connection = null ;
		
		try {
			connection = ConnectionFactory.getConnection();
			String query = "SELECT * FROM service";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				arrayList.add(new ServiceModule(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
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
	public ArrayList<ServiceModule> readFourServices() {
		ArrayList<ServiceModule> arrayList = new ArrayList<ServiceModule>();
		Connection connection = null ;
		
		try {
			connection = ConnectionFactory.getConnection();
			String query = "SELECT * FROM service LIMIT 4";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				arrayList.add(new ServiceModule(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
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
	public String deleteServie(int id) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			String query = "DELETE FROM service WHERE serviceid = ?";
			
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
