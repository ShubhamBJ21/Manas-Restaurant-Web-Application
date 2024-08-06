package com.shubham.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.service.ServiceModuleServiceImp;

@WebServlet("/ServiceModuleServlet")
public class ServiceModuleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String name = request.getParameter("iconname");
		String title = request.getParameter("title");
		String description = request.getParameter("description");

		ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();
		String result = serviceModuleServiceImp.validateService(name, title, description);

		if ("VALID".equals(result)) {
			// forward to service package
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServiceModuleServlet2");
			requestDispatcher.forward(request, response);

		} else {
			// forward to validation
			session.setAttribute("msg", result);
			response.sendRedirect("addservice.jsp");
		}
	}
}
