<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Liste des utilisateurs</h2>
		<div class="entry">
			<c:choose>
			<c:when test="${not empty utilisateurList}">
				<table cellpadding="0" cellspacing="1" width="100%">
					<tr>
						<th>Nom et prénom</th>
						<th>Email</th>
					</tr>
					<c:forEach var="aUtilisateur" items="${utilisateurList}">
						<tr>
							<td><a href="<c:url value="/voirUser.do?idObject=${aUtilisateur.id}" />"><c:out
								value="${aUtilisateur.prenom}" /> <c:out
								value="${aUtilisateur.nom}" /></a></td>
							<td><c:out
								value="${aUtilisateur.email}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
							Il n'y a aucun utilisateur!
						</c:otherwise>
			</c:choose>
			<br /><br />
			<input type="button" value="Retour" onclick="window.location.href='adminAccueil.do';" />
		</div>
	</div>
</div>