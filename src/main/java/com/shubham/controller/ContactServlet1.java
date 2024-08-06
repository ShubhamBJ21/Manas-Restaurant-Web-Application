package com.shubham.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.service.ContactServiceImp;

@WebServlet("/ContactServlet1")
public class ContactServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String result;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String subject = req.getParameter("subject");
		String message = req.getParameter("message");

		ContactServiceImp contactServiceImp = new ContactServiceImp();
		result = contactServiceImp.contactService1(name, email, subject, message);

		System.out.println(result);

		if (result.equals("VALID")) {
			result = contactServiceImp.contactService2(name, email, subject, message);
			session.setAttribute("msg", result);
			resp.sendRedirect("contact.jsp");
		} else {
			session.setAttribute("msg", result);
			resp.sendRedirect("contact.jsp");
		}
	}
}
