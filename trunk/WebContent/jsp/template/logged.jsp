<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<h2>Bonjour</h2>
<p>
 Vous êtes connectés en tant que <c:out value="${utilisateurSession.nom}"/> <c:out value="${utilisateurSession.prenom}"/>, bonne navigation!
</p>
<br />

<a href="<c:url value="/deconnexion.do" />" >Déconnexion</a>