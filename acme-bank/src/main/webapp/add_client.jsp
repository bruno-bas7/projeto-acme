<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h2>Register</h2>
		<br/>
		<form action="clientServlet" method="POST">
			<label for="name">Name</label>
			<input id="name" name="name" type="text" placeholder="your name" >
			<br/>
			<br/>
			<label for="email">E-mail</label>
			<input id="email" name="email" type="email" placeholder="your email" >
			<br/>
			<br/>
			<label for="phone">Phone</label>
			<input id="phone" name="phone" type="text" placeholder="your phone" >
			<br/>
			<br/>
			<input type="submit" value="Add" id="btn-Login">
		</form>
		<br/>
		<br/>
		
		<h2>User's List</h2>
		<form action="listServlet" method="GET">
			<button>List users</button>
		</form>
		
		<br/>
		<br/>
		<form action="deleteServlet" method="POST">
			<label for="id">ID</label>
			<input id="id" name="id" type="text" placeholder="ID for delete" >
			<br/>
			<br/>
			<input type="submit" value="delete" id="btn-delete">
		</form>
	</div>	
</body>
</html>