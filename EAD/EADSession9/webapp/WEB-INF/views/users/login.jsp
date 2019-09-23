<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Log In</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<div align="center" class="alert alert-danger alert-dismissible" role="alert" style="width: 28%; margin-left: 35%">
			<strong>${msg}</strong>
		</div>
	</c:if>
	<h1 align="center">${welcomeMessage}</h1>
	<h5 align="center">${msgLogout}</h5>
	<div class="container">
		<form:form modelAttribute="login">
			<%-- <form:errors cssClass="text-danger" /> --%>
			<div class="form-group">
				<form:label path="email">EMAIL ADDRESS</form:label>
				<form:input path="email" type="email" cssClass="form-control" placeholder="Enter email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password">PASSWORD</form:label>
				<form:input path="password" type="Password" cssClass="form-control" placeholder="Password" />
				<form:errors path="password" cssClass="text-danger" />
			</div>
			<button type="submit" class="btn btn-primary">LogIn</button>
		</form:form>
	</div>
	<h3 align="center">
		New Registered yet ? <a href="/registration">Register</a>
	</h3>
</body>
</html>