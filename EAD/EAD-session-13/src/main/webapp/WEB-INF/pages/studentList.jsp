<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Students List</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped" border="1">
			<tr>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>FATHER'S NAME</th>
				<th>EMAIL</th>
				<th>CLASS</th>
				<th>AGE</th>
			</tr>
			<c:forEach var="listValue" items="${studentList}">
				<tr>
					<td>${listValue.firstName}</td>
					<td>${listValue.lastName}</td>
					<td>${listValue.fatherName}</td>
					<td>${listValue.email}</td>
					<td>${listValue.std}</td>
					<td>${listValue.age}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>