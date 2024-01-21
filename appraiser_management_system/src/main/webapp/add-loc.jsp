<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<%@ page import="com.zm.ams.dto.States"%>
<%@ page import="com.zm.ams.dto.AppraisalManagementCompany"%>
<%@ page import="com.zm.ams.services.impl.AmcServiceImpl" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/addloc-style.css" />
<title>Add Location</title>
<style>


</style>
</head>
<body>

	<form action="addLoc" method="post" class="form">
		<h2>ADD LOCATION</h2>
		<c:if test="${error != null}">
				<span style=color:red>The state and location for the company already exist!!!!</span>
				</c:if>
		<label for="AMC">AMC Company*</label> <select name="amc" required>
			<option value="" selected disabled>Select AMC</option>
			<%
			for (String amcName : new AmcServiceImpl().getAmcNames()) {
			%>
			<option value="<%=amcName%>"><%=amcName%></option>
			<%
			}
			%> 
			
			

		</select> <label for="State">State*</label> <select name="state" required>
			<option selected disabled>Select State</option>
			<c:forEach var="state" items="${States.values()}">
				<option value="${state.getStateName()}">${state}</option>
			</c:forEach>
		</select> 
		<label for="City">City*</label> <input type="text" name="city"
			required />

		<table>
			<tr>
				<td><button type="submit">Add</button></td>
				<td><button type="button" onclick="window.location.href='home-page.jsp'">Cancel</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
