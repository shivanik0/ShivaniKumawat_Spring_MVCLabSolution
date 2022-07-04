<%@ page language="java" contentType="text/html; charset="ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
            "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equi="Content-Type" content="text/html; charset="ISO-8859-1">
<title></title>
</head>
<body>
	<div>
		<h1>Welcome to Debate Event</h1>
		<form action="/student-details/Student/new-student">
			<input type="hidden" name="id" placeholder="StudentId" />
			<br> 
			<input type="text" name="name" placeholder="Name" />
			<br> 
			<input
				type="text" name="department" placeholder="Department" />
			<br>
			<input type="text" name="country" placeholder="Country" />
			<br>
			<input type="submit" name="s" value="Save" />
		</form>
	</div>
</body>
</html>