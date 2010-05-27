<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<h2>Bonjour</h2>
<p>
 Vous êtes connecté en tant que <c:out value="${utilisateurSession.nom}"/> <c:out value="${utilisateurSession.prenom}"/>, bonne navigation!
</p>
<a href="monProfil.do" >Mon profil</a>
<br /><br />
<a href="deconnexion.do" >Déconnexion</a>