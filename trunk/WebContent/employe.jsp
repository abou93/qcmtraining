<%@ page contentType="text/html;charset=ISO-8859-15" language="java" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<?xml version="1.0" encoding="ISO-8859-15"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
	<head>
		<title>
			Formulaire Employés
		</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15" />
		<link rel="stylesheet" href="include/employe.css" type="text/css" />
	</head>
	<body>
		<div id="bandeausup">
			<h1>Renseignements Employés</h1>
		</div>
		<div id="contenu">
			<br />Merci de compléter le questionnaire ci-dessous.
			<br /><br />	

			<form:form commandName="employe" action="validationEmploye.do" method="post">
				<form:errors path="*" />
				<fieldset>
					<legend>
						Renseignements généraux
					</legend>
					<input type="hidden" name="id" value=""/>
					<br/>

					<label for="nom" class="adroite">Nom :</label>
					<form:input path="nom" />
					<br/>
					<label for="prenom" class="adroite">Prénom :</label>
					<form:input path="prenom" />
					<br/>
					<label for="societe.id" class="adroite">Societe :</label>
					<form:select path="societe.id">
						<form:options items="${societes}" itemValue="id" itemLabel="nom"/>
					</form:select>
				</fieldset>
				<br /><br />
				<input type="submit" value="Valider" />
				<input type="reset" value="Réinitialiser" />
			</form:form>
			
						
			<table>
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Société</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${employes}" var="e">
					<tr>
						<td><c:out value="${e.nom}" /></td>
						<td><c:out value="${e.prenom}" /></td>
						<td><c:out value="${e.societe.nom}" /></td>
						<td><a href="modificationEmploye.do">Modifier</a> - <a href="suppressionEmploye.do">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>