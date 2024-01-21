package com.zm.ams.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/redirect-project")
public class RedirectProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RedirectProjectServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("amcId", request.getParameter("amcId"));
		
		
		
		if(action.equals("add-project"))
		{
			
		response.sendRedirect("add-project.jsp");
		
		}
		else
		{	
			response.sendRedirect("view-project.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
