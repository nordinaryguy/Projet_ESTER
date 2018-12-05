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

    <title>Réinitialisation de mot de passe - ESTER</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/Accueil.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	
	<script src="<c:url value="/js/checkPass.js"/>"></script>
     <link rel="stylesheet" href="<c:url value="/css/form-reset.css"/>">

</head>

<body>
  	<c:import url="/jsp/Menu.jsp"/>
  	
  	<div class="container-fluid" id="container">
	  	<div class="row justify-content-center">
			<div class="text-center mb-4">
			     <c:import url="/jsp/Alert.jsp"/>
			      <c:if test="${valid}">  
				       <div class="row">
							<c:import url="/jsp/resetPassword.jsp"/>
					   </div>
				 </c:if>
				
				<c:if test="${not valid}">
					<div class="container form-reset">
			      	  	    <div class="form-title-row">
					                <h3>Réinitialisation mot de passe </h3>
					        </div>
			      	  		<div class="row">
			      	  			<div class="col-md-12 pr-1"><img  class="rounded" src="/Projet_ESTER/img/error.svg.png" alt="" width="90" height="90"></div>
			      	  		</div>
			      	  		<div class="alert alert-danger" role="alert">
								<h5>Le lien pour réinitialiser le mot de passe a expiré ou n'a jamais existé</h5>
					   		</div>
			      	  </div>
				</c:if>
				</div>	           
			   
	    </div>
	 </div>
    
     <c:import url="/jsp/Footer.jsp"/>
    
</body>
</html>
