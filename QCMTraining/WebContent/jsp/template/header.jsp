<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<div id="header">
	<div id="logo">
	<h1><a href="#">QCM Training</a></h1>
	</div>
	<div id="menu">
	<ul>
		<li <c:if test="${activePage == 1}">class="active"</c:if>><a
			href="accueil.do" accesskey="1" title="">Accueil</a></li>
		<c:if test="${sessionScope['isAdmin']}">
			<li <c:if test="${activePage == 2}">class="active"</c:if>><a
				href="adminAccueil.do" accesskey="2" title="">Administration</a></li>
		</c:if>
			<li <c:if test="${activePage == 3}">class="active"</c:if>><a
				href="listeSujet.do" accesskey="3" title="">Sujet</a></li>
	</ul>
	</div>
</div>