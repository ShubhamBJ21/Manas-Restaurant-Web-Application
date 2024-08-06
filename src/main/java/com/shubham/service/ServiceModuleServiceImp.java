package com.shubham.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.shubham.dao.ContactDaoImp;
import com.shubham.dao.ServiceDaoImp;
import com.shubham.model.ServiceModule;
import com.shubham.validation.ServiceModuleValidation;
import com.shubham.validation.ServiceModuleValidationImp;

public class ServiceModuleServiceImp implements ServiceModuleService {

	private String result;

	@Override
	public String validateService(String iconName, String title, String description) {

		try {
			ServiceModuleValidation serviceModuleValidation = new ServiceModuleValidationImp();
			result = serviceModuleValidation.serviceModuleValidation(iconName, title, description);
		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String addService(String iconName, String title, String description) {
		try {
			String dateTime = LocalDateTime.now().toString();

			ServiceDaoImp serviceDaoImp = new ServiceDaoImp();
			result = serviceDaoImp.addService(iconName, title, description, dateTime);

		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ServiceModule> readServices() {
		ArrayList<ServiceModule> arrayList = null;

		try {
			ServiceDaoImp daoImp = new ServiceDaoImp();
			arrayList = daoImp.readAllServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public ArrayList<ServiceModule> readFourServices() {
		ArrayList<ServiceModule> arrayList = null;

		try {
			ServiceDaoImp daoImp = new ServiceDaoImp();
			arrayList = daoImp.readFourServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public String deleteService(int id) {
		try {
			ServiceDaoImp serviceDaoImp = new ServiceDaoImp();
			serviceDaoImp.deleteServie(id);
		}catch(Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}
}
