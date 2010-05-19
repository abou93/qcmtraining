<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<c:choose>
	<c:when test="${param.domainName eq 'sujet'}">
			<a href="<c:url value='/sujet/create.do' />" accesskey="1" title="">Créer un sujet</a>
	</c:when>
</c:choose>
