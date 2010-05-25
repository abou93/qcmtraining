<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Connectez-vous</h2>
<form:form commandName="utilisateur" action="validationLogin.do"
	method="post">
	<label for="email" class="adroite">Email : </label>
	<form:input path="email" />
	<label for="password" class="adroite">Password :</label>
	<form:password path="password" /><br />
	<form:errors path="*" cssStyle="color:red;" />
	<input type="submit" value="Se connecter" />
</form:form>
<div class="register"><a href="register.do">Enregistrez-vous</a></div>