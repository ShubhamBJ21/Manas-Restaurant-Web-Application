package com.shubham.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.service.AdminLoginServiceImp;

@WebServlet("/AdminLoginServlet1")
public class AdminLoginServlet1 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		AdminLoginServiceImp adminLoginServiceImp = new AdminLoginServiceImp();
		String result = adminLoginServiceImp.adminloginService1(username, password);
		
		if(result.equals("VALID")) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminLoginServlet2");
			requestDispatcher.forward(req, resp);
		}else {
			session.setAttribute("msg", result);
			resp.sendRedirect("adminlogin.jsp"); 
		}
		
	}

}
