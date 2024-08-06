package com.shubham.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.service.AdminLoginServiceImp;

@WebServlet("/AdminLoginServlet2")
public class AdminLoginServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		AdminLoginServiceImp adminLoginServiceImp = new AdminLoginServiceImp();
		String result = adminLoginServiceImp.adminloginService2(username, password);
		
		if(result.contains("EXIST")) {
			//admin panel
			session.setAttribute("adminlogin", "PERMIT TO OPEN ADMIN PANEL");
			resp.sendRedirect("admin.jsp");
		}else {
			session.setAttribute("msg", "USERNAME AND PASSWORD NOT EXIST");
			resp.sendRedirect("adminlogin.jsp");
		}
	}

}
