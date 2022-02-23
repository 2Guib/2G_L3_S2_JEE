<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Proverbes</title>
    <link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
	<jsp:useBean id="proverbeBean" class="bean.InfoProverbe" scope="request"/>
    <h1>Comme le disais ... ${proverbeBean.nom}</h1>
    
    <p>[${proverbeBean.numProverbe}] ${proverbeBean.proverbe}</p>
    
    <form action="/JEE_TP6-proverbes/" method="get">
    	<button type="submit">Back</button>
    </form>
</body>
</html>