package com.shubham.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.service.ContactServiceImp;

@WebServlet("/deletecontact")
public class DeleteContactServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();		
		String id = req.getParameter("contactId");
		
		int contactId = Integer.parseInt(id);
		
		ContactServiceImp contactServiceImp = new ContactServiceImp();
		String result = contactServiceImp.deleteService(contactId);
				
		session.setAttribute("msg", result);
		resp.sendRedirect("ReadMessageServlet");
	}
}