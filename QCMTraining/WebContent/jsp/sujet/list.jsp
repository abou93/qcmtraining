<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Liste des sujets</h2>
		<div class="entry">
			<c:choose>
			<c:when test="${not empty sujetList}">
				<table cellpadding="0" cellspacing="1" width="100%">
					<tr>
						<th>Titre</th>
						<th>Description</th>
					</tr>
					<c:forEach var="aSujet" items="${sujetList}">
						<tr>
							<td><a href="<c:url value="/voirSujet.do?idObject=${aSujet.id}" />"><c:out
								value="${aSujet.titre}" /></a></td>
							<td><c:out
								value="${aSujet.description}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
							Il n'y a aucun sujet!
						</c:otherwise>
		</c:choose>
		<br /><br />
		<input type="button" value="Retour" onclick="window.location.href='adminAccueil.do';" />
		</div>
	</div>
</div>
		