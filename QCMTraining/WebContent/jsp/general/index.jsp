<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Bienvenue sur QCM Training</h2>
		<div class="entry">
			<div style="text-align:center" >Bienvenue sur notre site d'entrainement aux QCM</div> <br />
			Vous retrouverez ici un environnement d'entrainement aux QCM! <br />
			<br /><br />
			<strong>Damien Renaud</strong> disait 
			<i>"Il n'y a pas d'homme cultivé, il n'y a que des hommes qui se cultivent"</i>.
			<br />
			<br />
			Tout un programme !<br />
			<br />
			Partant de cette vérité, 
			QCMTraining a été bâti afin de vous permettre d'évoluer progressivement 
			sur le périlleux chemin de la connaissance universelle.
			<br /><br />
			<c:if test="${not empty listTopSujet}">
				<fieldset>
					<legend>Voici la liste des sujets les plus répondus</legend>
					<display:table cellspacing="0" cellpadding="0" name="listTopSujet" id="aSujet"  pagesize="10" styleClass="resultats"  requestURI="listeSujet.do" >
						<display:column title="Titre">
							<a href="<c:url value="/voirSujet.do?idObject=${aSujet.id}" />"><c:out value="${aSujet.titre}" /></a>
						</display:column>
						<display:column title="Participation">
							<c:out value="${aSujet.nombreDeParticipants} Hits" />
						</display:column>
						<display:column property="category.libelle" title="Catégorie" />
						<display:column title="Ouvert">
							<c:choose>
								<c:when test="${aSujet.actif}">
									<img src="<c:url value="/include/images/tick.gif" />" alt="Actif" />
								</c:when>
								<c:otherwise>
									<img src="<c:url value="/include/images/desactivate.png" />" alt="Inactif" />
								</c:otherwise>
							</c:choose>
						</display:column>
						<display:setProperty name="paging.banner.item_name" value="sujet" />
						<display:setProperty name="paging.banner.items_name" value="sujets" />
					</display:table>
				</fieldset>
			</c:if>
			
		</div>
	</div>
</div>