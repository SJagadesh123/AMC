<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zm.ams.dto.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/amc-list-style.css"/>
<style type="text/css">
	h3{
		text-align: center;
	}
</style>
<title>Amc List</title>
</head>
<body>
<h3>Search Result</h3>
	<br>
    <input type="button" value="Back" onclick="window.location.href='search-amc.jsp'">
	 <table class="search-results">
    <thead>
      <tr>
        <th>Name</th>
        <th>State</th>
        <th>City</th>
        <th>Status</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
		<%session = request.getSession();
			List<AppraisalManagementCompany> amcList = (List<AppraisalManagementCompany>)session.getAttribute("amcList");%>
			<% for(AppraisalManagementCompany amc: amcList)
			{
			
			%>

			<tr>
				<td><%=amc.getAmcName() %><%session.setAttribute("amcName", amc.getAmcName()); %></td>
				<td><%=amc.getState()%></td>
				<td><%=amc.getCity() %></td>
				<td><%=amc.getActive().equals("Y") ? "Active" :"Inactive"%></td>
				<td class="action-links">
				<a class="view-project" href="/appraiser_management_system/redirect-project?action=view-project&amcId=<%=amc.getAmcId() %>">View Project</a>
            <a class="add-project" href="/appraiser_management_system/redirect-project?action=add-project&amcId=<%=amc.getAmcId()%>">Add Project</a>
            <a class="edit-project" href="#">Edit</a>
			</tr>
			<%
			}
			%>	
		
    </tbody>
  </table>
  
  
</body>
</html>