<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>LOGIN FORM</title>

<link rel="stylesheet" type="text/css" href="CSS/login1.css">
<link rel="icon" href="images/logo.jpg">
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

form {
    width: 300px;
    margin: 50px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
    width: 100%;
}

td {
    padding: 10px;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
    margin-bottom: 10px;
}

input[type="submit"] {
    background-color: #4caf50;
    color: #fff;
    padding: 10px 15px;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}
</style>
</head>
<body>


	<form action="login" method="post">
	<c:if test="${error != null}">
				<span style=color:red>Please enter the valid credentials!</span>
			</c:if>
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="user" required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" required="required"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form>


</body>
</html>