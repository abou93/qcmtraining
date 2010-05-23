<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Visualisation de l'utilisateur : ${utilisateur.nom}</h2>
		<div class="entry">
			<fieldset>
				<legend>
					Renseignements généraux
				</legend>
				<br/>
				<label for="nom" class="agauche">Nom :</label>
				<c:out value="${utilisateur.nom}" />
				<br/>
				<label for="prenom" class="agauche">Prénom :</label>
				<c:out value="${utilisateur.prenom}" />
				<br/>
				<label for="email" class="agauche">Email :</label>
				<c:out value="${utilisateur.email}" />
				<br/>
			</fieldset>
			<div style="text-align:right">
				<input type="button" 
					value="Supprimer" 
					onclick="if(!confirm('Confirmer la suppression?')) return false; 
						window.location.href='supprimerUser.do?idObject=${utilisateur.id}';" />
			</div>
			<br /><br />
			<input type="button" value="Retour" onclick="window.location.href='listeUser.do';" />
		</div>
	</div>
</div>