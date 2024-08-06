package com.shubham.dao;

import java.util.ArrayList;

import com.shubham.model.Contact;

public interface ContactDao {

	public String saveContact(String name, String email, String subject, String message, String dateTime);
	public ArrayList<Contact> readContact();
	public String deleteContact(int id);
}
