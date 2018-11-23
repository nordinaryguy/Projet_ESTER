<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr-FR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="UA.png">

    <title>ESTER</title>

	<link rel="stylesheet" href="<c:url value="/css/Acceuil.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/form-patient.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/populateSelect.js"/>"></script>
		
</head>

<body >  
	    <c:import url="/jsp/Menu.jsp"/>
		<div class="container-fluid" id="container"  style="ms-height:75rem;padding-top:4.5rem;">
  			<div class="row">
  
				<nav class="col-xs-2 navbar navbar-collapse bg-nav">
			    	<button class="navbar-toggler btn btn-outline-primary my-2 my-sm-0 " type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">Menu
			      	<span class="navbar-toggler-icon"></span>
			    	</button>
			  	</nav>
				 <div class="collapse" id="navbarToggleExternalContent">
			  		<ul>
				  		<li class="nav-item dropdown">
					        <a class="nav-link dropdown-toggle" href="#" id="gestionComptesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Création de compte
					        </a>		 
								 <div class="dropdown-menu" aria-labelledby="gestionComptesMenu">
						          <a class="dropdown-item" href="#">Préventeurs</a>
						          <a class="dropdown-item" href="#">Infirmiers</a>
						          <a class="dropdown-item" href="#">Assistants</a>
						          <a class="dropdown-item" href="#">Entreprises</a>
						          <a class="dropdown-item" href="<%= request.getContextPath()%>/Medecin?page=createSalarie">Salariés</a>
								</div>
						</li>
						
						<li class="nav-item dropdown">
					        <a class="nav-link dropdown-toggle" href="#" id="gestionSalariesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Gestion des salariés
					        </a>	 
								 <div class="dropdown-menu" aria-labelledby="gestionSalariesMenu">
						         	<a class="dropdown-item" href="#">Liste des salariés</a>
						         	<a class="dropdown-item" href="#">Profil du salarié</a>		
						       	 </div>
						</li>		
				        
						<li class="nav-item dropdown">
				       		<a class="nav-link dropdown-toggle" href="#" id="gestionQuestionnaireMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion des questionnaires</a>
						 
							 <div class="dropdown-menu" aria-labelledby="gestionQuestionnaireMenu">
					         	<a class="dropdown-item" href="#">Créer un questionnaire</a>
					         	<a class="dropdown-item" href="#">Modifier un questionnaire</a>
		          			 	<a class="dropdown-item" href="#">Administrer les questionnaires</a>	
					         </div>
					   	</li>	        
				              
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Modifier les valeurs de référence</a>
				        </li>
				        
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Afficher les statistiques</a>
				        </li>
				        
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Exporter les données</a>
				        </li>
				        				  
				    </ul> 
			    </div>
			    
				<div class="col-xs-10">
					<div class="container-fluid" style="background:white">
					    <h1>Médecin</h1>
						<p>Bienvenue sur la partie Médecin du Projet ESTER</p>
					</div>
				</div>
			</div> 
			<div class="row container">
				<c:if test="${param.page == 'createSalarie'}">
					<div class="container">
				     <form class="pt-2 row" id="saisi" method="post">
						<input type="submit" value="Génerer code patient ">        
					 </form>  	
					 <p class="row"> 
				     		${ empty message ? '' : message }
				     </p>	  	        
			 		</div>
				</c:if>
			</div>
		</div>
    
</body>
</html>