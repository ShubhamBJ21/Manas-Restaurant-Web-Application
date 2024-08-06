package com.shubham.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.shubham.dao.ContactDaoImp;
import com.shubham.model.Contact;
import com.shubham.validation.ContactValidationImp;

public class ContactServiceImp implements ContactService {
	private String result;

	@Override
	public String contactService1(String name, String email, String subject, String message) {
		
		try {
			ContactValidationImp contactValidationImp = new ContactValidationImp();
			result = contactValidationImp.contactValidation(name, email, subject, message);
		}
		catch(Exception e){
			result = "SERVICE ERROR";
			e.addSuppressed(e);
		}
		return result;
	}

	@Override
	public String contactService2(String name, String email, String subject, String message) {
		try {
			String dateTime = LocalDateTime.now().toString();
			
			ContactDaoImp contactDaoImp = new ContactDaoImp();
			result = contactDaoImp.saveContact(name, email, subject, message, dateTime);
			
		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<Contact> readContactService() {
		ArrayList<Contact> list = null;
		
		try {
			ContactDaoImp contactDaoImp = new ContactDaoImp();
			list = contactDaoImp.readContact();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String deleteService(int id) {
		try {
			ContactDaoImp contactDaoImp = new ContactDaoImp();
			result = contactDaoImp.deleteContact(id);
		}catch(Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
		return result;
	}
	
}
