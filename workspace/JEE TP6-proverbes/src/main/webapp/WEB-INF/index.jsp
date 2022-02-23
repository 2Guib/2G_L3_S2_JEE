<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Proverbes</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
	<jsp:useBean id="userBean" class="bean.Utilisateur" scope="request"/>
	<h1>Bienvenue</h1>
	<form action="/JEE_TP6-proverbes/proverbe" method="post">
		<label for="name">Nom</label>
		<% 
			if (userBean != null && userBean.getNom() != null) {
				out.println("<p>"+userBean.getNom()+"</p>");
			} else {
				out.println("<input id=\"name\" type=\"text\" name=\"name\">");
			}
		%>
		
		<br />
		<label for="number">Numero</label>
		<input id="number" type="text" name="number">
		<br />
		<button type="submit">Envoyer</button>
	</form>
		
	<form action="/JEE_TP6-proverbes/logout" method="post">
		<% 
			if (userBean != null && userBean.getNom() != null) {
				out.println("<button type=\"submit\">LogOut</button>");
			}
		%>
	</form>
</body>
</html>