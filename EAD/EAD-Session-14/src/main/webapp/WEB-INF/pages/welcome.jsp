<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body>
	<div align="center">
		${welcomeMessage} </br>${msg} </br> </br> <a class="btn btn-primary" href="/getUser">Get
			User Detail</a> </br> </br> <a class="btn btn-primary" href="/updateUser">Update
			User Detail</a></br> </br> <a class="btn btn-primary" href="/getAdmin">Get
			Admin Detail</a> </br> </br> <a class="btn btn-primary" href="/updateAdmin">Update
			Admin Detail</a><br>
		<form action="/logout">
			<input type="submit" value="logout">
		</form>
	</div>
</body>
</html>