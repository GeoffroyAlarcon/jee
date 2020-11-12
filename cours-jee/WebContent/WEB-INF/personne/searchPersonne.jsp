<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout Personne</title>
</head>
<body>
	<form action="ajoutPersonne" method="post">
		<div>
			<label for="nom">Nom</label> 
			<input type="text" id="nom" name="nom" onkeyup="valider()"> 
			<span id="validationMessage"></span>
		</div>
		<div>
			<label for="prenom">Prenom</label> 
			<input type="text" id="prenom" name="prenom" onkeyup="validerPrenom()">
			<span id="validationMessage2"></span>
		</div>
		<button type="submit">Ajouter</button>
	</form>
<!-- 	<script type="text/javascript" src="js/script.js"></script> -->
<script type="text/javascript">
<%@ include file="../../js/script.js"%>
</script>
</body>
</html>