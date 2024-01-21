<%@page import="com.zm.ams.services.impl.AppraisalLocServiceImpl"%>
<%@page import="com.zm.ams.services.AppraisalLocService"%>
<%@page import="com.zm.ams.services.impl.AmcServiceImpl"%>
<%@page import="com.zm.ams.services.impl.AmcProjectServiceImpl"%>
<%@page import="com.zm.ams.services.impl.PropertyTypeServiceImpl"%>
<%@page import="com.zm.ams.services.PropertyTypeService"%>
<%@page import="com.zm.ams.dto.AmcSearchCriteria"%>
<%@page import="com.zm.ams.dao.jdbc.impl.AmcProjectDaoImpl"%>
<%@page import="com.zm.ams.dto.AmcProject"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/view-project.css">
    <title>View Projects</title>
    <style type="text/css">
    	h3{
    	text-align: center;
    	}
    </style>
</head>
<body>
<%session = request.getSession();

int amcId = Integer.parseInt((String)session.getAttribute("amcId")); %>

<h3>Projects of <span><%= new AmcServiceImpl().get(amcId).get().getAmcName() %></span></h3>

    <input type="button" value="Back" onclick="window.location.href='amc-list.jsp'"/>
    <table>
        <thead>
        <tr>
            <th>Project Type</th>
            <th>Project Client</th>
            <th>Project State</th>
            <th>Project City</th>
            <th>Project Start Date</th>
            <th>Project End Date</th>
            <th>Net Worth</th>
        </tr>
        </thead>
        <tbody>
        	<% 
        		
        		
        		List<AmcProject> amcProject = new AmcProjectServiceImpl()
        										.getAll(new AmcSearchCriteria(amcId));
        										
        		PropertyTypeService property = new PropertyTypeServiceImpl();	
        		AppraisalLocService location = new AppraisalLocServiceImpl();
        										
        										
        										%>
        		
        		
        		<%for(AmcProject project : amcProject)
        		{
        		%>
        		<tr>
        			<td><%=property.get(project.getPropertyTypeId()).get().getPropertyTypeDesc() %></td>
        			<td><%=project.getProjectClient() %></td>
        			<td><%=location.get(project.getLocId()).get().getState() %></td>
        			<td><%=location.get(project.getLocId()).get().getCity() %>
        			<td><%=project.getStartDate() %></td>
        			<td><%=project.getEndDate() %></td>
        			<td><%=project.getEstimatedValue() %></td>
        		</tr>
        		<%
        			}
        		%>
        </tbody>
    </table>
</body>
</html>
