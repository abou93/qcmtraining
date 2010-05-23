<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div id="content">
<div class="post" style="padding-top: 57px;">
<h2 class="title">Participation au sujet : <c:out value="${participationForm.sujet.titre}" /> </h2>
<div class="entry"><form:form commandName="participationForm"
	action="validerCreerParticipation.do" method="post">
	<form:errors path="*" cssStyle="color:red;" />
	<table width="100%">
		<tr>
			<td style="width: 35%;" />
			<td style="width: 65%;" />
		</tr>
		<tr>
			<td><label for="titre" class="adroite">Titre : </label></td>
			<td><c:out value="${participationForm.sujet.titre}" /></td>
		</tr>
		<tr>
			<td><label for="dateStart" class="adroite">Date de lancement : </label></td>
			<td><span id="dateStart"><fmt:formatDate value="${participationForm.sujet.dateStart}" pattern="dd/MM/yyyy" /></span></td>
		</tr>
		<tr>
			<td><label for="dateEnd" class="adroite">Date de fin : </label></td>
			<td><span id="dateEnd"><fmt:formatDate value="${participationForm.sujet.dateEnd}" pattern="dd/MM/yyyy" /></span></td>
		</tr>
		<tr>
			<td><label for="description" class="adroite">Description :</label></td>
			<td><span id="titre"><c:out value="${participationForm.sujet.description}" /></span></td>
		</tr>
		<c:forEach var="aQuestion" items="${participationForm.sujet.listQuestion}"
			varStatus="questionStatut">
			<tr>
				<td colspan="2" >
				<fieldset> <legend>Question n°<c:out value="${questionStatut.index + 1}" /></legend>
						<table width="100%">
							<tr>
								<td style="width:48%;" />
								<td style="width:48%;" />
								<td style="width:4%;" />
							</tr>
							<tr>
								<td>Libellé de la question :</td>
								<td><c:out value="${aQuestion.libelle}" /></td>
							</tr>
							<c:forEach var="aReponse" items="${aQuestion.listResponse}" varStatus="reponseStatut" >
							
								<tr>
										<td>Réponse n°<c:out value="${reponseStatut.index + 1}" />: </td>
										<td><c:out value="${aReponse.libelle}" /></td>
										<spring:bind
											path="sujet.listQuestion[${questionStatut.index}].indexResponse">
											<td><input type="radio"
												<c:if test="${aQuestion.indexResponse eq reponseStatut.index}">checked="checked"</c:if>
												name="${status.expression}" id="${status.expression}"
												value="${reponseStatut.index}" /></td>
										</spring:bind>
								</tr>
							</c:forEach>
						</table>
					</fieldset>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" style="text-align: right;"><input type="submit"
				value="Valider" /> <input type="button" value="Annuler"
				onclick="window.location.href='adminAccueil.do';" />
			</td>
		</tr>
	</table>
</form:form></div>
</div>
</div>
