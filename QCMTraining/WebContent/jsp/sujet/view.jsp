<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Visualisation du sujet : ${sujet.titre}</h2>
		<div class="entry">
		<table width="100%">
					<tr>
						<td style="width:50%;" />
						<td style="width:50%;" />
					</tr>
					<tr>
						<td><label for="titre" class="adroite">Titre : </label></td>
						<td><span id="titre"><c:out value="${sujet.titre}" /></span></td>
					</tr>
					<tr>
						<td><label for="dateStart" class="adroite">Date de lancement : </label></td>
						<td><span id="dateStart"><fmt:formatDate value="${sujet.dateStart}" pattern="dd/MM/yyyy" /></span></td>
					</tr>
					<tr>
						<td><label for="dateEnd" class="adroite">Date de fin : </label></td>
						<td><span id="dateEnd"><fmt:formatDate value="${sujet.dateEnd}" pattern="dd/MM/yyyy" /></span></td>
					</tr>
					<tr>
						<td><label for="description" class="adroite">Description :</label></td>
						<td><span id="titre"><c:out value="${sujet.description}" /></span></td>
					</tr>
					<c:forEach var="aQuestion" items="${sujet.listQuestion}" varStatus="questionStatut" >
					<tr>
						<td colspan="2" >
						<fieldset> <legend>Question n�<c:out value="${questionStatut.index + 1}" /></legend>
								<table width="100%">
									<tr>
										<td style="width:48%;" />
										<td style="width:48%;" />
										<td style="width:4%;" />
									</tr>
									<tr>
										<td>Libell� de la question :</td>
										<td><c:out value="${aQuestion.libelle}" /></td>
									</tr>
									<c:forEach var="aReponse" items="${aQuestion.listResponse}" varStatus="reponseStatut" >
									
										<tr>
												<td>R�ponse n�<c:out value="${reponseStatut.index + 1}" />: </td>
												<td><c:out value="${aReponse.libelle}" /></td>
												<td><input type="radio" disabled="disabled" <c:if test="${aReponse.goodResponse}">checked="checked"</c:if> 
													name="question${questionStatut.index}.reponse${reponseStatut.index}.goodResponse" /></td>
										</tr>
									</c:forEach>
								</table>
							</fieldset>
						</td>
					</tr>
					</c:forEach>
					<c:if test="${sujet.actif}">
						<tr>
							<td colspan="2" style="text-align:right;" >
								<input type="button" value="Modifier" onclick="window.location.href='/sujet/modifierSujet.do?idSujet=${sujet.id}';" /> 
							</td>
						</tr>
					</c:if>
				</table>
		</div>
	</div>
</div>