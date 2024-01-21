package com.zm.ams.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.zm.ams.dto.User;
import com.zm.ams.services.UserService;
import com.zm.ams.services.impl.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User(request.getParameter("user"), request.getParameter("pass"));
		
		UserService service = new UserServiceImpl();
		try {

			if(service.validateUser(user))
			{
				HttpSession session = request.getSession();
				session.setAttribute("first_name", user.getFirstName());
				response.sendRedirect("home-page.jsp");
			}
			else
			{
				request.setAttribute("error", "Invalid");
				RequestDispatcher rd = request.getRequestDispatcher("login-page.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
