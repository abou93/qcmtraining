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
				
					<form:form commandName="sujetForm" action="validationCreate.do"
						method="post">
						<form:errors path="*" cssStyle="color:red;" />
						<table width="100%">
							<tr>
								<td style="width:50%;" />
								<td style="width:50%;" />
							</tr>
							<tr>
								<td><label for="titre" class="adroite">Titre : </label></td>
								<td><form:input path="titre" /></td>
							</tr>
							<tr>
								<td><label for="dateStart" class="adroite">Date de lancement : </label></td>
								<td><form:input path="dateStart" size="8" /></td>
							</tr>
							<tr>
								<td><label for="dateEnd" class="adroite">Date de fin : </label></td>
								<td><form:input path="dateStart" size="8" /></td>
							</tr>
							<tr>
								<td><label for="description" class="adroite">Description :</label></td>
								<td><form:textarea path="description" /></td>
							</tr>
							<c:forEach var="aQuestion" items="${sujetForm.listQuestion}" varStatus="questionStatut" >
							<tr>
								<td colspan="2" >
								<fieldset> <legend>Question n°<c:out value="${questionStatut.index + 1}" /></legend>
									<spring:bind path="listQuestion[${questionStatut.index}].libelle">
										<table width="100%">
											<tr>
												<td style="width:48%;" />
												<td style="width:48%;" />
												<td style="width:4%;" />
											</tr>
											<tr>
												<td><label for="${status.expression}" class="adroite">Libellé de la question : </label></td>
												<td><input  type="text" name="${status.expression}"/></td>
											</tr>
											<c:forEach var="aReponse" items="${aQuestion.listResponse}" varStatus="reponseStatut" >
											
												<tr>
													<spring:bind path="listQuestion[${questionStatut.index}].listResponse[${reponseStatut.index}].libelle">
														<td><label for="${status.expression}" class="adroite">Réponse n°<c:out value="${reponseStatut.index + 1}" />: </label></td>
														<td><input  type="text" name="${status.expression}"/></td>
													</spring:bind>
													<spring:bind path="listQuestion[${questionStatut.index}].listResponse[${reponseStatut.index}].goodResponse">
														<td><input  type="checkbox" name="${status.expression}"/></td>
													</spring:bind>
												</tr>
											
											</c:forEach>
										</table>
									</spring:bind>
									</fieldset>
								</td>
							</tr>
							</c:forEach>
							<tr>
								<td colspan="2"><input type="submit" value="Créer" /></td>
							</tr>
						</table>
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