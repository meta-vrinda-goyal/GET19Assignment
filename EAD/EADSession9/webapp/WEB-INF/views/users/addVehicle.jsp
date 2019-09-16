<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Register Vehicle</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<div align="center" class="alert alert-danger alert-dismissible"
			role="alert" style="width: 28%; margin-left: 35%">
			<strong>${msg}</strong>
		</div>
	</c:if>
	<h4 align="center">Congrats Your RegId is ${regId}</h4>
	<h3 align="center">ADD VEHICLE</h3>

	<div class="container"
		style="margin-top: 60px; margin-left: 32%; margin-right: 32%;">
		<form:form modelAttribute="vehicle">
            <form:errors cssClass="text-danger" />
			<div class="form-group">
				<form:label path="regId">REG ID</form:label>
				<form:input cssClass="form-control col-lg-6" id="regId" path="regId"
					value="${regId}" readonly="true" />
         	</div>
			<div class="form-group">
				<form:label path="vehicleName">VEHICLE NAME</form:label>
				<form:input cssClass="form-control col-lg-6" id="vehicleName"
					path="vehicleName" placeholder="Enter vehicle name" />
				<form:errors path="vehicleName" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="vehicleNumber">VEHICLE NUMBER</form:label>
				<form:input cssClass="form-control col-lg-6" id="vehicleName"
					path="vehicleNumber" placeholder="Enter vehicle number" />
				<form:errors path="vehicleNumber" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="vehicleType">VEHICLE TYPE</form:label>
				<form:select path="vehicleType" cssClass="form-control col-lg-6">
					<option value="" disabled="disabled" selected="selected">Select vehicle type</option>
					<form:option value="Cycle">Cycle</form:option>
					<form:option value="MotorCycle">MotorCycle</form:option>
					<form:option value="Four Wheelers">Four Wheeler</form:option>

				</form:select>
				<form:errors path="vehicleType" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="identification">IDENTIFICATION</form:label>
				<form:input cssClass="form-control col-lg-6" id="identification"
					path="identification" placeholder="Enter vehicle identification" />
			</div>
			<button type="submit" class="btn btn-primary">ADD VEHICLE</button>
		</form:form>
</body>
</html>