<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div id="content">
<div class="post" style="padding-top: 57px;">
<h2 class="title">Création d'un nouveau sujet</h2>
<div class="entry"><form:form commandName="sujetForm"
	action="validerCreerSujet.do" method="post">
	<input type="hidden" name="subAction" />
	<input type="hidden" name="indexQuestion" />
	<form:errors path="*" cssStyle="color:red;" />
	<table width="100%">
		<tr>
			<td style="width: 50%;" />
			<td style="width: 50%;" />
		</tr>
		<tr>
			<td><label for="titre" class="adroite">Titre : </label></td>
			<td><form:input path="titre" /></td>
		</tr>
		<tr>
			<td><label for="dateStart" class="adroite">Date de
			lancement : </label></td>
			<td><input type="text" name="dateStart" size="10" id="dateStart"
				value="<fmt:formatDate value="${sujetForm.dateStart}" pattern="dd/MM/yyyy" />" /></td>
		</tr>
		<tr>
			<td><label for="dateEnd" class="adroite">Date de fin : </label></td>
			<td><input type="text" name="dateEnd" id="dateEnd" size="10"
				value="<fmt:formatDate value="${sujetForm.dateEnd}" pattern="dd/MM/yyyy" />" /></td>
		</tr>
		<tr>
			<td><label for="description" class="adroite">Description
			:</label></td>
			<td><form:textarea path="description" /></td>
		</tr>
		<c:forEach var="aQuestion" items="${sujetForm.listQuestion}"
			varStatus="questionStatut">
			<tr>
				<td colspan="2">
				<fieldset><legend>Question n°<c:out
					value="${questionStatut.index + 1}" /></legend> <spring:bind
					path="listQuestion[${questionStatut.index}].libelle">
					<table width="100%">
						<tr>
							<td style="width: 48%;" />
							<td style="width: 48%;" />
							<td style="width: 4%;" />
						</tr>
						<tr>
							<td><label for="${status.expression}" class="adroite">Libellé
							de la question : </label></td>
							<td><input type="text" name="${status.expression}"
								id="${status.expression}" value="${aQuestion.libelle}" /></td>
						</tr>
						<c:forEach var="aReponse" items="${aQuestion.listResponse}"
							varStatus="reponseStatut">

							<tr>
								<spring:bind
									path="listQuestion[${questionStatut.index}].listResponse[${reponseStatut.index}].libelle">
									<td><label for="${status.expression}" class="adroite">Réponse
									n°<c:out value="${reponseStatut.index + 1}" />: </label></td>
									<td><input type="text" name="${status.expression}"
										id="${status.expression}" value="${aReponse.libelle}" /></td>
								</spring:bind>
								<spring:bind
									path="listQuestion[${questionStatut.index}].indexResponse">
									<td><input type="radio"
										<c:if test="${aQuestion.indexResponse eq reponseStatut.index}">checked="checked"</c:if>
										name="${status.expression}" id="${status.expression}"
										value="${reponseStatut.index}" /></td>
								</spring:bind>
							</tr>
						</c:forEach>
						<c:if test="${questionStatut.index > 0}">
							<tr>
								<td colspan="3"><input type="submit"
									onclick="this.form.subAction.value='removeQuestion'; 
													this.form.indexQuestion.value='${questionStatut.index}';"
									value="Supprimer la question" /></td>
							</tr>
						</c:if>
					</table>
				</spring:bind></fieldset>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2"><input type="submit"
				onclick="this.form.subAction.value = 'addQuestion';"
value="Ajouter une question" /></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: right;"><input type="submit"
				value="Créer" /> <input type="button" value="Annuler"
				onclick="window.location.href='adminAccueil.do';" />
			</td>
		</tr>
	</table>
</form:form></div>
</div>
</div>
