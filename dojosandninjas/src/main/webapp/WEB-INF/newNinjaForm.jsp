<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class = "m-5">
		<h1>New ninja:</h1>
		<form:form class="form" action="/ninjas/new" method="post" modelAttribute = "ninja">
			<div class = "form-group mb-2">
				<form:label path = "dojo">Dojo:</form:label>
				<form:select path = "dojo" class ="form-select">
					<c:forEach var = "dojoname" items = "${dojos}">
						<form:option value ="${dojoname.id}">${dojoname.name}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class = "form-group mb-2">
				<form:label path = "firstName">First Name:</form:label>
				<form:errors path = "firstName" class = "text-danger"/>
				<form:input type="text"
					path="firstName" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<form:label path = "lastName">Last Name:</form:label>
				<form:errors path = "lastName" class = "text-danger"/>
				<form:input type="text"
					path="lastName" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<form:label path = "age">Age:</form:label>
				<form:errors path = "age" class = "text-danger"/>
				<form:input type="number"
					path="age" class = "form-control" />
			</div>
			


			<button class = "btn btn-primary">Create</button>
		</form:form>
	</div>
	   
</body>
</html>

