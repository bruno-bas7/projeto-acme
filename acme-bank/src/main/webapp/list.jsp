<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User's List</title>
</head>
<body>
	<div align="center">

		<table>
		<h2>USER'S LIST</h2>
		<tr>
			<td style="height:40px; width:40px; margin:0;"><b>ID</b></td>
			<td style="height:40px; width:40px; margin:0;"><b>Name</b></td>
			<td style="height:40px; width:40px; margin:0;"><b>Phone</b></td>
			<td style="height:40px; width:40px; margin:0;"><b>Email</b></td>
		</tr>
		
		<c:forEach var="client" items="${clients}">
			<tr>
				<td>${client.id}</td>
				<td>${client.name}</td>
				<td>${client.phone}</td>
				<td>${client.email}</td>
			</tr>
			
		
		</c:forEach>
		</table>
		</br>
		<a href="add_client.jsp"><button type="button">Back</button></a>
	
	</div>

</body>
</html>