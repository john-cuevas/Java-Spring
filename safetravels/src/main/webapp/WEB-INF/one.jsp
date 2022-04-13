<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>One Expense</title>
</head>
<body>
	<div class = "card m-5">
		<h1>Expense Details</h1>
		<p><a href="/expenses">Go Back</a></p>
		<p>Expense Name: ${expense.name}  </p>
		<p>Expense Description: ${expense.description}  </p>
		<p>Vendor: ${expense.vendor}  </p>
		<p>Amount Spent: ${expense.amount}  </p>
	</div>
	

</body>
</html>