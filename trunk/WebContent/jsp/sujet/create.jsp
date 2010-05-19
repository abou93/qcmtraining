<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<?xml version="1.0" encoding="ISO-8859-15"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
<head>
<title>QCM Training - Création d'un nouveau sujet</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15" />
<link href="../include/css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="/jsp/template/header.jsp" >
	<jsp:param value="3" name="activePage" />
</jsp:include>
<div id="page">
	<div id="bg">
		<div id="content">
			<div class="post" style="padding-top: 57px;">
				<h2 class="title">Création d'un nouveau sujet</h2>
				<div class="entry">
					<form:form commandName="sujetForm" action="validationSujet.do"
						method="post">
						<form:errors path="*" cssStyle="color:red;" />
						<label for="titre" class="adroite">Titre : </label>
						<form:input path="titre" /><br />
						<label for="description" class="adroite">Description :</label>
						<form:textarea path="description" /><br />
						<c:forEach var="aQuestion" items="${sujetForm.listQuestion}" varStatus="statut1" >
						<spring:bind path="listQuestion[${statut1.index}].libelle">
							<label for="${status.expression}" class="adroite">Libellé de la question : </label>
							<input  type="text" name="${status.expression}"/>
						</spring:bind>
						</c:forEach>
						<input type="submit" value="Créer" />
					</form:form>
				</div>
			</div>
		</div>
		<!-- end contentn -->
		<div id="sidebar">
			<div id="login">
			
				<jsp:include page="/login.do"/>
			</div>
			
		</div>
		<!-- end sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
</div>
<hr />
<div id="footer">
	<jsp:include page="/jsp/template/footer.jsp" />
</div>
</body>
</html>