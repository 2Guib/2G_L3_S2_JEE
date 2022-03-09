<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Podium</title>
</head>
<body>
	<h1>Podium pour ${podium.sport.nom}</h1>
	<ul>
		<li>Gold : ${podium.gold}</li>
		<li>Silver : ${podium.silver}</li>
		<li>Bronze : ${podium.bronze}</li>
	</ul>
</body>
</html>