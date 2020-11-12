var requete = "";
function getXMLHttpRequest() {
	var xhr = null;
	if (window.XMLHttpRequest || window.ActiveXObject) {
		if (window.ActiveXObject) {
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		else {
			xhr = new XMLHttpRequest();
		}
	}
	else {
		alert("Navigateur incompatible avec XMLHTTPRequest");
		return null;
	}
	return xhr;
}


function valider() {
	var nom = document.getElementById("nom");
	var url = "SearchPersonne?nom=" + escape(nom.value);
	requete = getXMLHttpRequest();
	requete.open("GET", url, true);
	requete.onreadystatechange = displayMessage;
	requete.send();
}

function validerPrenom() {
	var prenom = document.getElementById("prenom");
	var url2 = "SearchPersonne?prenom=" + escape(prenom.value);
		requete = getXMLHttpRequest();
	requete.open("GET", url2, true);
	requete.onreadystatechange = displayMessagePrenom;
	requete.send();
}
function displayMessage() {
	var message = "";
	if ((requete.readyState == 4) && (requete.status == 200)) {
		var messageTag = requete.responseXML.getElementsByTagName("message")[0];
		message = messageTag.childNodes[0].nodeValue;
		mdiv = document.getElementById("validationMessage");
		mdiv.innerHTML = message;

	}
	}
	function displayMessagePrenom() {
	var message = "";
	if ((requete.readyState == 4) && (requete.status == 200)) {
		var messageTag = requete.responseXML.getElementsByTagName("message")[0];
		message = messageTag.childNodes[0].nodeValue;
		mdiv = document.getElementById("validationMessage2");
		mdiv.innerHTML = message;

	}
}