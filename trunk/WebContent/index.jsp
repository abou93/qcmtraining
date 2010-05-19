<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<?xml version="1.0" encoding="ISO-8859-15"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
<head>
<title>QCM Training</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15" />
<link href="include/css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="/jsp/template/header.jsp" >
	<jsp:param value="1" name="activePage" />
</jsp:include>
<div id="page">
	<div id="bg">
		<jsp:include page="${sessionScope['pageContent']}"/>
		<!-- end contentn -->
		<div id="sidebar">
			<div id="login">
				<p>isAdmin : <c:out value="${sessionScope['isAdmin']}" /> / isLogged : <c:out value="${sessionScope['isLogged']}" /></p>
				<h2>Connectez-vous</h2>
				<jsp:include page="login.do"/>
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