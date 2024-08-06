package com.shubham.service;

import com.shubham.dao.AdminLoginDaoImp;
import com.shubham.validation.AdminLoginValidationImp;

public class AdminLoginServiceImp implements AdminLoginService{

	private String result;
	
	@Override
	public String adminloginService1(String username, String password) {
		try {
		AdminLoginValidationImp adminLoginValidationImp	= new AdminLoginValidationImp();
		result = adminLoginValidationImp.adminLoginValidation1(username, password);
		
		}catch(Exception e) {
			result = "ERROR OCCUR IN ADMIN LOGIN SERVICE IMPLEMENTATION";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String adminloginService2(String username, String password) {
		try {
			//DAO
			AdminLoginDaoImp adminLoginDaoImp = new AdminLoginDaoImp();
			result = adminLoginDaoImp.checkAdminLoginData(username, password);
			
		}catch (Exception e) {
			result="ERROR OCCUR IN ADMIN LOGIN SERVICE IMPLEMENTATION";
			e.printStackTrace();
		}
		return result;
	}

}
