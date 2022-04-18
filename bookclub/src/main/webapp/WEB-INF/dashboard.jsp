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
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div>
		<div class="m-2">
			<h1>Welcome ${username }!</h1>
			<p>Books from everyone's shelves.</p>
			<a href="/books/new"> New Book</a> <a href="/logout"> Logout</a>
		</div>
		<div class="m-2">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
						<!-- <th>Actions</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.id }</td>
							<td><a href="/books/${book.id}">${book.title}</a></td>
							<td>${book.authorName}</td>
							<td>${book.reader.userName}</td>

							<%-- <c:choose>

								<c:when test="${book.reader.id == userId }">
									<td><a href="/books/${book.id}/edit"><button>Edit</button></a>
										<form action="/books/${book.id}" method="post">
											<input type="hidden" name="_method" value="delete">
											<button class="btn btn-danger">Delete</button>
										</form>
									</td>

								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose> --%>

						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	   
</body>
</html>

