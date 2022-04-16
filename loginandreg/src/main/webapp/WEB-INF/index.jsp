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
<title>Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="m-2">
		<h1>Welcome!</h1>
		<h4>Join our growing community.</h4>
		<div class = "d-flex justify-content-around">
			<div class ="w-50">
				<h3>Register</h3>
				<form:form class="form" action="/register" method="post"
					modelAttribute="newUser">
					<div class="form-group mb-2">
						<form:label path="userName">User Name:</form:label>
						<form:errors path="userName" class="text-danger" />
						<form:input type="text" path="userName" class="form-control" />
					</div>
					<div class="form-group mb-2">
						<form:label path="email">Email:</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input type="text" path="email" class="form-control" />
					</div>
					<div class="form-group mb-2">
						<form:label path="password">Password:</form:label>
						<form:errors path="password" class="text-danger" />
						<form:password path="password" class="form-control" />

					</div>
					<div class="form-group mb-2">
						<form:label path="confirm">Confirm Password:</form:label>
						<form:errors path="confirm" class="text-danger" />
						<form:password path="confirm" class="form-control" />
					</div>

					<button class="btn btn-primary">Submit</button>
				</form:form>
			</div>
			<div class = "w-25">
				<h3>Log in</h3>
				<form:form class="form" action="/login" method="post"
					modelAttribute="newLogin">
					<div class="form-group mb-2">
						<form:label path="email">Email:</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input type="text" path="email" class="form-control" />
					</div>
					<div class="form-group mb-2">
						<form:label path="password">Password:</form:label>
						<form:errors path="password" class="text-danger" />
						<form:password path="password" class="form-control" />
					</div>

					<button class="btn btn-primary">Submit</button>
				</form:form>
			</div>

		</div>
	</div>
	   
</body>
</html>

