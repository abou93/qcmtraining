<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<h2>Bonjour</h2>
<p>
 Vous êtes connectés en tant que <c:out value="${utilisateurSession.nom}"/> <c:out value="${utilisateurSession.prenom}"/>, bonne navigation!
</p>
<a href="voirUser.do?idObject=<c:out value="${utilisateurSession.id}" />" >Mon profil</a>
<br /><br />
<a href="deconnexion.do" >Déconnexion</a>