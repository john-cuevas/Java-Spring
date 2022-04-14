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
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class = "m-5">
		<h1>New Dojo:</h1>
		<form:form class="form" action="/dojos/new" method="post" modelAttribute = "dojo">
			<div class = "form-group mb-2">
				<form:label path = "name">Dojo Name:</form:label>
				<form:errors path = "name" class = "text-danger"/>
				<form:input type="text"
					path="name" class = "form-control" />
			</div>


			<button class = "btn btn-primary">Create</button>
		</form:form>
	</div>
	   
</body>
</html>

