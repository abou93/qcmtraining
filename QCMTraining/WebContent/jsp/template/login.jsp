<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Connectez-vous</h2>
<form:form commandName="utilisateur" action="validationLogin.do"
	method="post">
	<fieldset style="border:0">
	<label for="email" class="adroite">Email : </label>
	<form:input id="emailLogin" path="email" />
	<label for="password" class="adroite">Password :</label>
	<form:password id="passwordLogin" path="password" /><br />
	<form:errors path="*" cssStyle="color:red;" />
	<input type="submit" value="Se connecter" />
	</fieldset>
</form:form>
<div class="register"><a href="register.do">Enregistrez-vous</a></div>