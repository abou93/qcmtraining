<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Cr�er un utilisateur</h2>
		<div class="entry">
			<form:form commandName="userForm" action="validationCreerUser.do" method="post">
				<form:errors path="*" />
				<fieldset>
					<legend>
						Renseignements g�n�raux
					</legend>
					<input type="hidden" name="id" value=""/>
					<br/>

					<label for="nom" class="agauche">Nom :</label>
					<form:input path="nom" />
					<br/>
					<label for="prenom" class="agauche">Pr�nom :</label>
					<form:input path="prenom" />
					<br/>
					<label for="email" class="agauche">Email :</label>
					<form:input path="email" />
					<br/>
					<label for="password" class="agauche">Password :</label>
					<form:input path="password" />
					<br/>
				</fieldset>
				<br /><br />
				<input type="submit" value="Valider" />
				<input type="reset" value="R�initialiser" />
			</form:form>
		</div>
	</div>
</div>