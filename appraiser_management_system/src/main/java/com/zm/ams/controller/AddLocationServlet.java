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

import com.zm.ams.dto.AmcAppraisalLoc;
import com.zm.ams.dto.AppraisalLoc;
import com.zm.ams.dto.AppraisalManagementCompany;
import com.zm.ams.services.AmcAppraisalLocService;
import com.zm.ams.services.AmcService;
import com.zm.ams.services.AppraisalLocService;
import com.zm.ams.services.impl.AmcAppraisalLocServiceImpl;
import com.zm.ams.services.impl.AmcServiceImpl;
import com.zm.ams.services.impl.AppraisalLocServiceImpl;

@WebServlet("/addLoc")
public class AddLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddLocationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String state = request.getParameter("state").toLowerCase();
		String city = request.getParameter("city").toLowerCase();
		String amcName = request.getParameter("amc").toLowerCase();

		AppraisalLocService appraisalLocService = new  AppraisalLocServiceImpl();
		AmcService amcService = new AmcServiceImpl();
		AmcAppraisalLocService amcLocService = new AmcAppraisalLocServiceImpl();
		
		try {
			int locId = appraisalLocService.save(new AppraisalLoc(state, city));
			int amcId = amcService.getId(new AppraisalManagementCompany(amcName));
			amcLocService.save(new AmcAppraisalLoc(amcId, locId));
			
			System.out.println(state);
			System.out.println(city);
			System.out.println(amcName);
			System.out.println(locId);
			System.out.println(amcId);
		} catch (SQLException e) {

			HttpSession session = request.getSession();
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("add-loc.jsp");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("home-page.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
