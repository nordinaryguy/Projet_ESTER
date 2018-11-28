<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="<c:url value="/css/menu.css"/>">

	<!-- Menu en header de la page -->						

<nav class="navbar navbar-expand-lg fixed-top navbar-dark shadowbottom">
	<div class="container">
	
	<!-- Ester -->
	    <a class="navbar-brand" href="#" style="color:white">ESTER</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
	    </button>
      
	<!-- Lien Accueil -->
	
    <div class="collapse navbar-collapse" id="navbarsExample07">
      <ul class="navbar-nav mr-auto">
        
        <li class="nav-item active">
          <a class="nav-link" style="color:white" href="<c:url value="/"/>">Accueil
          	<span class="sr-only">(current)</span>
          </a>
        </li>
      </ul>
     
     
     <img class="pr-4" src="<c:url value="/img/irset.png"/>" alt="Logo-ister" width="155">
 
    	<!-- Bouton pour la Connexion/Première Connexion/Déconnexion -->
    
      <form class="form-inline my-2 my-md-0">
      	<c:if test="${empty sessionScope.sessionUtilisateur}">
	      <div class="btn-group" role="group">
	        <a class="btn btn-success" href="<c:url value="/premiere-connexion"/>">PREMIÈRE CONNEXION</a>
	        <a class="btn btn-info" href="<c:url value="/connexion"/>">SE CONNECTER</a>
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
      
      <img class="pl-3" src="<c:url value="/img/ua_h.png"/>" alt="Logo-Université-Angers" width="170">
      
    </div>     
  </div>
</nav>