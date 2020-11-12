<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personne</title>
</head>
<body>
	<!-- 
num => modifier et supprimer
nom et prénom => ajouter et modifier
 -->
	<h2>Gestion de Personnes</h2>
	<h3>
		<c:out value="${ operation }"></c:out>
		Personne
	</h3>
	<form method="POST" action="${ action }">
		<c:if test="${ !fn:contains(operation, 'Ajouter') }">
			<div>
				<label for="num">Num *</label> <input type="text" id="num"
					name="num">
			</div>
		</c:if>
		<c:if test="${ !fn:contains(operation, 'Supprimer') }">
			<div>
				<label for="nom">Nom *</label> <input type="text" id="nom"
					name="nom"" >
			</div>
			<div>
				<label for="prenom">Prénom *</label> <input type="text" id="prenom"
					name="prenom">
			</div>
		</c:if>
		<input type="submit" value="${operation }">
	</form>
</body>
</html>