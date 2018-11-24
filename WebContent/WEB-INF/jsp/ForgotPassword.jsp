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
	        <div class="col-md-4" style="text-align:center;"><img src="<c:url value="/img/irset.png"/>" alt="Logo-ister" width="205" height="90"></div>
	        <div class="col-md-4" style="text-align:center;"><img src="<c:url value="/img/ua_h.png"/>" alt="Logo-Université-Angers" width="190" height="62"></div>
	        <div class="col-md-4" style="text-align:center;"><img src="<c:url value="/img/Sante_publique.jpg"/>" alt="Logo-Santé_publique_France" width="205" height="90"></div>
	        
	    </div>	
	  	<div class="row">
	
		    <form class="form-signin" method="post">
			  <div class="text-center mb-4">
			       <div class="row">        
			      		 <div class="col-md-12 col-centered "><h5 class="h5 mb-3 font-weight-normal">Veuillez saisir votre email</h5></div>
			       </div>
		
				 	<div class="form-label-group">
				        <input type="email" name="Email" id="Email" value="${empty email ? '' : email}" class="form-control"  required>
				        <label for="Email">email</label>
				    </div>
				    <!-- afficher email envoyer ou email non existant -->
				     <div class="row">  
			      		 <div class="col-md-12 col-centered "><strong style="color:red"> ${message } </strong></div>
			        </div>
			        
				    <c:if test="${not empty Success}">
				      <div class="alert alert-success alert-dismissible" role="alert">
			          	<strong>Succès</strong> <c:out value = "${Success}"/> <c:remove var="Success" scope="session" />
				        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				   </c:if>
	
				    <c:if test="${not empty Warning}">
				      <div class="alert alert-danger alert-dismissible" role="alert">
			          <strong>Erreur </strong> <c:out value = "${Warning}"/>
				        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				    </c:if>
				   <button class="btn btn-lg btn-primary btn-block" type="submit">VALIDER</button>
		    		    
			 </div>	             
		   </form>
    </div>
    </div>
   <c:import url="/jsp/Footer.jsp"/>
    
  </body>
</html>
