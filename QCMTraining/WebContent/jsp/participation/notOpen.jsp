<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<jsp:include page="/jsp/general/securityLogged.jsp" />
<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Participation au sujet : ${participationForm.sujet.titre}</h2>
		<div class="entry">
		<table width="100%">
					<tr>
						<td style="width:35%;" />
						<td style="width:65%;" />
					</tr>
					<tr>
						<td><label for="titre" class="adroite">Titre : </label></td>
						<td><span id="titre"><c:out value="${participationForm.sujet.titre}" /></span></td>
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
					<tr>
						<td colspan="2" >
							Le sujet n'est pas encore ouvert, vous ne pouvez donc pas y participer pour l'instant.
						</td>
					</tr>
				</table>
		</div>
	</div>
</div>