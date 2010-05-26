<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Erreur</h2>
		<div class="entry">
			Une ou plusieurs erreurs sont intervenues, veuillez contacter votre administrateur.
		</div>
		<p></p>
		<div id="error">
		<fieldset>
			<legend>Détail des erreurs :</legend>
			<c:forEach items="${listErrors}" var="anError">
				<p><c:out value="${anError}" /></p>
			</c:forEach>
		</fieldset>
		</div>
	</div>
</div>