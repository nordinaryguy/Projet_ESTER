<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	
	<meta charset="UTF-8">
	<link rel="icon" href="<c:url value="/img/ua.png"/>">
	
	<title>ESTER</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/default.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

</head>
<body>

  	<c:import url="/jsp/Menu.jsp"/>

  			<div class="row">
  			  		
			    <div class="col-md-2" style="background: repeating-linear-gradient(-45deg, #0097ae, #0097ae 4px, #00889b 4px, #0097ae 6px);">				       
				        <ul style="color:white;">
					  	<li>
				       		<a style="color:white;" href="<c:url value="/resultat"/>">Résultats globaux</a>
				        </li>
				        
				        <li>
				       		<a style="color:white;" href="<c:url value="/jsp/EnDev.jsp"/>">Résultats par poste</a>
				        </li>
				        				  
				    </ul> 	        				  
			 </div>
			    
				<div class="col-md-10">
					<div class="container-fluid" id="container" style="background:white">
					    <h1>Entreprise</h1>
						<p>Bienvenue sur la partie Entreprise du Projet ESTER</p>    
					</div>
				</div>
			</div> 
		
	<c:import url="/jsp/Footer.jsp"/>
		
</body>
</html>