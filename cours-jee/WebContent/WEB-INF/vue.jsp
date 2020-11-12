<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  errorPage="erreur.jsp"%>
<%@ page import="org.eclipse.model.Personne"%>
<%@ page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projet JEE</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

</head>
<body>
${pageContext.request.contextPath}
	<%@ include file="menu.jsp"%>
	<%
		Personne personne = (Personne) request.getAttribute("perso");
	out.print("Bonjour " + personne.getNum() + " " + personne.getPrenom() + " " + personne.getNom());
	%>
	<h2>Liste de personnes</h2>
	<%
		List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
	for (Personne p : personnes) {
		out.print(p.getPrenom() + " " + p.getNom() + "<br>");
	}
	out.print(personnes.get(0).getPrenom());
	%>
	
	${  perso.prenom } ${ personnes.get(0).nom } ${ x }
	<p class="red">${ firstName }</p>


</body>
</html>