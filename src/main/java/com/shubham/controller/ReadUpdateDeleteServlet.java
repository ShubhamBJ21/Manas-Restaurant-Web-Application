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

@WebServlet("/ReadUpdateDelete")
public class ReadUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		ServiceModuleServiceImp serviceModuleServiceImp = new ServiceModuleServiceImp();
		ArrayList<ServiceModule> arrayList = serviceModuleServiceImp.readServices();

		if (arrayList == null || arrayList.isEmpty()) {
			session.setAttribute("msg", "SERVICE UNAVAILABLE RIGHT NOW");
			response.sendRedirect("readservice.jsp");
		} else {
			session.setAttribute("servicedata", arrayList);
			response.sendRedirect("readservice.jsp");
		}
	}
}
