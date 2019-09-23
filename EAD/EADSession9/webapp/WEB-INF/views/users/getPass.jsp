<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/script.js"></script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Get Pass</title>
<style type="text/css">
.table {
    width: 25%;
    margin-bottom: 1rem;
    color: #212529;
}
</style>
</head>
<body align="center">
	<div class="container"
		style="margin-top: 60px; margin-left: 32%; margin-right: 32%;">		
		<form:form modelAttribute="pass">
			<form:input cssClass="form-control col-lg-6" id="regId" name = "regId" path="regId"
				value="${regId}" style="visibility: hidden"  />
			<div class="form-group">
				<input type="button" value="Click here to Get Price Details"
					id="getPrice" onclick="registerVehicle('${vehicleType}')" />
			</div>
			<div class="form-group">
				<table border="5px" align="center" id="table"
					class="table table-striped">
					<tr>
						<th>Plan</th>
						<th>Price in INR</th>
					</tr>
					<tr>
						<td>Daily</td>
						<td id="DailyPrice"></td>
					</tr>
					<tr>
						<td>Monthly</td>
						<td id="MonthlyPrice"></td>
					</tr>
					<tr>
						<td>Yearly</td>
						<td id="YearlyPrice"></td>
					</tr>
				</table>
				<br> <br>
			</div>
			<div class="form-group">
				<select id="priceType" onchange="changeCurrency(priceType.value)">
					<option disabled selected>--Choose desired currency--</option>
					<option>INR</option>
					<option>USD</option>
					<option>YEN</option>
					</option>
				</select> <br> <br> <label><form:radiobutton  id="pricePlan"
						path="pricePlan" value="Daily"
						onchange="getPriceFunction(this.value)" />Daily</label> 
						<label><form:radiobutton
						id="pricePlan" path="pricePlan" value="Monthly"
						onchange="getPriceFunction(this.value)" />Monthly</label>
						 <label><form:radiobutton 
						id="pricePlan" path="pricePlan" value="Yearly"
						onchange="getPriceFunction(this.value)"/>Yearly</label> <br>
				<br> <input type="button" value="getPass" id="getPass"
					onclick="getPassFunction()"> 
					<br> <br> <label>Your price is</label> 
					<input type="text" name="price" id="price" size="5%" />
				<form:input type="text" path="priceInINR" id="priceInINR"
					style="visibility: hidden;" />
				
				<br> <br> 
				<input type="submit" value="submit" id="submit">
		</form:form>
	</div>

</body>
</html>