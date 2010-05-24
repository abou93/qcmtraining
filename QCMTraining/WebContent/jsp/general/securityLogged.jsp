<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>

<c:if test="${!isLogged}">
	<meta http-equiv="refresh" content="0; url=accueil.do" />
</c:if>