<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			<th>Emp Reg Id</th>
			<th>Name</th>
		</tr>
		<%
			ResultSet resultSet = (ResultSet) request
					.getAttribute("friendList");
			while (resultSet.next()) {
		%>
		<tr>
			<form action="ShowFriendProfileServlet" method="get">
			<td><input name="friendRegId" type="text" size="1%"
				value="<%=resultSet.getInt(1)%>" readonly></td>
			<td><input name = "firstName" value = '<%=resultSet.getString(2)%>' ></td>
			<td><input type="submit" value="View Profile"></td>
			</form>
		</tr>
		<%
			}
		%>
	</table>

<%-- 
	<%
		if (request.getAttribute("list") != null) {
			ArrayList itemsArray = (ArrayList) request.getAttribute("list");
			ArrayList regId = (ArrayList) request.getAttribute("regId");
			for (int i = 0; i < itemsArray.size(); i++) {
	%> 
	<form action='ShowFriendProfileServlet'>
		<input type='submit' name='friendRegId' value="<%=regId.get(i)%>">
		<input type='text' name='friendName' value="<%=itemsArray.get(i)%>">
	</form> 

	 <%
			}
		} 
		else {

			out.println("No Friends yet");

		}
	%>  --%>
</body>
</html>