<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Résultat du sujet : ${participation.sujet.titre}</h2>
		<div class="entry">
		<table width="100%">
					<tr>
						<td style="width:50%;" />
						<td style="width:50%;" />
					</tr>
					<tr>
						<td><label for="titre" class="adroite">Titre : </label></td>
						<td><span id="titre"><c:out value="${participation.sujet.titre}" /></span></td>
					</tr>
					<tr>
						<td><label for="dateStart" class="adroite">Date de lancement : </label></td>
						<td><span id="dateStart"><fmt:formatDate value="${participation.sujet.dateStart}" pattern="dd/MM/yyyy" /></span></td>
					</tr>
					<tr>
						<td><label for="dateEnd" class="adroite">Date de fin : </label></td>
						<td><span id="dateEnd"><fmt:formatDate value="${participation.sujet.dateEnd}" pattern="dd/MM/yyyy" /></span></td>
					</tr>
					<tr class="score">
						<td><label for="score">Votre score : </label></td>
						<td><span id="score"><c:out value="${participation.score}" /> (<c:out value="${participation.scorePct}" />%)</span></td>
					</tr>
					<tr>
						<td><label for="description" class="adroite">Description :</label></td>
						<td><span id="titre"><c:out value="${participation.sujet.description}" /></span></td>
					</tr>
					<c:forEach var="aReponseChoisie" items="${participation.reponsesChoisies}" varStatus="reponseChoisieStatut" >
					<tr>
						<td colspan="2" >
						<fieldset> <legend>Question n°<c:out value="${reponseChoisieStatut.index + 1}" /></legend>
								<table width="100%">
									<tr>
										<td style="width:48%;" />
										<td style="width:48%;" />
										<td style="width:4%;" />
									</tr>
									<tr>
										<td>Libellé de la question :</td>
										<td><c:out value="${aReponseChoisie.question.libelle}" /></td>
									</tr>
									<c:forEach var="aReponse" items="${aReponseChoisie.question.listResponse}" varStatus="reponseStatut" >
										<c:choose>
											<c:when test="${aReponseChoisie.id eq aReponse.id}">
												<c:choose>
													<c:when test="${aReponse.goodResponse}">
														<tr class="goodReponse">
															<td>Réponse n°<c:out value="${reponseStatut.index + 1}" />: </td>
															<td><c:out value="${aReponse.libelle}" /></td>
															<td><input type="radio" disabled="disabled" checked="checked" /></td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr class="falseReponse">
															<td>Réponse n°<c:out value="${reponseStatut.index + 1}" />: </td>
															<td><c:out value="${aReponse.libelle}" /></td>
															<td><input type="radio" disabled="disabled" checked="checked" /></td>
														</tr>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${aReponse.goodResponse}">
														<tr class="correctReponse">
															<td>Réponse n°<c:out value="${reponseStatut.index + 1}" />: </td>
															<td><c:out value="${aReponse.libelle}" /></td>
															<td><input type="radio" disabled="disabled" checked="checked" /></td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<td>Réponse n°<c:out value="${reponseStatut.index + 1}" />: </td>
															<td><c:out value="${aReponse.libelle}" /></td>
															<td><input type="radio" disabled="disabled" /></td>
														</tr>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</table>
							</fieldset>
						</td>
					</tr>
					</c:forEach>
				</table>
				<br /><br />
				<input type="button" value="Retour" onclick="window.location.href='listeSujet.do';" />
		</div>
	</div>
</div>