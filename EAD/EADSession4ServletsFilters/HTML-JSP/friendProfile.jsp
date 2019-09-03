<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Profile Page</title>
</head>
<body>
	<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			<th>Emp Reg Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>gender</th>
			<th>email</th>
			<th>contact</th>
			<th>organization</th>

		</tr>
		<%
			ResultSet resultSet = (ResultSet) request.getAttribute("friendList");
			while (resultSet.next()) {
		%>
		<tr>

			
			<td><%=resultSet.getInt(1)%></td>
			<td><%=resultSet.getString(2)%></td>
			<td><%=resultSet.getString(3)%></td>
			<td><%=resultSet.getString(4)%></td>
			<td><%=resultSet.getString(5)%></td>
			<td><%=resultSet.getString(6)%></td>
			<td><%=resultSet.getString(7)%></td>


			

		</tr>
		<%
			}
		%>
	</table>

</body>
</html>