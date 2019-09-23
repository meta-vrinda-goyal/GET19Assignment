<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends</title>
<style>
input{
	border:none;
}
</style>
</head>
<body>
<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			<th>Emp Reg Id</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach var="listValue" items="${list}">		
		<tr>
			<form action="/friendProfile">
			<td><input name="regId" type="text" size="1%" value="${listValue.regId}" readonly></td>
			<td><input name = "firstName" value = '${listValue.firstName}' readonly ></td>
			<td><input name = "lastName" value = '${listValue.lastName}' readonly ></td>
			<td><input type="submit" value="View Profile"></td>
			</form>
		</tr>
		</c:forEach>
	</table>
</body>
</html>