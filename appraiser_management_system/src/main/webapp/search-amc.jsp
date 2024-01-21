<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zm.ams.dto.States"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/search-style.css" />
<title>Search Amc</title>
<style type="text/css">
.form {
	max-width: 600px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<form action="search-amc" class=form method="post">

		<label for="company-name">Company Name:</label> <input type="text"
			name="amc" placeholder="Enter a keyword or company name">

		<label for="State">State:</label> <select name="state" required>
			<option selected disabled>Select State</option>
			<c:forEach var="state" items="${States.values()}">
				<option value="${state.getStateName()}">${state}</option>
			</c:forEach>
		</select> 
		<label for="city">City</label> <input type="text" name="city"
			placeholder="Enter city">
				
			<button type="submit">Search</button>
			<button type="button" onclick="window.location.href='home-page.jsp'">Cancel</button>
	</form>
	
</body>
</html>