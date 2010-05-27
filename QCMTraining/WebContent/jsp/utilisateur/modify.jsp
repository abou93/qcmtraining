<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Modification de l'utilisateur : ${userForm.nom }</h2>
		<div class="entry">
			<form:form commandName="userForm" action="validerModifierUser.do" method="post">
				<fieldset>
					<legend>
						Renseignements généraux
					</legend>
					<input type="hidden" name="id" value="${userForm.id }"/>
					<form:errors path="*" cssStyle="color:red;" />
					<br/>
					<label for="utilisateur.nom" class="agauche">Nom :</label>
					<form:input path="nom" />
					<br/>
					<label for="prenom" class="agauche">Prénom :</label>
					<form:input path="prenom" />
					<br/>
					<label for="email" class="agauche">Email :</label>
					<form:input path="email" />
					<br/>
					<label for="password" class="agauche">Password :</label>
					<input type="password" id="password" name="password" value="<c:out value="${userForm.password}" />" />
					<br/>
					<label for="profil.id" class="agauche">Profil :</label>
					<spring:bind path="profil.id">
					<input type="radio"
								<c:if test="${userForm.profil.id==2}">checked="checked"</c:if> 
								name="profil.id" value="2" />Utilisateur
					<input type="radio"
								<c:if test="${userForm.profil.id==1}">checked="checked"</c:if> 
								name="profil.id" value="1" />Admin
					</spring:bind>
				</fieldset>
				<p></p>
				<div>
				<input type="submit" value="Modifier" />
				<input type="button" value="Annuler" onclick="window.location.href='adminAccueil.do';" />
				</div>
			</form:form>
		</div>
	</div>
</div>