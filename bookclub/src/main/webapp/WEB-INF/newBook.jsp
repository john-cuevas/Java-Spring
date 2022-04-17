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
<title>New Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="m-2">
		<h1>New Book:</h1>
		<a href="/dashboard"> Back to the Shelves</a>
		<form:form class="form" action="/books/new" method="post"
			modelAttribute="book">
			<form:hidden path="reader" value="${userId}" />
			<div class="form-group mb-2">
				<form:label path="title">Title:</form:label>
				<form:errors path="title" class="text-danger" />
				<form:input type="text" path="title" class="form-control" />
			</div>
			<div class="form-group mb-2">
				<form:label path="authorName">Author Name:</form:label>
				<form:errors path="authorName" class="text-danger" />
				<form:input type="text" path="authorName" class="form-control" />
			</div>


			<button class="btn btn-primary">Create Book</button>
		</form:form>
	</div>
	   
</body>
</html>

