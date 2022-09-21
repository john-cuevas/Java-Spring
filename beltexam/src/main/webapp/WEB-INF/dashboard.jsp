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
			<h1>Hello, ${username }. Here are some name suggestions..</h1>
			<a href="/logout"> Logout</a>
		</div>
		<div class="m-2">
			<h3>Baby Names</h3>
			<table class="table">
				<thead>
					<tr>
						<th></th>
						<th>Name</th>
						<th>Gender</th>
						<th>Origin</th>
						<th>Votes</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="name" items="${babyNames}">
						<tr>
							<td><c:choose>
									<c:when test="${name.likedUsers.contains(user)}">
										<form action="/names/${name.id}/unlike" method="post">
											<input type="hidden" name="_method" value="put" />
											<button class="btn btn-danger">Unlike</button>
										</form>
									</c:when>
									<c:otherwise>
										<form action="/names/${name.id}/like" method="post">
											<input type="hidden" name="_method" value="put" />
											<button class="btn btn-primary">Like</button>
										</form>
									</c:otherwise>
								</c:choose></td>


							<td><a href="/names/${name.id}">${name.babyName}</a></td>
							<td>${name.gender}</td>
							<td>${name.origin}</td>
							<td>${name.likedUsers.size() }</td>

						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="/names/new" class="btn btn-secondary"> New Name</a>

	</div>

	   
</body>
</html>

