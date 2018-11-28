<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ESTER</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/Accueil.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</head>
<body>
  	<c:import url="/jsp/Menu.jsp"/>

<div class="pre-scrollable container-fluid">
  			<div class="row">
  
				<nav class="col-xs-2 navbar navbar-collapse bg-nav">
			    	<button class="navbar-toggler btn btn-outline-primary my-2 my-sm-0 " type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">Menu
			      	<span class="navbar-toggler-icon"></span>
			    	</button>
			  	</nav>
				 <div class="collapse" id="navbarToggleExternalContent">
			  		<ul>
					  	<li class="nav-item">
				       		<a class="nav-link" href="<c:url value="/resultat"/>">Résultats globaux</a>
				        </li>
				        
				        <li class="nav-item">
				       		<a class="nav-link" href="<c:url value="jsp/EnDev.jsp"/>">Résultats par poste</a>
				        </li>
				        				  
				    </ul> 
			    </div>
			    
				<div class="col">
					<div class="container-fluid" id="container" style="background:white">
					    <h1>Entreprise</h1>
						<p>Bienvenue sur la partie Entreprise du Projet ESTER</p>    
					</div>
				</div>
			</div> 
		</div>
		
		  	<c:import url="/jsp/Footer.jsp"/>
		
</body>
</html>