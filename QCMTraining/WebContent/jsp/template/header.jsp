<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<div id="header">
	<div id="logo">
	<h1><a href="#">QCM Training</a></h1>
	</div>
	<div id="menu">
	<ul>
		<li <c:if test="${sessionScope['activePage'] == 1}">class="active"</c:if>><a
			href="accueil.do" accesskey="1" title="">Accueil</a></li>
		<c:if test="${sessionScope['isAdmin']}">
			<li <c:if test="${sessionScope['activePage'] == 2}">class="active"</c:if>><a
				href="adminAccueil.do" accesskey="2" title="">Administration</a></li>
		</c:if>
		<c:if test="${sessionScope['utilisateur'] || sessionScope['isAdmin']}">
			<li <c:if test="${sessionScope['activePage'] == 3}">class="active"</c:if>><a
				href="sujet/list.do" accesskey="3" title="">Sujet</a></li>
		</c:if>
		<c:if test="${sessionScope['utilisateur'] || sessionScope['isAdmin']}">
			<li <c:if test="${sessionScope['activePage'] == 3}">class="active"</c:if>><a
				href="qcm/accueil.do" accesskey="3" title="">Liste des QCM</a></li>
		</c:if>
	</ul>
	</div>
</div>