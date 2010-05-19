<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<c:set var="admin" value="false"/>
<c:set var="utilisateur" value="false"/>
<c:set var="inconnu" value="false"/>
<c:choose>
	<c:when test="${sessionScope.utilisateurSession.profil.code == 1}">
		<c:set var="admin" value="true"/>
	</c:when>
	<c:when test="${sessionScope.utilisateurSession.profil.code == 2}">
		<c:set var="utilisateur" value="true"/>
	</c:when>
	<c:otherwise>
		<c:set var="inconnu" value="true"/>
	</c:otherwise>
</c:choose>
<div id="header">
	<div id="logo">
		<h1><a href="#">QCM Training</a></h1>
	</div>
	<div id="menu">
		<ul>
			<li <c:if test="${param.activePage == 1}">class="active"</c:if>><a href="<c:url value="/accueil.do" />" accesskey="1" title="">Accueil</a></li>
			<c:if test="${admin}"><li <c:if test="${param.activePage == 2}">class="active"</c:if>><a href="<c:url value="/utilisateur/list.do" />" accesskey="2" title="">Utilisateur</a></li></c:if>
			<c:if test="${admin}"><li <c:if test="${param.activePage == 3}">class="active"</c:if>><a href="<c:url value="/sujet/list.do" />" accesskey="2" title="">Sujet</a></li></c:if>
			<c:if test="${utilisateur || admin}"><li <c:if test="${param.activePage == 4}">class="active"</c:if>><a href="<c:url value="/qcm/accueil.do" />" accesskey="3" title="">Liste des QCM</a></li></c:if>
		</ul>
	</div>
</div>