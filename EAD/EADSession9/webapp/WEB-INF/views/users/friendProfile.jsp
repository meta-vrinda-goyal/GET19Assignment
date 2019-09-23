<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${profile.firstName} Profile</title>
</head>
<body>
	<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			<th>Reg Id</th>
			<th>Name</th>
			<th>gender</th>
			<th>email</th>
			<th>contact</th>
			<th>Vehicle Name</th>
			<th>Vehicle Number</th>
			<th>Vehicle Type</th>

		</tr>
		<tr>
			<td>${profile.regId}</td>
			<td>${profile.firstName}  ${profile.lastName}</td>
			<td>${profile.gender}</td>
			<td>${profile.email}</td>
			<td>${profile.contact}</td>
			<td>${profile.vehchileName}</td>
			<td>${profile.vehchileNumber}</td>
			<td>${profile.vehchileType}</td>
</body>
</html>