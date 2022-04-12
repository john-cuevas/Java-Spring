<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<meta charset="UTF-8">
<title>Omikuji Form</title>
</head>
<body>
	<div class = "m-5">
		<h1>Send an Omikuji!</h1>
		<form class="form" action="/processForm" method="post">
			<div class = "form-group mb-2">
				<label>Pick any number from 5 to 25:</label> <input type="number"
					name="number" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<label>Enter the name of any city:</label> <input type="text"
					name="city" class = "form-control"/>
			</div>
			<div class = "form-group mb-2">
				<label>Enter the name of any real person:</label> <input type="text"
					name="person" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<label>Enter professional endeavor or hobby:</label> <input type="text"
					name="hobby" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<label>Enter any type of living thing:</label> <input type="text"
					name="living" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<label>Say something nice to someone:</label> <textarea class = "form-control" name = "comment"></textarea>
			</div>
			<p> Send and show a friend </p>
			<button class = "btn btn-primary">Send</button>
		</form>
	</div>
</body>
</html>