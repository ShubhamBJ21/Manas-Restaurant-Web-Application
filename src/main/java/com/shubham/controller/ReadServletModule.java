package com.shubham.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.model.ServiceModule;
import com.shubham.service.ServiceModuleServiceImp;

@WebServlet("/ReadServiceModule")
public class ReadServletModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("check", "From Servlet");
		
		ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();
		ArrayList<ServiceModule> arrayList = serviceModuleServiceImp.readServices();
		
		if(arrayList == null) {
			session.setAttribute("msg", "SOMETHING WENT WRONG: service layer");
			response.sendRedirect("service.jsp");
		}
		else if(arrayList.isEmpty()) {
			session.setAttribute("msg", "No Services Are Available");
			response.sendRedirect("service.jsp"); 
		}
		else {
			session.setAttribute("servicedata", arrayList);
			response.sendRedirect("service.jsp");
		}
		
	}

}
