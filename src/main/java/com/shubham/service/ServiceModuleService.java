package com.shubham.service;

import java.util.ArrayList;

import com.shubham.model.ServiceModule;

public interface ServiceModuleService {
	public String validateService(String iconName, String title, String description);
	public String addService(String iconName, String title, String description);
	public ArrayList<ServiceModule> readServices();
	public ArrayList<ServiceModule> readFourServices();
	public String deleteService(int id);
}
