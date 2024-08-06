package com.shubham.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.model.ServiceModule;
import com.shubham.service.ServiceModuleServiceImp;

/**
 * Servlet implementation class ReadFourServiceModule
 */
public class ReadFourServiceModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("check", "From Servlet");
		
		ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();
		ArrayList<ServiceModule> arrayList = serviceModuleServiceImp.readFourServices();
		
		if(arrayList == null) {
			session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
			response.sendRedirect("index.jsp");
		}
		else if(arrayList.isEmpty()) {
			session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
			response.sendRedirect("index.jsp"); 
		}
		else {
			session.setAttribute("servicedata", arrayList);
			response.sendRedirect("index.jsp");
		}
	}
}
