<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sport</title>
</head>
<body>
	<h1>Choix du sport : </h1>
	<form action="podium" method="get">
		<label for="sport">Choisir un sport :</label>
		<br />
		<select id="sport" name="sport">
			<c:forEach items="${requestScope.dataSports}" var="sport">
				<option value="${sport.id}">${sport.nom}</option>
			</c:forEach>
		</select>
		<br />
		<button type="submit">Afficher le podium</button>
	</form>
	
</body>
</html>