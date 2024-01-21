package com.zm.ams.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.zm.ams.dto.AmcProject;
import com.zm.ams.services.AmcProjectService;
import com.zm.ams.services.impl.AmcProjectServiceImpl;

@WebServlet("/add-project")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddProject() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		int amcId = Integer.parseInt((String)session.getAttribute("amcId"));
		int projectTypeId = Integer.parseInt(request.getParameter("property"));
		String projectClient = request.getParameter("project-client").toLowerCase();
		String projectRemarks = request.getParameter("project-remarks").toLowerCase();
		String clientRemarks = request.getParameter("client-remarks").toLowerCase();
		java.sql.Date startDate = Date.valueOf(request.getParameter("start-date"));
		java.sql.Date endDate = Date.valueOf(request.getParameter("end-date"));
		double estimatedValue = Double.parseDouble(request.getParameter("amount"));
		int locId = Integer.parseInt(request.getParameter("loc"));
		
		
		AmcProjectService projectService = new AmcProjectServiceImpl();
		
		try {
			projectService.save(new AmcProject(amcId, projectTypeId, 
									projectClient, projectRemarks, clientRemarks, 
									startDate, endDate, estimatedValue, locId));
			response.sendRedirect("amc-list.jsp");
		} catch (SQLException e) {
			
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("add-loc.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
