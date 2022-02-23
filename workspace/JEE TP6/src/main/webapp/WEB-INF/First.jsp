<%@page import="difs.bean.Information"%>
<%@page import="difs.bean.Identifiant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Un titre</title>
</head>
<body>
	<jsp:useBean id="idBean" class="difs.bean.Identifiant" scope="session"/>
	<jsp:useBean id="infoBean" class="difs.bean.Information" scope="request"/>
	<p>Salut, nous sommes le <%= request.getAttribute("date") %></p>
	<p>1+1 ça fait ${1+2}</p>
	
	<%
		Identifiant id = (Identifiant) session.getAttribute("idBean");
		Information info = (Information) request.getAttribute("infoBean");
	%>
	<h2>Identifiant : </h2>
	<p><%= id.getIdentifiant() %></p>
	
	
	<h2>Information : </h2>
	<p><%= info.getContenu() %></p>
	
	
	<h2>Identifiant : </h2>
	<p><jsp:getProperty name="idBean" property="identifiant"/></p>
	
	<h2>Information : </h2>
	<p><jsp:getProperty name="infoBean" property="contenu"/></p>
	
	
	<h2>Identifiant : </h2>
	<p>${idBean.identifiant}</p>
	
	<h2>Information : </h2>
	<p>${infoBean.contenu}</p>
</body>
</html>