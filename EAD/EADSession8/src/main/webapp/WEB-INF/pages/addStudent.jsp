<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css"> 
    <title>Add Student Details</title>
  </head>
  <body align="center">
	<h3 align="center">Add Students Details</h3>
	<div class="container" style="margin-top: 60px;margin-left: 32%;margin-right: 32%;" >
		<form:form modelAttribute="student" >
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
				<form:label path="fatherName">FATHER'S NAME</form:label>
				<form:input cssClass="form-control col-lg-6" id="fatherName"
					path="fatherName" placeholder="Enter father's Name" />
				 <form:errors path="fatherName" cssClass="text-danger" /> 
			</div>
			<div class="form-group">
				<form:label path="email">Email address</form:label>
				<form:input type ="email" cssClass="form-control col-lg-6" id="email" path="email" placeholder="Enter email" />
				 <form:errors path="email" cssClass="text-danger" /> 
			</div>
			  <div class="form-group">
				<form:label path="std">CLASS</form:label>
				<form:input type="number" cssClass="form-control col-lg-6" id="std" path="std"
					placeholder="Class" />
				<form:errors path="std" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="age">AGE</form:label>
				<form:input type="number" cssClass="form-control col-lg-6" id="age" path="age"
					placeholder="age" />
				<form:errors path="age" cssClass="text-danger" />
			</div> 


			<button type="submit" class="btn btn-primary">Submit</button> 
		</form:form>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="/js/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script> -->
</body>
</html>