<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer Name: <c:out value="${jspName}"></c:out> </h1>
	<h3> Item Name: <c:out value="${jspItemName }"></c:out> </h3>
	<h3> Price: <c:out value="${jspPrice }"></c:out> </h3>
	<h3> Description: <c:out value="${jspDescription }"></c:out> </h3>
	<h3> Vendor: <c:out value="${jspVendor }"></c:out> </h3>
	

</body>
</html>