<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher livre</title>
</head>
<body>
	<p>${1+1}</p>
	<ul>
		<c:forEach items="${requestScope.livres}" var="livre">
			<li id="${livre.id}">${livre}</li>
		</c:forEach>
	</ul>
</body>
</html>