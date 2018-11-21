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
  
  <div class="container-fluid" id="container">
  
  <div class="row">
  	
    <form class="form-signin">
      <div class="text-center mb-4">
            
        <div class="row">
       		 <div class="col-md-6 pl-2"><img class="mb-4" src="http://ester.univ-angers.fr/_resources-images/logo/logo-labo_max0x0.png" alt="" width="205" height="90"></div>
       		 <div class="col-md-6 pr-2"><img class="mb-4" src="http://www.univ-angers.fr/_contents-images/ametys-internal%253Asites/univangers/ametys-internal%253Acontents/logo-article-8/_metadata/content/_data/ua_h_couleur_ecran.png_57x189" alt="" width="189" height="57"></div>
      </div>    
      
           
       <div class="row">        
      		 <div class="col-md-12 col-centered "><h5 class="h5 mb-3 font-weight-normal">Veuillez saisir vos identifiants</h5></div>
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
    
     <div class="row pt-3">
 		<div class="col-md-6" ><a href="#">Mot de passe oublié</a></div>
	 </div>
	 
	 
	 </div>
     	             
    </form>
    </div>
    </div>
    
      	<c:import url="/jsp/Footer.jsp"/>
    
  </body>
  
  
</html>
