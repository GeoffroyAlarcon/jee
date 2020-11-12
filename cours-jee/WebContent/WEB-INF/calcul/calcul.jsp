<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calcul</title>
</head>
<body>
	<h1>Résultat</h1>
	<c:set var="a" value="${ param.a }" />
	<c:set var="b" value="${ param.b }" />
	<c:set var="op" value="${ param.op }" />
	<c:set var="resultat" value="${ 0 }" />
	<c:choose>
		<c:when test="${ fn:contains(op, 'plus') }">
			<c:set var="resultat" value="${ a+b }" />
			<c:set var="op" value="+" />
		</c:when>
		<c:when test="${ fn:contains(op, 'fois') }">
			<c:set var="resultat" value="${ a*b }" />
			<c:set var="op" value="*" />
		</c:when>
		<c:when test="${ fn:contains(op, 'div') }">
			<c:set var="resultat" value="${ a/b }" />
			<c:set var="op" value="/" />
		</c:when>
		<c:when test="${ fn:contains(op, 'moins') }">
			<c:set var="resultat" value="${ a-b }" />
			<c:set var="op" value="-" />
		</c:when>
	</c:choose>
	
	
	<c:out value="${ a } ${ op } ${ b } = ${ resultat }"></c:out>
	<c:url value="/mapage" var="monLien">
		<c:param name="num" value="5" />
		<c:param name="nom" value="barthez" />
		<c:param name="prenom" value="fabien" />
	</c:url>
	<a href="${ monLien }">Accueil</a>
</body>
</html>