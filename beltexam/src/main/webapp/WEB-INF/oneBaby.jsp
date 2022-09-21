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
<title>One Baby</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="m-2">
		<h1>${baby.babyName }</h1>
		<h2>(added by ${baby.creator.userName})</h2>
		<h3>Gender: ${baby.gender}</h3>
		<h3>Origin: ${baby.origin}</h3>
		<p>Meaning: ${baby.meaning }</p>
		<a href="/dashboard" class="btn btn-secondary"> Dashboard</a>

		<c:choose>
			<c:when test="${baby.creator.id == userId }">
				<a href="/names/${baby.id}/edit"><button>Edit</button></a>
				<form action="/names/${baby.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<button class="btn btn-danger">Delete</button>
				</form>

			</c:when>
			<c:otherwise>
				<p></p>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${baby.likedUsers.contains(user)}">
				<h3>You voted for this name.</h3>
			</c:when>
			<c:otherwise>
				<form action="/names/${baby.id}/like" method="post">
					<input type="hidden" name="_method" value="put" />
					<button class="btn btn-primary">Like</button>
				</form>
			</c:otherwise>
		</c:choose>

	</div>
	   
</body>
</html>

