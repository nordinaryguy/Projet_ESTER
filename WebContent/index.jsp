<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr-FR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/img/ua.png"/>">

    <title>ESTER - Accueil</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/Accueil.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    
</head>
<body>
  	<c:import url="/jsp/Menu.jsp"/>
  	  
  	<div class="container">
  	
  	<div class="row justify-content-center pb-2">
        <div class="col-md-6" style="text-align:center;"><img src="<c:url value="/img/irset.png"/>" alt="Logo-ister" width="205" height="90"></div>
        <div class="col-md-6" style="text-align:center;"><img src="<c:url value="/img/ua_h.png"/>" alt="Logo-Université-Angers" width="190" height="62"></div>
        
    </div>
  	 	
  		<div class="card">
		  <div class="card-body">
		    <h5 class="card-title">Bienvenue</h5>
		    <p class="card-text">Vous êtes sur le projet Ester.</p>
		  </div>
		</div>	
  	</div>
  	  	<c:import url="/jsp/Footer.jsp"/>
</body>
</html>