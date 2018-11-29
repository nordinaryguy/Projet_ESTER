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

<body >  
	    <c:import url="/jsp/Menu.jsp"/>
	    
  			<div class="row"> 			
  				<div class="col-md-2" style="background: repeating-linear-gradient(-45deg, #0097ae, #0097ae 4px, #00889b 4px, #0097ae 6px);">
			  		<ul style="color:white;">
			  		
		<!-- Connection en tant que Préventeur -->
			  		<c:if test="${sessionScope.sessionUtilisateur.isPreventeur()}">	
			  			<li class="dropdown">
						        <a style="color:white;" class="dropdown-toggle" href="#" id="gestionSalariesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          Gestion des salariés
						        </a>	 
								<div class="dropdown-menu" aria-labelledby="gestionSalariesMenu">
									 	<a class="dropdown-item" href="<%= request.getContextPath()%>/preventeur?page=createSalarie">Créer un compte salarié</a>
							          	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Liste des salariés</a>
							          	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Profil du salarié</a>		
							    </div>
						    </li>
	
					        <li>
			          			 	<a style="color:white;" href="<%= request.getContextPath()%>/questionnaire">Administrer les questionnaires</a>	
					        </li>
					        
					        <li>
					      		<a style="color:white;" href="<c:url value="/resultat"/>">Afficher les statistiques</a>
					        </li>	
			  		</c:if>
			  		
		<!-- Connection en tant que Infirmier/Assistant -->
			  					  		
			  		<c:if test="${sessionScope.sessionUtilisateur.isInfirmier()||sessionScope.sessionUtilisateur.isAssistant()}">
			  			<li class="dropdown">
						        <a  style="color:white;" class="dropdown-toggle" href="#" id="gestionSalariesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						        	Gestion des salariés
						        </a>	 
									<div class="dropdown-menu" aria-labelledby="gestionSalariesMenu">
							         	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>" >Liste des salariés</a>
							        	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Profil du salarié</a>		
							        </div>
						    </li>
				
					        <li>
			          			 	<a style="color:white;" href="<%= request.getContextPath()%>/questionnaire">Administrer les questionnaires</a>	
					        </li>
					        
					        <li>
					        	<a style="color:white;" href="<c:url value="/resultat"/>">Afficher les statistiques</a>
					        </li>
			  		</c:if>
			  		
			 <!-- Connection en tant que Administrateur -->
			  		
			  		<c:if test="${sessionScope.sessionUtilisateur.isAdministrateur()}">	
			  			<li>
				       		 <a class="dropdown-toggle" href="#" id="creationComptes" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white;">
					          Création de compte
						      </a>		 
							  <div class="dropdown-menu" aria-labelledby="creationComptes">
							          <a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=createUser">Administrateur/Médecin/Infirmiers/Préventeurs/Assistants</a>
							 </div>			       		
				        </li>
			  		
				  		<li>
					        <a style="color:white;" class="dropdown-toggle" href="#" id="gestionComptesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Gestion des comptes
					        </a>		 
								 <div class="dropdown-menu" aria-labelledby="gestionComptesMenu">
						          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Administrateur</a>
						          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Médecins</a>
						          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Préventeurs</a>
						          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Infirmiers</a>
						          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Assistants</a>
						          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Entreprises</a>
						          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Salariés</a>
								</div>
						</li>				        
						
						<li>
				        	<a href="<c:url value="/jsp/EnDev.jsp"/>" style="color:white;">Modifier les valeurs de référence</a>
				        </li>		
				        
						<li class="dropdown">
				       		<a style="color:white;" class="dropdown-toggle" href="#" id="gestionQuestionnaireMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion des questionnaires</a>
						 
							 <div class="dropdown-menu" aria-labelledby="gestionQuestionnaireMenu">
					          <a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur/generateur_questionnaire">Créer un questionnaire</a>
					          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Modifier un questionnaire</a>
					          <a class="dropdown-item" href="<%= request.getContextPath()%>/questionnaire">Modifier la gestion des questionnaires</a>	
					        </div>
					   	</li>	        
				              
				        <li>
				       		<a href="<c:url value="/jsp/EnDev.jsp"/>" style="color:white;">Gestion Base de Données</a>
				        </li>
				        
				       	<li>
				        	<a style="color:white;" href='<c:url value="/jsp/EnDev.jsp"/>'>Gestion Interface</a>
				        </li>
				        
				        <li>
				        	<a style="color:white;" href="<%= request.getContextPath()%>/resultat">Statistiques</a>
				        </li>
				        
				        <li>
				        	<a style="color:white;" href="<c:url value="/jsp/EnDev.jsp"/>">Exporter les données</a>
				        </li>
				        
				        <li>
				        	<a style="color:white;" href="<%= request.getContextPath()%>/utilisateur?page=configurationServeurMail">Configuration Serveur Mail</a>
				        </li>		  		
			  		</c:if>
			  		
		<!-- Connection en tant que Médecin -->
			  		
			  		<c:if test="${sessionScope.sessionUtilisateur.isMedecin()}">	
			  		
				  		<li>
					        <a class="dropdown-toggle" href="#" id="gestionComptesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white;">
					          Création de compte
					        </a>		 
								 <div class="dropdown-menu" aria-labelledby="gestionComptesMenu">
						         	<a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=createUser">Infirmiers/Préventeurs/Assistants</a>
						          	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Entreprises</a>
						          	<a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=createSalarie">Salariés</a>
								</div>
						</li>
						
						<li class="dropdown">
					        <a class="dropdown-toggle" href="#" id="gestionSalariesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white;">
					          Gestion des salariés
					        </a>	 
								 <div class="dropdown-menu" aria-labelledby="gestionSalariesMenu">
						         	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Liste des salariés</a>
						         	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Profil du salarié</a>		
						       	 </div>
						</li>		
				        
						<li class="dropdown">
				       		<a class="dropdown-toggle" href="#" id="gestionQuestionnaireMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white;">Gestion des questionnaires</a>
						 
							 <div class="dropdown-menu" aria-labelledby="gestionQuestionnaireMenu">
					         	<a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur/generateur_questionnaire">Créer un questionnaire</a>
					         	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Modifier un questionnaire</a>
		          			 	<a class="dropdown-item" href="<%= request.getContextPath()%>/questionnaire">Administrer les questionnaires</a>	
					         </div>
					   	</li>	        
				              
				        <li>
				        	<a href="<c:url value="/jsp/EnDev.jsp"/>" style="color:white;">Modifier les valeurs de référence</a>
				        </li>
				        
				        <li>
				        	<a href="<c:url value="/resultat"/>" style="color:white;">Afficher les statistiques</a>
				        </li>
				        
				        <li>
				        	<a href="<c:url value="/jsp/EnDev.jsp"/>" style="color:white;">Exporter les données</a>
				        </li>
				       </c:if>	
				        
				        				  
				    </ul> 
			    </div>
			    
				<div class="col-md-10">
					<div class="container-fluid" style="background:white">
					
		<!-- Connection en tant que Médecin -->
			
						<c:if test="${sessionScope.sessionUtilisateur.isMedecin()}">	
					
						    <h1>Médecin</h1>
							<p>Bienvenue sur la partie Médecin du Projet ESTER</p>			
						</c:if>
			
		<!-- Connection en tant que Administrateur -->
						
						<c:if test="${sessionScope.sessionUtilisateur.isAdministrateur()}">	
							<h1>Administrateur</h1>
							<p>Bienvenue sur la partie Administrateur du Projet ESTER</p>  		
						</c:if>

		<!-- Connection en tant que Préventeur -->
					
						<c:if test="${sessionScope.sessionUtilisateur.isPreventeur()}">	
							<h1>Préventeur</h1>
							<p>Bienvenue sur la partie Préventeur du Projet ESTER</p>
						</c:if>
												
		<!-- Connection en tant que Assistant -->
							
						<c:if test="${sessionScope.sessionUtilisateur.isAssistant()}">
							<h1>Assistant</h1>
							<p>Bienvenue sur la partie Assistant du Projet ESTER</p>
						</c:if>
		<!-- Connection en tant que Infirmier -->
						
						<c:if test="${sessionScope.sessionUtilisateur.isInfirmier()}">	
							<h1>Infirmier</h1>
							<p>Bienvenue sur la partie Infirmier du Projet ESTER</p>
						</c:if>

		<!-- Création d'un compte Utilisateur -->
					
						<c:if test="${param.page == 'createUser'}">
								<div class="row pt-2">
							     	 <c:import url="/jsp/createAccount.jsp"/>
								</div>
								<div class="row pt-2">
							     	 <c:import url="/jsp/Alert.jsp"/>
							 	</div>
						</c:if>
						
		<!-- Création d'un compte Entreprise -->
						
						<c:if test="${param.page == 'createSalarie'}">
								<div class="row pt-2">
								     <form class="col" id="saisi" method="post">
										<input class="btn btn-info" type="submit" value="Génerer code patient ">        
									 </form>  	
									 <p class="col"> 
								     		${ empty message ? '' : message }
								     </p>	  	        
						 		</div>
						</c:if>
		
		<!-- Configuration du serveur Mail -->
						
						<c:if test="${param.page == 'configurationServeurMail'}">
								<div class="container-fluid row">
							    	<form class="form-signin" method="post">
							            <div class="form-label-group">
							                <h3>Configuration serveur mail : </h3>
							            </div>
							
							            <div class="form-row">
							               <div class="form-label-group">
							               		<label for="emailSender">Serveur email</label>
										        <input type="email" id="emailSender" name="emailSender" placeholder="${empty email ? '' : email}" class="form-control"  required>
										    </div>
							            </div>
										
										 <div class="form-row">
							               <div class="form-label-group">
							               		<label for="password">Mot de passe</label>
										        <input type="password" id="password" name="password" placeholder="password" class="form-control"  required>
										        
										    </div>
							            </div>
							            
										<div class="form-row">
							               <div class="form-label-group">
							               		<label for="host">Host</label>
										        <input type="text" id="host" name="host" placeholder="${empty host ? '' : host}" class="form-control"  required>
										        
										    </div>
							            </div>
							            
							            <div class="form-row">
							               <div class="form-label-group">
							               		 <label for="port">Port</label>
										        <input type="number" id="port" name="port" placeholder="${empty port ? '' : port}" class="form-control"  required>
										       
										    </div>
							            </div>
							            <!-- afficher serveur modifier-->
							            <br/>
									    <c:if test="${not empty Success}">
									      <div class="alert alert-success alert-dismissible" role="alert">
								          	<strong>Succès</strong> <c:out value = "${Success}"/> <c:remove var="Success" scope="session" />
									        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
									          <span aria-hidden="true">&times;</span>
									        </button>
									      </div>
									   </c:if>
							            
							            <div class="form-row" style="padding-right:50px;">
										  		  <div class="col"><input type="submit" class="btn btn-info" value="Valider" style="float:right;"></div>
										  		  <div class="col"><input type="reset" class="btn btn-danger" value="Annuler"></div>  		  
							            </div>
							        </form>	        
							 	</div>
							</c:if>				
					</div>
				</div>
			</div> 
						
		    <c:import url="/jsp/Footer.jsp"/>
</body>
</html>