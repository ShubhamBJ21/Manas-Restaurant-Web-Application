package com.shubham.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.service.ServiceModuleServiceImp;

@WebServlet("/ServiceModuleServlet2")
public class ServiceModuleServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String result;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String name = request.getParameter("iconname");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		try {
			ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();
			result = serviceModuleServiceImp.addService(name, title, description);
			
			session.setAttribute("msg", result);
			response.sendRedirect("addservice.jsp");
			
		} catch (Exception e) {
			result = "SERVICE ERROR";
			e.printStackTrace();
		}
	}

}
