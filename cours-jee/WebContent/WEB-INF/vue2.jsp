<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cours JSTL</title>
</head>
<body>
<hader><h1>Page d'accueil</h1></hader>
	<main>
	<nav><%@ include file="menu.jsp" %></nav>
	<article>
	${ sessionScope.perso }
	<c:out value="${ firstName }"
		default="ce message s'affiche si la variable n'existe pas" />
	<c:out value="${ firstName }"> ce message s'affiche si la variable n'existe pas</c:out>
	<c:out value="${ a }"
		default="ce message s'affiche si la variable n'existe pas" />
	<c:out value="${ a }"> ce message s'affiche si la variable n'existe pas</c:out>
	<c:out value="<p> Bonjour 'John Wick'. </p>" escapeXml="false" />
	<c:set var="str" value="Hello world" scope="session"></c:set>
	<!--  String str = "Hello world" -->
	<c:out value="${ str }"></c:out>
	<c:set var="x" value="${ 5 }" />
	<c:out value="${ x }"></c:out>
	<c:set var="x" value="${ x + 1 }" />
	<c:out value="${ x }"></c:out>
	<hr />
	<c:if test="${ x % 2 == 0 }" var="result">pair : ${ result }</c:if>
	<c:if test="${ value > 0 }" var="signe"> positif</c:if>
	<c:if test="${ !signe }" var="signe"> négatif ou nul</c:if>
	<hr />
	<c:choose>
		<c:when test="${ value > 0 }"> positif</c:when>
		<c:when test="${ value < 0 }"> négatif</c:when>
		<c:otherwise> nul </c:otherwise>
	</c:choose>
	<hr />
	<c:forEach var="i" begin="0" end="10" step="2">
	${ i }
	</c:forEach>
	<hr />

	<c:forEach items="${ personnes }" var="element" varStatus="status">
		<c:choose>
			<c:when test="${ status.first || status.last }">
				<c:out value="${ element['nom'] } ${ element['prenom'] }" />
			</c:when>
			<c:otherwise>
				<c:out value="${ element['nom'] }" />
			</c:otherwise>
		</c:choose>
		<br>
	</c:forEach>

	<c:forEach items="${ personnes }" var="element" varStatus="status">

		<c:out value="${ element['prenom'] } ${ element['nom'] }" />
		<br>
	</c:forEach>
	<br>
	<c:url value="/calcul" var="monLien">
	 <c:param name="a" value="2"/>
 	 <c:param name="b" value="5"/>
 	 <c:param name="op" value="plus"/>
	</c:url>
	<a href="${ monLien }">Caclul</a>
	
	
	<h2>Functions</h2>
	${ fn:contains("bonjour", "ton") }
	<h2>Formattage de données</h2>
	
	<c:set var="montant" value="112233.44" />
	montant = <fmt:formatNumber value="${ montant }" type="currency"/>
	</article>
	</main>
</body>
</html>