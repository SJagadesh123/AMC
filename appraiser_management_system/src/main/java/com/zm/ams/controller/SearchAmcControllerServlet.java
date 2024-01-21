package com.zm.ams.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.dto.AppraisalManagementCompany;
import com.zm.ams.services.AmcService;
import com.zm.ams.services.impl.AmcServiceImpl;

@WebServlet("/search-amc")
public class SearchAmcControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchAmcControllerServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AmcService amcService = new AmcServiceImpl();
		HttpSession session = request.getSession();
		String city = request.getParameter("city").length() == 0? null : request.getParameter("city");
		String amc = request.getParameter("amc").length() == 0? null : request.getParameter("amc");

		
		
		try {
			
			List<AppraisalManagementCompany> amcList = amcService.getBySearchCriteria(new AmcSearchCriteria
												(amc,request.getParameter("state"),city));
			
			
			
			session.setAttribute("amcList", amcList);
			response.sendRedirect("amc-list.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
