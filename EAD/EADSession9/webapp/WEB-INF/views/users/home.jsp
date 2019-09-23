<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript">
	function editDetail() {
		
		document.getElementById("firstName").readOnly = false;
		document.getElementById("lastName").readOnly = false;
		document.getElementById("gender").readOnly = false;
		document.getElementById("contactNumber").readOnly = false;
		document.getElementById("vehicleName").readOnly = false;
		document.getElementById("vehicleNumber").readOnly = false;
		document.getElementById("identification").readOnly = false;

		var bt = document.getElementById('saveButton');
		bt.disabled = false;
	}

	function showname() {

		var name = document.getElementById('fileInput');
		var file = "/images/" + name.files.item(0).name;
		//alert(file);
		document.getElementById("myImg").src = file + "";
	};
</script>
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

li a :hover :not (.active ){
	background-color: black;
}

.active {
	background-color: black;
}

.image-upload>input {
	display: none;
}
</style>

<link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body align="center">
	<ul>
		<form action="/friend">
			<input type="submit" value="friends" size="100%" class="new">
			<input type="text" name="empOrganization" id="empOrganization" value="${emp.organization}" style="display: none;"> 
			<input type="text" name="empRegId" id="empRegId" value="${emp.regId}" style="display: none;">
  	    </form>
		<form action="/logout" method="get">
			<input type="submit" value="log Out" size="100%" class="new">
			<input type="text" name="empRegId" id="empRegId" value="${emp.regId}" style="display: none;">
		</form>
	</ul>

	<div align="right" class="image-upload">
		<span style="font-weight: bold; font-size: 30px;">Welcome</span> 
		<label for="fileInput"> 
			<img id="myImg" style="height: 70px" alt="no image" src="/images/vrinda.jpg" />
		</label> 
		<input type="file" name="file" value="fileupload" id="fileInput" onchange="showname()"> 
		<span style="font-weight: bold; font-size: 30px;">${emp.firstName}</span>
	</div>

	<h3 style="margin-top: 5%; font-weight: bold" align="center">Details are :</h3>
	<br>
	<br>
    <form action="/update" method="POST">
		<table border='1' align="center">
			<tr>
				<th>regId</th>
				<td><input type="text" name="regId" value='${emp.regId}' readonly></td>
			</tr>
			<tr>
				<th>First Name</th>
				<td><input type="text" id="firstName" name="firstName" value='${emp.firstName}' pattern="[A-Z a-z]{2,20}"
					required="required" title="Name should be alphabetic with minimum 2 charaters and maximimum 20" readonly></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" id="lastName" name="lastName"
					value='${emp.lastName}' pattern="[A-Z a-z]{2,20}"
					title="Name should be alphabetic with minimum 2 charaters and maximimum 20"
					readonly></td>
			</tr>

			<tr>
				<th>Gender</th>
				<td><input type="text" id="gender" name="gender"
					pattern="^FEMALE$|^MALE$"
					title="Gender should be MALE OR FEMALE only" maxlength="6"
					style="text-transform: uppercase" value='${emp.gender}' readonly></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type="text" name="email" value='${emp.email}'
					readonly></td>
			</tr>
			<tr>
				<th>contact</th>
				<td><input type="text" name="contactNumber" id="contactNumber"
					value='${emp.contactNumber}' pattern="[0-9]{8,10}"
					required="required"
					title="contact should be numeric and of minimum length 8 and maximum 10 "
					readonly></td>
			</tr>
			<tr>
				<th>organization</th>
				<td><input type="text" name="organization" id="organization"
					value='${emp.organization}' readonly></td>
			</tr>
			<tr>
				<th>vehicle_name</th>
				<td><input type="text" name="vehicleName" id="vehicleName"
					pattern="[a-z A-Z 0-9]{2,20}"
					title="Vehicle name should be of minimum length 2 and maximum 20"
					value='${emp.vehicleName}' readonly></td>
			</tr>
			<tr>
				<th>vehicle_type</th>
				<td><input type="text" name="vehicleType" id="vehicleType"
					value='${emp.vehicleType}' readonly></td>
			</tr>
			<tr>
				<th>vehicle_number</th>
				<td><input type="text" name="vehicleNumber" id="vehicleNumber"
					required="required" pattern="[a-z A-Z 0-9]{1,20}"
					value='${emp.vehicleNumber}' readonly></td>
			</tr>
			<tr>
				<th>Identification</th>
				<td><input type="text" name="identification"
					id="identification" value='${emp.identification}' readonly></td>
			</tr>
			<tr>
				<th>plan</th>
				<td><input type="text" name="plan" value='${emp.plan}' readonly></td>
			</tr>
			<tr>
				<th>price</th>
				<td><input type="text" name="price" value='${emp.price}'
					readonly></td>
			</tr>


		</table>
		<div align="center">
			</br> <input type="button" id="editButton" name="editButton" value="Edit"
				onclick="editDetail()" class="btn btn-primary"> <input
				type="submit" id="saveButton" name="saveButton" value="Save"
				class="btn btn-primary" disabled="disabled">
		</div>
	</form>

</body>
</html>