<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Baby</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="m-2">
		<h1>Add a name!</h1>
		<form:form class="form" action="/names/new" method="post"
			modelAttribute="baby">
			<form:hidden path="creator" value="${userId}" />
			<div class="form-group mb-2">
				<form:label path="babyName">New Name:</form:label>
				<form:errors path="babyName" class="text-danger" />
				<form:input type="text" path="babyName" class="form-control" />
			</div>
			<div class="form-group mb-2">
				<form:label path="gender">Typical Gender:</form:label>
				<form:select path = "gender" class = "form-select">
					<form:option value="Neutral">Neutral</form:option>
					<form:option value="Male">Male</form:option>
					<form:option value="Female">Female</form:option>
				</form:select>
			</div>
			<div class="form-group mb-2">
				<form:label path="origin">Origin:</form:label>
				<form:errors path="origin" class="text-danger" />
				<form:input type="text" path="origin" class="form-control" />
			</div>
			<div class="form-group mb-2">
				<form:label path="meaning">Meaning:</form:label>
				<form:errors path="meaning" class="text-danger" />
				<form:textarea path="meaning" class="form-control" />
			</div>
			
			<button class = "btn btn-primary">Submit</button>


		</form:form>
		<a href="/dashboard" class="btn btn-secondary"> Cancel</a>
	</div>
	   
</body>
</html>

