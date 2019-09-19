<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Search Student</title>
</head>
<body>

	<%-- <div align="center">
		<h3>Search Student By Class</h3>
	</div>
	<div class="card-body">
		<div class="container">
			<form:form modelAttribute="std" action="studentByClass" method="POST">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="std">Class</form:label>
					<form:input path="std" type="number" cssClass="form-control"
						placeholder="Class" />
					<form:errors path="std" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Search</button>
			</form:form>
		</div>
	</div> --%>
	<div align="center" >
		<h3>Search Student By Name</h3>
	</div>
	<div class="card-body">
		<div class="container">
			<form:form modelAttribute="name" action="studentByName" method="POST">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName" type="text" cssClass="form-control"
						placeholder="First Name" />
					<form:errors path="firstName" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Search</button>
			</form:form>
		</div>
	</div>

</body>
</html>