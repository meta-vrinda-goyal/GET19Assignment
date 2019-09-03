<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style>
.new {
	background-color: black; /* Green background */
	border: none;
	color: white; /* White text */
	padding: 10px 24px; /* Some padding */
	cursor: pointer; /* Pointer/hand icon */
	float: left; /* Float the buttons side by side */
}

ul {
	list-style-type: none;
	margin: auto;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	border-right: 1px solid #bbb;
}

li:last-child {
	border-right: none;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li
 
a
:hover
:not
(
.active
 
)
{
background-color
:
 
black
;


}
.active {
	background-color: black;
}
</style>
</head>
<body align="center">
	<ul>
		
				<form action="HomeServlet" method="get">
					<input type="submit" value="Home" size="100%" class="new">
					<input type="text" name="regId" id="empRegId"
						value="<%=request.getAttribute("regId")%>" style="display: none;">
						</form>
			<form action="FriendServlet" method="get">
					<input type="submit" value="friends" size="100%" class="new">
					<input type="text" name="empOrganization" id="empOrganization"
						value="<%=request.getAttribute("organization")%>"
						style="display: none;"> <input type="text" name="empRegId"
						id="empRegId" value="<%=request.getAttribute("regId")%>"
						style="display: none;">

			</form>
			<form action="LogoutServlet" method="POST">
					<input type="submit" value="log Out" size="100%" class="new">
				    <input type="text" name="empRegId" id="empRegId" value="<%=request.getAttribute("regId")%>"
						style="display: none;">

			</form>
		
		
	</ul>

	<h3 style="margin-top: 5%; font-weight: bold">Details are :</h3>
	<br>
	<br>
	<form method="get">
		<table border='1' align="center">

			<tr>
				<th>regId</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("regId")%>' readonly></td>
			</tr>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("firstName")%>'></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("lastName")%>'></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("gender")%>'></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("email")%> readonly'></td>
			</tr>
			<tr>
				<th>contact</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("contact")%>'></td>
			</tr>
			<tr>
				<th>organization</th>
				<td><input type="text" name="organization"
					value='<%=request.getAttribute("organization")%>'></td>
			</tr>
			<tr>
				<th>vehicle_name</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("vehicle_name")%>'></td>
			</tr>
			<tr>
				<th>vehicle_type</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("vehicle_type")%>'></td>
			</tr>
			<tr>
				<th>vehicle_number</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("vehicle_number")%>'></td>
			</tr>
			<tr>
				<th>Identification</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("Identification")%>'></td>
			</tr>
			<tr>
				<th>plan</th>
				<td><input type="text" name="regId"
					value='<%=request.getAttribute("plan")%>'></td>
			</tr>
			<tr>
				<th>price</th>
				<td><input type="text" name="regId"
					value='<%= request.getAttribute("price") %>'></td>
			</tr>


		</table>
</body>
</html>