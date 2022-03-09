<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Index</title>
</head>
<body>
	<h1>Bienvenue</h1>
	<ul>
		<c:forEach items="${requestScope.list}" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
</body>
</html>