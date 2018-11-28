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

    <link rel="stylesheet" href="<c:url value="/css/default.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/form-patient.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/populateSelect.js"/>"></script>
    
</head>

<body >  
	
			<c:import url="/jsp/Menu.jsp"/>
	


  			<div class="row">
 				 <div class="col-md-2" style="background: repeating-linear-gradient(-45deg, #0097ae, #0097ae 4px, #00889b 4px, #0097ae 6px);">
			  		<ul style="color:white;">
				  		<li>
				        	<a href="#" style="color:white;">Modifier mon profil</a>
				        </li>
				        
				        <li>
				        	<a href="#" style="color:white;">Voir les questionnaires</a>
				        </li>
				        
				        <li>
				        	<a href="#" style="color:white;">Voir les statistiques</a>
				        </li>	        				  
				    </ul> 
			    
				<div class="col-md-10">
					<div class="container-fluid" style="background:white">	
						<h1>Salarié</h1>
						<p>Bienvenue sur la partie Salarié du Projet ESTER</p>
					</div>
				</div>
			</div> 
		</div>
	
  <c:import url="/jsp/Footer.jsp"/>
	
    
</body>
</html>