<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>

<div id="content">
	<div class="post" style="padding-top: 57px;">
		<h2 class="title">Liste des sujets</h2>
		<div class="entry">
		
			<fieldset>
			<form:form commandName="sujetSearchForm"
			action="listeSujet.do" method="post">
				<table width="100%">
					<tr>
						<td><label for="searchTitre" class="adroite">Titre : </label></td>
						<td><form:input path="searchTitre" /></td>
					</tr>
					<tr>
						<td><label for="searchInIdCategory" class="adroite">Catégorie : </label></td>
						<td>
							<form:select path="searchInIdCategory" >
								<form:option value="0" label="-- Choisir une catégorie --" />
								<form:options items="${categories}" itemValue="id" itemLabel="libelle" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td><label for="searchActif" class="adroite">Sujets actifs : </label></td>
						<td>
							<form:checkbox path="searchActif"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;">
							<input type="submit" value="Rechercher" />
						</td>
					</tr>
				</table>
				</form:form>
			</fieldset>
			
			<display:table cellspacing="0" cellpadding="0" name="sujetList" id="aSujet"  pagesize="10" styleClass="displayTableList"  requestURI="listeSujet.do" >
				<display:column title="Titre" media="html">
					<a href="<c:url value="/voirSujet.do?idObject=${aSujet.id}" />"><c:out value="${aSujet.titre}" /></a>
				</display:column>
				<display:column property="description" title="Description" />
				<display:setProperty name="paging.banner.item_name" value="sujet" />
				<display:setProperty name="paging.banner.items_name" value="sujets" />
			</display:table>
		<br /><br />
		<input type="button" value="Retour" 
			onclick=<c:choose>
					<c:when test="${isAdmin}">"window.location.href='adminAccueil.do';"</c:when>
					<c:otherwise>"window.location.href='accueil.do';"</c:otherwise>
				</c:choose> />
		</div>
	</div>
</div>
		