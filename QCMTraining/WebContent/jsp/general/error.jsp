<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Erreur</h2>
		<div class="entry">
			Une erreur est intervenue, veuillez contacter votre administrateur.
		</div>
		<div id="error">
			<c:forEach items="listErrors" var="anError">
				<c:out value="anError" />
			</c:forEach>
		</div>
	</div>
</div>