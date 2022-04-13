<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Expenses</title>
</head>
<body>
	<div class = "m-5">
		<h1>Safe Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${expense.id}">${expense.name}</a></td>
						<td>${expense.vendor}</td>
						<td>${expense.amount}</td>
						<td><a href="/expenses/${expense.id}/edit"><button>Edit</button></a>
							<form action="/expenses/${expense.id}" method = "post">
								<input type="hidden" name="_method" value="delete"> 
								<button class = "btn btn-danger">Delete</button>
							</form> 
					</tr>

				</c:forEach>
			</tbody>
		</table>


	</div>

</body>
</html>