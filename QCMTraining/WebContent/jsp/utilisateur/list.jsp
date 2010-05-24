<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>

<jsp:include page="/jsp/general/securityLogged.jsp" />
<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Liste des utilisateurs</h2>
		<div class="entry">
			<display:table cellspacing="0" cellpadding="0" name="utilisateurList" id="aUser"  pagesize="10" styleClass="displayTableList"  requestURI="listeUser.do" >
				<display:column title="Nom et prénom" media="html">
					<a href="<c:url value="/voirUser.do?idObject=${aUser.id}" />"><c:out value="${aUser.nom}" /> <c:out value="${aUser.prenom}" /></a>
				</display:column>
				<display:column property="email" title="Email" />
				<display:column  title="Score Moyen Total" >
					<c:out value="${aUser.scoreMoyenPct}%" />
				</display:column>
				<display:setProperty name="paging.banner.item_name" value="utilisateur" />
				<display:setProperty name="paging.banner.items_name" value="utilisateurs" />
			</display:table>
			<br /><br />
			<input type="button" value="Retour" onclick="window.location.href='adminAccueil.do';" />
		</div>
	</div>
</div>