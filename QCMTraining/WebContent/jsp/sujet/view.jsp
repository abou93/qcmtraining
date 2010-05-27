<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>

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
						<td><label for="category" class="adroite">Catégorie : </label></td>
						<td><span id="category"><c:out value="${sujet.category.libelle}" /></span></td>
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
						<td><label for="nbQuestionDisplay" class="adroite">Nombre de question(s) : </label></td>
						<td><span id="nbQuestionDisplay"><c:out value="${sujet.nbQuestionDisplay}" /></span></td>
					</tr>
					<tr>
						<td><label for="description" class="adroite">Description :</label></td>
						<td><span id="description"><c:out value="${sujet.description}" /></span></td>
					</tr>
					<c:if test="${isAdmin}">
						<tr>
							<td><label for="nombreDeParticipants" class="adroite">Nombre de participants</label></td>
							<td><span id="nombreDeParticipants"><c:out value="${sujet.nombreDeParticipants}" /></span></td>
						</tr>
						<tr>
							<td colspan="2" >
								<fieldset>
									<legend>Liste des utilisateurs ayant fait un sans faute</legend>
									<display:table cellspacing="0" cellpadding="0" name="partSansFaute" id="aPart"  pagesize="5" styleClass="resultats"  requestURI="voirSujet.do?idObject=${sujet.id}" >
										<display:column title="Nom et prénom">
											<a href="<c:url value="/voirUser.do?idObject=${aPart.user.id}" />"><c:out value="${aPart.user.nom}" /> <c:out value="${aPart.user.prenom}" /></a>
										</display:column>
										<display:column property="user.email" title="Email" />
										
										<display:column  title="Score Moyen Total" >
											<c:out value="${aPart.user.scoreMoyenPct}%" />
										</display:column>
										<display:setProperty name="paging.banner.item_name" value="utilisateur" />
										<display:setProperty name="paging.banner.items_name" value="utilisateurs" />
									</display:table>							
								</fieldset>
							</td>
						</tr>
						<c:forEach var="aQuestion" items="${sujet.listQuestion}" varStatus="questionStatut" >
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
												<c:choose>
													<c:when test="${aReponse.goodResponse}">
														<c:set var="class" value="goodReponse" />
													</c:when>
													<c:otherwise>
														<c:set var="class" value="" />
													</c:otherwise>
												</c:choose>
												<tr <c:if test="${aReponse.goodResponse}" >class="goodReponse" </c:if>>
														<td>Réponse n°<c:out value="${reponseStatut.index + 1}" />: </td>
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
					</c:if>
					
						<tr>
							<td colspan="2" style="text-align:right;" >
								<c:if test="${sujet.actif}">
									<c:choose>
									<c:when test="${isLogged and not isAdmin}">
										<input type="button" value="Participer" onclick="window.location.href='creerParticipation.do?idObject=${sujet.id}';" />
									</c:when>
									<c:when test="${isAdmin}">
										
									</c:when>
									<c:otherwise>
										<span class="info">Connectez vous pour répondre au sujet!</span>	
									</c:otherwise>
									</c:choose>
								</c:if>
							</td>
						</tr>
				</table>
				<br /><br />
				<input type="button" value="Retour" onclick="window.location.href='listeSujet.do';" />
		</div>
	</div>
</div>