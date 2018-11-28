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

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/Accueil.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

</head>
<body>
  		<c:import url="/jsp/Menu.jsp"/>
  
 			<div class="container-fluid" id="container">


			<div class="row justify-content-center pb-2">
		        <div class="col-md-2" style="text-align:center;"><img src="<c:url value="/img/irset.png"/>" alt="Logo-ister" width="205" height="90"></div>
		        <div class="col-md-2" style="text-align:center;"><img src="<c:url value="/img/ua_h.png"/>" alt="Logo-Université-Angers" width="190" height="62"></div>
		        
		    </div>

			  <div class="row">
			  	
			    <form class="form-signin">
			      <div class="text-center mb-4">
    
				       <div class="row">        
				      		 <div class="col-md-12 col-centered ">
				      		 	<h5 class="h5 mb-3 font-weight-normal">Veuillez saisir vos identifiants</h5>
				      		 </div>
				      </div>

				 	  <div class="form-label-group">
				        <input type="email" id="adress_Email" class="form-control" placeholder="Email" required>
				        <label for="adress_Email">Adresse Email</label>
				      </div>
      
				      <div class="form-label-group">
				        <input type="password" id="inputNewPassword" class="form-control" placeholder="Password" required>
				        <label for="inputNewPassword">Mot de Passe</label>
				      </div>
      
				      <div class="form-label-group">
				        <input type="password" id="inputNew2Password" class="form-control" placeholder="Password" required>
				        <label for="inputNew2Password"> Confirmer le Mot de Passe</label>
				      </div>      
				      
      				<button class="btn btn-lg btn-primary btn-block" type="submit">VALIDER</button>
				 </div>   	             
    		</form>
    	</div>
    </div>
    
    <c:import url="/jsp/Footer.jsp"/>
    
</body>
</html>
