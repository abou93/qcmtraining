<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<?xml version="1.0" encoding="ISO-8859-15"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
<head>
<title>QCM Training - Liste des Sujets</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15" />
<link href="../include/css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="/jsp/template/header.jsp" >
	<jsp:param value="3" name="activePage" />
</jsp:include>
<div id="page">
	<div id="bg">
		<div id="content">
			<div class="post" style="padding-top: 57px;">
				<h2 class="title">Liste des sujets</h2>
				<div class="entry">
					<c:choose>
					<c:when test="${not empty sujetList}">
						<table cellpadding="0" cellspacing="1" width="100%">
							<tr>
								<th>Titre</th>
								<th>Description</th>
							</tr>
							<c:forEach var="aSujet" items="${sujetList}">
								<tr>
									<td><a href="<c:url value="/sujet/view.do?sujetId=${aUtilisateur.id}" />"><c:out
										value="${aSujet.titre}" /></a></td>
									<td><c:out
										value="${aSujet.description}" /></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
									Il n'y a aucun sujet!
								</c:otherwise>
				</c:choose>
				</div>
			</div>
		</div>
		<!-- end contentn -->
		<div id="sidebar">
			<div id="login">
				<jsp:include page="/login.do"/>
			</div>
			<div id="right-menu">
				<jsp:include page="/jsp/template/right-menu.jsp">
					<jsp:param value="sujet" name="domainName"/>
				</jsp:include>
			</div>
		</div>
		<!-- end sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
</div>
<hr />
<div id="footer">
	<jsp:include page="/jsp/template/footer.jsp" />
</div>
</body>
</html>