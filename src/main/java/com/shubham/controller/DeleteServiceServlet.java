package com.shubham.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.service.ServiceModuleServiceImp;

@WebServlet("/DeleteService")
public class DeleteServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		String id = request.getParameter("serviceId");
		
		int serviceId = Integer.parseInt(id);
		
		ServiceModuleServiceImp imp = new ServiceModuleServiceImp();
		String result = imp.deleteService(serviceId);
		
		session.setAttribute("msg", result);
		response.sendRedirect("ReadUpdateDeleteServlet");
	}

}
