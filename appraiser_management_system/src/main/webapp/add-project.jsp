<%@page import="com.zm.ams.services.impl.PropertyTypeServiceImpl"%>
<%@page import="com.zm.ams.services.impl.AmcAppraisalLocServiceImpl"%>
<%@page import="com.zm.ams.services.impl.AppraisalLocServiceImpl"%>
<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page import="com.zm.ams.dto.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.zm.ams.services.PropertyTypeService"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="CSS/add-project.css">
<title>Add Project</title>
<style>

input[type="submit"] {
	padding: 5px 10px;
}

input[type="submit"]:hover {
	background-color: gray;
}

input[type="button"] {
	padding: 5px 10px;
}

input[type="button"]:hover {
	background-color: gray;
}

.form {
	max-width: 600px;
	margin: 20px auto;
	background-color: white;
	padding: 20px;
	box-shadow: 0 0 10px;
}
</style>
</head>
<body>
	<form action="add-project" method="post" class=form>
		<h2>Add Project</h2>
		<c:if test="${error != null}">
			<span style="color: red">The project already exists for this company!!!!</span>
		</c:if>
		<table>
			<tr>
				<td>Property Type</td>
				<td><select name="property" required>
						<option selected disabled>select type</option>
						<%
						List<PropertyType> propertyList = new PropertyTypeServiceImpl().getAll();
						for (PropertyType property : propertyList) {
						%>
						<option value="<%=property.getPropertyTypeId()%>"><%=property.getPropertyTypeDesc()%></option>
						<%
						}
						%>

				</select></td>
			</tr>

			<tr>
				<td>Project Client</td>
				<td><input type="text" name="project-client"
					placeholder="project-client" required></td>
			</tr>

			<tr>
				<td>Project Remarks</td>
				<td><textarea rows="4" name="project-remarks"></textarea></td>
			</tr>

			<tr>
				<td>Client Remarks</td>
				<td><textarea rows="4" name="client-remarks"></textarea></td>
			</tr>

			<tr>
				<td>Location</td>
				<td><select name="loc" requried>
						<option selected disabled>select location</option>
						<%
						session = request.getSession();
						if(session.getAttribute("amcId") != null)
						{
							
						
						List<AppraisalLoc> loc = new AmcAppraisalLocServiceImpl()
								.getLocIdByAmc(Integer.parseInt((String) session.getAttribute("amcId")));

						for (AppraisalLoc location : loc) {
						%>
						<option value="<%=location.getLocId()%>"><%=location.getState() + "-" + location.getCity()%></option>
						<%
						} 
						}
						else{ %>
						
						<h3>Session expired please login again!!!</h3>
						<a href="login-page.jsp">login</a>
							
						<%
						}
						%>
				</select></td>
			</tr>

			<tr>
				<td>Project Start Date</td>
				<td><input type="date" name="start-date"></td>
			</tr>

			<tr>
				<td>Project End Date</td>
				<td><input type="date" name="end-date"></td>
			</tr>
			<tr>
				<td>Estimated Value</td>
				<td><input type="text" name="amount" placeholder="Amount" /></td>
			</tr>
		</table>
		<br> <input type="submit" value="Add"> <input
			type="button" value="Cancel"
			onclick="window.location.href='amc-list.jsp'">
	</form>
</body>
</html>