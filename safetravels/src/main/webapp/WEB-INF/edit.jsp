<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Edit Expense</title>
</head>
<body>

	<div class = "m-5">
		<h1>Edit expense:</h1>
		<form:form class="form" action="/expenses/${id}/edit" method="post" modelAttribute = "expense">
			<input type="hidden" name="_method" value="put">
			<div class = "form-group mb-2">
				<form:label path = "name">Expense Name:</form:label>
				<form:errors path = "name" class = "text-danger"/>
				<form:input type="text"
					path="name" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<form:label path = "vendor">Vendor:</form:label>
				<form:errors path = "vendor" class = "text-danger"/>
				<form:input type="text"
					path="vendor" class = "form-control" />
			</div>
			<div class = "form-group mb-2">
				<form:label path = "description">Description:</form:label>
				<form:errors path = "description" class = "text-danger"/>
				<form:textarea class = "form-control" path = "description"></form:textarea>
			</div>
			<div class = "form-group mb-2">
				<form:label path = "amount">Amount:</form:label>
				<form:errors path = "amount" class = "text-danger"/>
				<form:input type="number" step = "0.01"
					path="amount" class = "form-control" />
			</div>

			<button class = "btn btn-primary">Update</button>
		</form:form>
	</div>

</body>
</html>