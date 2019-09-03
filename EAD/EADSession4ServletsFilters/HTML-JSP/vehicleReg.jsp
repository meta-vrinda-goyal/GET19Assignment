<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Registration Page</title>
</head>
<body align="center">
	Congratulation!! Your Registration is complete Your Employee RegId is <%= request.getAttribute("regId") %>
	<form action="RegisterVehicleServlet" method="GET">
		<h1>Add Your Vehicle</h1>
		<table align="center" style="text-align: left" cellpadding="10">
			<tr>
				<td><label>VEHICLE NAME</label></td>
				<td><input name="vehicle_name" type="text" placeholder="vehicle_name"
					size="60%" pattern="[A-Z a-z]*" required></td>
			</tr>
			<tr>
				<td><label>VEHICLE TYPE</label></td>
				<td><select name="vehicle_type">
						<option disabled selected>--Select-Type--</option>
						<option value="Cycle">Cycle</option>
						<option value="MotorCycle">MotorCycle</option>
						<option value="Four Wheelers">Four Wheelers</option>
				</select></td>
			</tr>
			<tr>
				<td><label>VEHICLE NUMBER</label></td>
				<td><input name="vehicle_number" type="text"
					placeholder="Vehicle Number" size="60%" required  ></td>
			</tr>
			<tr>
				<td><label>EMPLOYEE ID</label></td>
				<td><input name="emp_Id" type="text" size="60%"  ></td>
			</tr>
			<tr>
				<td><label>IDENTIFICATION</label></td>
				<td><textarea name="Identification"
						placeholder="Identification" cols="60"></textarea></td>
			</tr>
		</table>
		<input name="addVehicleButton" type="submit" value="Add">
	</form>
</body>
</html>
