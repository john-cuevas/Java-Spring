<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Ninja Gold</title>
</head>
<body>
	<div class = "m-5">
		<div>
			<h2>Gold: ${gold}</h2>
		</div>
		<div class = "d-flex flex-direction:column ">
			<div class = "card ">
				<form class = "form" action = "/gold" method = "post">
					<h3> Farm</h3>
					<p>(earns 10-20 gold)</p>
					<input type = "submit" name = "farm" value ="Find Gold!"/>
				</form>
			</div>
			<div class = "card ">
				<form class = "form" action = "/gold" method = "post">
					<h3> Cave</h3>
					<p>(earns 5-10 gold)</p>
					<input type = "submit" name = "cave" value ="Find Gold!"/>
				</form>
			</div>
			<div class = "card ">
				<form class = "form" action = "/gold" method = "post">
					<h3> House</h3>
					<p>(earns 2-5 gold)</p>
					<input type = "submit" name = "house" value ="Find Gold!"/>
				</form>
			</div>
			<div class = "card ">
				<form class = "form" action = "/gold" method = "post">
					<h3> Quest</h3>
					<p>(earns or loses 0-50 gold)</p>
					<input type = "submit" name = "quest" value ="Find Gold!"/>
				</form>
			</div>
			<div class = "card ">
				<form class = "form" action = "/gold" method = "post">
					<h3> Spa</h3>
					<p>(loses 5-20 gold)</p>
					<input type = "submit" name = "spa" value ="Find Gold!"/>
				</form>
			</div>
		</div>
		<div>
			<h3>Activities:</h3>
				<c:forEach var ="action" items = "${actions}">
					<c:if test = "${action.contains('earned') }">
						<p class = "text-success">${action}</p>
					</c:if>
					<c:if test = "${action.contains('lost') }">
						<p class = "text-danger">${action}</p>
					</c:if>
				</c:forEach>
			
		</div>
		<div>
			<form class = "form" action = "/reset" method = "post">
					<input type = "submit" name = "reset" value ="Reset"/>
			</form>
		
		</div>
		
	</div>

</body>
</html>