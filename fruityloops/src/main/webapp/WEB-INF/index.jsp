<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<div class = "container mt-5">
		<h1>Fruit Store</h1>
		<table class = "table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "fruit" items = "${fruits}">
					<tr>
						<td> ${fruit.getName() } </td>
						<td> ${fruit.getPrice() } </td>
						<!-- fruit.name also works -->
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>