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
<title>One Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="m-2">
		<h1>${book.title}</h1>

		<c:choose>
			<c:when test="${book.reader.id == userId }">
				<h3>You read ${book.title} by ${book.authorName }</h3>
				<h3>Here are your thoughts</h3>
			</c:when>
			<c:otherwise>
				<h3>${book.reader.userName}read${book.title} by
					${book.authorName }</h3>
				<h3>Here are ${book.reader.userName}'s thoughts</h3>

			</c:otherwise>
		</c:choose>

		<p>${book.thoughts}</p>
		<a href="/dashboard"> Back to the Shelves</a>

		<c:choose>

			<c:when test="${book.reader.id == userId }">
				<a href="/books/${book.id}/edit"><button>Edit</button></a>
				<form action="/books/${book.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<button class="btn btn-danger">Delete</button>
				</form>

			</c:when>
			<c:otherwise>
				<p></p>
			</c:otherwise>
		</c:choose>

		<!-- BOTH WORK -->
		<%-- <c:if test="${book.reader.id == userId }">
			<a href="/books/${book.id}/edit"><button>Edit</button></a>
			<form action="/books/${book.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<button class="btn btn-danger">Delete</button>
			</form>
		</c:if>
 --%>

	</div>
	   
</body>
</html>

