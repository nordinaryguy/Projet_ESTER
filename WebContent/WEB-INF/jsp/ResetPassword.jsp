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
	
	<script src="<c:url value="/js/checkPass.js"/>"></script>
     <link rel="stylesheet" href="<c:url value="/css/form-reset.css"/>">

</head>

<body>
  	<c:import url="/jsp/Menu.jsp"/>
  	
  	<div class="container-fluid" id="container">
  	
	  	<div class="row justify-content-center pb-2">
		       <div class="col-md-2" style="text-align:center;"><img src="<c:url value="/img/irset.png"/>" alt="Logo-ister" width="205" height="90"></div>
		       <div class="col-md-2" style="text-align:center;"><img src="<c:url value="/img/ua_h.png"/>" alt="Logo-Université-Angers" width="190" height="62"></div>				        
		</div> 
  	
	  	<div class="row justify-content-center">
			<div class="text-center mb-4">
			     
			      <c:if test="${valid}">  
				       <div class="row">
							<form class="form-reset" method="post">
					            <div class="form-title-row">
					                <h3>Veuillez entrer un nouveau mot de passe  </h3>
					            </div>
								<div class="form-row">	
					               <div class="col-xs-12 center-block text-center"> 
					               		<strong>${message} </strong>
					               </div>
					            </div>
					            <div class="form-row">
									<span>Email : </span> 		
					               <div class="col-xs-12 center-block text-center"> 
					               		<strong>${email} </strong>
					               </div>
					            </div>
					            
					            <div class="form-row">
					          		<label for=#password>
										Nouveau mot de passe : 
									</label>		
					                 <input type='password' name='password' id='pass_1' onkeyup="return passwordChanged();"  onBlur="checkPass()" required>
					            	 <span id="strength" class="col col-xs-2"></span>
					            </div> 
					            <div class="row" >
					          		
					          	</div>
					           <div class="form-row">
					          		<label>
										Confirmer le mot de passe : 	
									</label>	
					                <input type="password" name="passwordConfirm" id="pass_2" onBlur="checkPass()" required>
					           </div>
					           <div id="divcomp">
						          	<div class="row" >
						          		
						          	</div>
					          </div>
					          <div class="row showPass">
					            	 <label>
					            	 	<input type="checkbox" id="showPass" onchange="document.getElementById('pass_2').type = this.checked ? 'text' : 'password';document.getElementById('pass_1').type = this.checked ? 'text' : 'password'">Mot de passe visible
					            	 </label>
					          </div>
					          <div class="row">
					          		<button id="submit" class="btn  btn-primary" type="submit" disabled>VALIDER</button>
					          </div>
					    </form>
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
