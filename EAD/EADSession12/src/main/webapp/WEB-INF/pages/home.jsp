<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a{
	text-decoration: none;
	font-size: 20px;
	color:black;
}

div div{
width:50%;
padding: 1% 1% 1% 1%;
height:50%;
background-color:white;
margin: 5% 25% 5% 25%;
border-radius: 5px;
}
#main{
background-color: orange;
opacity:0.5;
margin: 27%  27%  27%  27%;
padding: 2% 2% 2% 2%;
width:40%;
border-radius: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body align="center" >
	<h2 align="center">${welcomeMessage}</h2>
	<h4 align="center">${msg}</h4>
	<div class="container" style="margin-top: 60px" id="main">
		<div >
			<a href="/addStudent" id="stuDetail">Add student Detail</a>
		</div>
		<br>
		<br>
		<div>
			<a href="/showStudent" id="showStudents">Show All Students</a>
		</div>
		<br>
		<br>
		<div>
			<a href="/searchStudent" id="searchStudent">Search Student</a>
		</div>
		<br>
		<br>
	</div>
</body>
</html>