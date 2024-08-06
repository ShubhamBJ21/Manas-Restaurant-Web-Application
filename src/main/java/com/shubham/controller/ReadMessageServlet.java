package com.shubham.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.model.Contact;
import com.shubham.service.ContactServiceImp;

@WebServlet("/ReadMessageServlet")
public class ReadMessageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		ContactServiceImp contactServiceImp = new ContactServiceImp();
		ArrayList<Contact> arrayList = contactServiceImp.readContactService();
		
		//null   or Contact details or clear arraylist
		
		if(arrayList == null) {
			session.setAttribute("msg", "SOMETHING WENT WRONG: service layer");
			resp.sendRedirect("admin.jsp");
		}
		else if(arrayList.isEmpty()) {
			session.setAttribute("msg", "NO CONTACT DETAILS ARE PRESENT: dao layer");
			resp.sendRedirect("admin.jsp"); 
		}
		else {
			session.setAttribute("contactdata", arrayList);
			resp.sendRedirect("readcontact.jsp");
		}
	}

}
