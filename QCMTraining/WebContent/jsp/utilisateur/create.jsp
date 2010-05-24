<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/jsp/general/securityAdmin.jsp" />
<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Créer un utilisateur</h2>
		<div class="entry">
			<form:form commandName="userForm" action="validerCreerUser.do" method="post">
				<fieldset>
					<legend>
						Renseignements généraux
					</legend>
					<input type="hidden" name="id" value=""/>
					<form:errors path="*" cssStyle="color:red;" />
					<br/>
					<label for="nom" class="agauche">Nom :</label>
					<form:input path="nom" />
					<br/>
					<label for="prenom" class="agauche">Prénom :</label>
					<form:input path="prenom" />
					<br/>
					<label for="email" class="agauche">Email :</label>
					<form:input path="email" />
					<br/>
					<label for="password" class="agauche">Password :</label>
					<form:password path="password" />
					<br/>
					<label for="profil.id" class="agauche">Profil :</label>
					<spring:bind path="profil.id">
					<input type="radio" name="profil.id" checked="checked" value="2" />Utilisateur
					<input type="radio" name="profil.id" value="1" />Admin
					</spring:bind>
					<br/>
				</fieldset>
				<br /><br />
				<input type="submit" value="Valider" />
				<input type="reset" value="Réinitialiser" />
				<input type="button" value="Annuler" onclick="window.location.href='adminAccueil.do';" />
			</form:form>
		</div>
	</div>
</div>