package com.shubham.dao;

import java.util.ArrayList;

import com.shubham.model.ServiceModule;

public interface ServiceDao {
	public String addService(String iconname, String title, String description, String dateTime);
	public ArrayList<ServiceModule> readAllServices();
	public ArrayList<ServiceModule> readFourServices();
	public String deleteServie(int id);
}
