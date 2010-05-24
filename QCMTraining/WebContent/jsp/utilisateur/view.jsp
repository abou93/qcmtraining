<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/jsp/general/securityLogged.jsp" />
<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Visualisation de l'utilisateur : ${utilisateur.nom}</h2>
		<div class="entry">
			<fieldset>
				<legend>
					Renseignements généraux
				</legend>
				<br/>
				<label for="nom" class="agauche">Nom :</label>
				<c:out value="${utilisateur.nom}" />
				<br/>
				<label for="prenom" class="agauche">Prénom :</label>
				<c:out value="${utilisateur.prenom}" />
				<br/>
				<label for="email" class="agauche">Email :</label>
				<c:out value="${utilisateur.email}" />
				<c:if test="${isAdmin }">
					<br/><br />
					<label for="profil.id">Utilisateur </label>
					<input type="radio" disabled="disabled" 
								<c:if test="${utilisateur.profil.id==2}">checked="checked"</c:if> 
								name="profil.id" />
					<label for="profil.id">Admin </label>
					<input type="radio" disabled="disabled" 
								<c:if test="${utilisateur.profil.id==1}">checked="checked"</c:if> 
								name="profil.id" />
				</c:if>
				<br />
			</fieldset>
			<c:if test="${isAdmin}">
				<div style="text-align:right">
					<input type="button" 
						value="Modifier" 
						onclick="window.location.href='modifierUser.do?idObject=${utilisateur.id}';" />
					<input type="button" 
						value="Supprimer" 
						onclick="if(!confirm('Confirmer la suppression?')) return false; 
							window.location.href='supprimerUser.do?idObject=${utilisateur.id}';" />
				</div>
			</c:if>
			<br /><br />
			<fieldset>
				<legend>
					Participations
				</legend>
				<div class="recap">SCORE MOYEN : <c:out value="${utilisateur.scoreMoyenPct}" />%</div>
				<br />
				<table width="100%">
					<tr>
						<th style="width:20%;">Score</th>
						<th style="width:80%;">Sujet</th>
					</tr>
					<c:forEach var="participation" items="${utilisateur.mesParticipations}" varStatus="stat" >
					<tr>
						<td <c:if test="${participation.scorePct==100}">class="sansFaute"</c:if>>
							<c:out value="${participation.scorePct}" />%
						</td>
						<td><c:out value="${participation.sujet.titre}" /></td>
					</tr>
					</c:forEach>
				</table>
			</fieldset>
			<br /><br />
			<c:if test="${isAdmin}">
				<input type="button" value="Retour" onclick="window.location.href='listeUser.do';" />			
			</c:if>
		</div>
	</div>
</div>