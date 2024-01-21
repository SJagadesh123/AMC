<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zm.ams.dto.States"%>
<html>
<head>
<link rel="stylesheet" href="CSS/addamc_style.css">
<title>Add Amc</title>
<style>

h3{
	text-align: center;
}
.form {
    max-width: 600px;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

</style>
</head>


<body>
	
	<form action="add-amc" method="post" class="form">
			<h3>Add Amc</h3>
			<c:if test="${error != null}">
				<span style=color:red>The company already exists!!!!</span>
				</c:if>
		<table>
			<tr>
				<td><label>AMC RegID *</label></td>
				<td><input type="text" name="regId" required /></td>
			</tr>
			<tr>
				<td><label>AMC Name *</label></td>
				<td><input type="text" name="companyName" required /></td>

			</tr>
			<tr>
				<td><label>Remarks *</label></td>
				<td><textarea rows="3" required name="remarks"></textarea></td>
			</tr>
			<tr>
				<td><label>Address 1 *</label></td>
				<td><input type="text" name="address1"></td>
			</tr>
			<tr>
				<td><label>Address 2 *</label></td>
				<td><input type="text" name="address2"></td>
			</tr>
			<tr>
				<td><label> State *</label></td>
				<td><select name="state" required>
						<option selected disabled>Select State</option>
						<c:forEach var="state" items="${States.values()}">
							<option value="${state.getStateName()}">${state}</option>
						</c:forEach>

				</select></td>
			<tr>
				<td><label>City *</label></td>
				<td><input type="text" required name="city" /></td>

			</tr>

			<tr>
				<td><label> ZipCode *</label></td>
				<td><input type="text" name="zipcode" maxlength="6" required></td>

			</tr>
			<tr>
				<td><label>Status *</label></td>
				<td><input type="radio" required name="status" value="Y">Active
					<input type="radio" required name="status" value="N">InActive</td>
			</tr>
				
			<tr>
				<td><button type="submit">Add</button></td>
				<td><button type="reset">Reset</button></td>
				<td><button type="button"
						onclick="window.location.href='home-page.jsp'">Cancel</button></td>
			</tr>

		</table>


	</form>
</body>
</html>