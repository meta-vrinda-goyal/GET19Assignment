<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css"> 
  <title>Add User Details</title>
</head>
<body align="center">
  <%-- <c:if test="${not empty msg}">
  <div align="center"  class="alert alert-danger alert-dismissible" role="alert" style="width: 28%; margin-left: 35%"> --%>
  <strong>${msg}</strong>
  <%-- </div>
  </c:if> --%>
  <h3 align="center">${welcomeMessage}</h3>
  <div class="container" style="margin-top: 60px;margin-left: 32%;margin-right: 32%;" >
    <form:form modelAttribute="user" method="POST" >
	<%-- <form:errors path="pass" cssClass="text-danger"/> --%>
		<form:errors cssClass="text-danger" />
			<div class="form-group">
				<form:label path="firstName">FIRST NAME</form:label>
				<form:input  cssClass="form-control col-lg-6" id="firstName"
					path="firstName" placeholder="Enter First Name" />
				 <form:errors path="firstName" cssClass="text-danger" /> 
			</div>
			<div class="form-group">
				<form:label path="lastName">LAST NAME</form:label>
				<form:input  cssClass="form-control col-lg-6" id="lastName"
					path="lastName" placeholder="Enter Last Name" />
				 <form:errors path="lastName" cssClass="text-danger" /> 
			</div>
			<div class="form-group">
				<form:label path="gender">Gender</form:label>
				<label><form:radiobutton  
					path="gender" value="Female"/>Female</label>
				<label><form:radiobutton 
					path="gender" value="Male" />Male</label>
				 <form:errors path="gender" cssClass="text-danger" /> 
			</div>
			<div class="form-group">
				<form:label path="email">Email address</form:label>
				<form:input type ="email" cssClass="form-control col-lg-6" id="email" path="email" placeholder="Enter email" />
				 <form:errors path="email" cssClass="text-danger" /> 
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input type ="password" cssClass="form-control col-lg-6" id="password" path="password" placeholder="Enter password" />
				 <form:errors path="password" cssClass="text-danger" /> 
			</div>
			<div class="form-group">
				<form:label path="confirmPassword">Confirm Password</form:label>
				<form:input type ="password" cssClass="form-control col-lg-6" id="confirmPassword" path="confirmPassword" placeholder="Enter password" />
				 <form:errors path="confirmPassword" cssClass="text-danger" /> 
			</div>
			  <div class="form-group">
				<form:label path="contactNumber">Contact</form:label>
				<form:input type="number" cssClass="form-control col-lg-6" id="contactNumber" path="contactNumber"
					placeholder="Contact Number" />
				<form:errors path="contactNumber" cssClass="text-danger" />
			</div>  <div class="form-group">
			<form:label path="organization">Organization</form:label>
			<form:select path="organization" cssClass="form-control col-lg-6">
                        <option value="" disabled="disabled" selected="selected">Select Organization</option>
                        <form:option value="Metacube">Metacube</form:option>
                        <form:option value="organization2">organization2</form:option>
                        <form:option value="organization3">organization3</form:option>
                        <form:option value="organization4">organization4</form:option>
                        </form:select><form:errors path="organization" cssClass="text-danger" /></div>
			<button type="submit" class="btn btn-primary">Submit</button> 
		</form:form>
	</div>

	<h3 align="center">Already a member ? <a href="/login">LogIn</a></h3>
</body>
</html>