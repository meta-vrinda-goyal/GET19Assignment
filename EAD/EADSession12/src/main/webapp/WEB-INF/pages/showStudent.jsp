<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Students</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body>
	<h3 align="center">Students details are :</h3>
	<div class="container" align="center" style="margin-top: 60px">
		<table class="table table-striped" border="1">
			<tr>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>FATHER'S NAME</th>
				<th>EMAIL</th>
				<th>CLASS</th>
				<th>AGE</th>
			</tr>

			<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.fatherName}</td>
					<td>${student.email}</td>
					<td>${student.std}</td>
					<td>${student.age}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>