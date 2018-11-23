<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link rel="stylesheet" href="<c:url value="/css/style.css"/>">


<nav class="navbar navbar-expand-lg fixed-top navbar-dark shadowbottom menunav">
  <div class="container">
    <a class="navbar-brand" href="#">ESTER</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample07">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="<c:url value="/"/>">Accueil<span class="sr-only">(current)</span></a>
        </li>
      </ul>
      <form class="form-inline my-2 my-md-0">
      	<c:if test="${empty sessionScope.sessionUtilisateur}">
	      <div class="btn-group" role="group">
	        <a class="btn btn-success" type="button" href="<c:url value="/premiere-connexion"/>">PREMIÈRE CONNEXION</a>
	        <a class="btn btn-info" type="button" href="<c:url value="/connexion"/>">SE CONNECTER</a>
	      </div>
	   	</c:if>
      	<c:if test="${!empty sessionScope.sessionUtilisateur}">
	      <div class="btn-group" role="group">
		    <button id="btnGroupDrop1" type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      <c:out value="${sessionScope.sessionUtilisateur.getIdentifiant()}"/>
		    </button>
		    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
		      <c:if test="${sessionScope.sessionUtilisateur.isEntreprise()}">
		      	<a class="dropdown-item" href="<c:url value="/entreprise"/>">Entreprise</a>
		      </c:if>
		      <c:if test="${sessionScope.sessionUtilisateur.isSalarie()}">
		      	<a class="dropdown-item" href="<c:url value="/salarie"/>">Salarie</a>
		      </c:if>
		      <c:if test="${sessionScope.sessionUtilisateur.isUtilisateur()}">
		      	<a class="dropdown-item" href="<c:url value="/utilisateur"/>">Utilisateur</a>
		      </c:if>
		      <a class="dropdown-item" href="<c:url value="/deconnexion"/>">Déconnexion</a>
    		</div>
	      </div>
	    </c:if>
      </form>
    </div>
  </div>
</nav>