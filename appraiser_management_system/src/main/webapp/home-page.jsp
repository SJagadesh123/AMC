<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/home-style.css">
<title>Home Page</title>
</head>
	
<body>


<h3>Hello  <%= session.getAttribute("first_name") %></h3>
	<ul>
		<li><a href="add-amc.jsp">Add AMC</a></li>
		<li><a href="add-loc.jsp">Add Location</a></li>
		<li><a href="search-amc.jsp">Search AMC</a></li>
	</ul>

</body>
</html>