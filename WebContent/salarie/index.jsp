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
    <link rel="icon" href="<c:url value="/img/ua.png"/>">

    <title>ESTER</title>

		<link rel="stylesheet" href="<c:url value="/css/default.css"/>">
	
	<link rel="stylesheet" href="<c:url value="/css/form-patient.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/populateSelect.js"/>"></script>
		
</head>

<body>  

	<!-- Menu en header de la page -->						
	    <c:import url="/jsp/Menu.jsp"/>
  			<div class="row">
  			
  			<!-- Menu pour salarié -->    
  			  			
  				<div class="col-md-2" style="background: repeating-linear-gradient(-45deg, #0097ae, #0097ae 4px, #00889b 4px, #0097ae 6px);">
			  		<ul style="color:white;">
				  		<li>
				        	<a style="color:white;" href="<%= request.getContextPath()%>/salarie?page=modifierProfil">Modifier mon profil</a>
				        </li>
				        
				        <li>
				        	<a style="color:white;" href="<c:url value="/jsp/EnDev.jsp"/>">Voir les questionnaires</a>
				        </li>
				        
				        <li>
				        	<a style="color:white;" href="<c:url value="/jsp/EnDev.jsp"/>">Voir les statistiques</a>
				        </li>	        				  
				    </ul> 
			    </div>
			
			
			<!-- Container du contenu du salarié -->    
				<div class="col">
					<div class="container-fluid" id="container" style="background:white">	
						<h1>Salarié</h1>
						<p>Bienvenue sur la partie Salarié du Projet ESTER</p>
						<c:import url="/jsp/Alert.jsp"/>
						<div class="conainer-fluid">
							<c:if test="${FirstConnexion}">
								<c:import url="/jsp/FormPatient.jsp"/>
							</c:if>	
						</div>
					</div>
				</div>
			</div>
			
			
	<!-- Footer de la page -->						
		<c:import url="/jsp/Footer.jsp"/>
</body>
</html>