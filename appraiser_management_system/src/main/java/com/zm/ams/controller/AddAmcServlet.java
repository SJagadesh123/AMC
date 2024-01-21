package com.zm.ams.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.zm.ams.dto.AppraisalManagementCompany;
import com.zm.ams.services.AmcService;
import com.zm.ams.services.impl.AmcServiceImpl;

@WebServlet("/add-amc")
public class AddAmcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddAmcServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AmcService amc = new AmcServiceImpl();
		
		try {
			amc.save(new AppraisalManagementCompany(request.getParameter("regId"), 
					request.getParameter("companyName").toLowerCase(),
					request.getParameter("remarks").toLowerCase(), 
					request.getParameter("address1").toLowerCase(),
					request.getParameter("address2").toLowerCase(), 
					request.getParameter("state").toLowerCase(), 
					request.getParameter("city").toLowerCase(), 
					Integer.parseInt(request.getParameter("zipcode")), 
					request.getParameter("status")));
			
			response.sendRedirect("home-page.jsp");
		} catch (NumberFormatException | SQLException e) {
			
			HttpSession session = request.getSession();
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("add-amc.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
