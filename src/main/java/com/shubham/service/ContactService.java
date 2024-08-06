package com.shubham.service;

import java.util.ArrayList;

import com.shubham.model.Contact;

public interface ContactService {

	public String contactService1(String name, String email, String subject, String message);
	public String contactService2(String name, String email, String subject, String message);
	public ArrayList<Contact> readContactService();
	public String deleteService(int id);
}
