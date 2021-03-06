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

    <title>Accueil - ESTER </title>

	<link rel="stylesheet" href="<c:url value="/css/default.css"/>">
	
	<link rel="stylesheet" href="<c:url value="/css/form-patient.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/populateSelect.js"/>"></script>
	<script src="<c:url value="/js/checkPass.js"/>"></script>
		
</head>

<body >  
	    <c:import url="/jsp/Menu.jsp"/>
	    
  			<div class="row"> 			
  				<div class="col-md-2" style="background: repeating-linear-gradient(-45deg, #0097ae, #0097ae 4px, #00889b 4px, #0097ae 6px);">
			  		<ul style="color:white;">
			  		
			  		<c:if test="${sessionScope.sessionUtilisateur.isPreventeur()}">	
			  		
			  		<!-- Connection en tant que Préventeur -->
			  
			  			<li class="dropdown">
						        <a style="color:white;" class="dropdown-toggle" href="#" id="gestionSalariesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          Gestion des salariés
						        </a>	 
								<div class="dropdown-menu" aria-labelledby="gestionSalariesMenu">
									 	<a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=createSalarie">Créer un compte salarié</a>
							          	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Liste des salariés</a>
							          	<a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Profil du salarié</a>		
							    </div>
						    </li>
	
					        <li>
			          			 <a style="color:white;" href='<%= request.getContextPath()%>/utilisateur?page=donnerQuestionnaire"/>'>Administrer les questionnaires</a>	
					        </li>
					        
					        <li>
					      		<a style="color:white;" href="<c:url value="/resultat"/>" >Afficher les statistiques</a>
					        </li>	
			  		</c:if>
			  					  					  		
			  		<c:if test="${sessionScope.sessionUtilisateur.isInfirmier()||sessionScope.sessionUtilisateur.isAssistant()}">
			  		
			  		<!-- Connection en tant que Infirmier/Assistant -->
			  
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
			          			 	<a style="color:white;" href="<%= request.getContextPath()%>/utilisateur?page=donnerQuestionnaire">Administrer les questionnaires</a>	
					        </li>
					        
					        <li>
					        	<a style="color:white;" href="<c:url value="/resultat"/>">Afficher les statistiques</a>
					        </li>
			  		</c:if>
			  		
			  		
			  		<c:if test="${sessionScope.sessionUtilisateur.isAdministrateur()}">	
			  		
			  			 <!-- Connection en tant que Administrateur -->
			  
			  			<li>
				       		 <a class="dropdown-toggle" href="#" id="creationComptes" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white;">
					          Création de compte
						      </a>		 
							  <div class="dropdown-menu" aria-labelledby="creationComptes">
							          <a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=createUser">Administrateur/Médecin/Infirmiers/Préventeurs/Assistants</a>
							          <a class="dropdown-item" href="<c:url value="/jsp/EnDev.jsp"/>">Entreprises</a>
						          	  <a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=createSalarie">Salariés</a>
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
					          <a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=donnerQuestionnaire">Soumettre un questionnaire</a>	
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
			  		
			  		
			  		<c:if test="${sessionScope.sessionUtilisateur.isMedecin()}">
			  			
			  			<!-- Connection en tant que Médecin -->
			  		
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
		          			 	<a class="dropdown-item" href="<%= request.getContextPath()%>/utilisateur?page=donnerQuestionnaire">Administrer les questionnaires</a>	
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
					
						<c:if test="${sessionScope.sessionUtilisateur.isMedecin()}">	
					
				<!-- Connection en tant que Médecin -->
					
					
						    <h1>Médecin</h1>
							<p>Bienvenue sur la partie Médecin du Projet ESTER</p>			
						</c:if>
			
						
						<c:if test="${sessionScope.sessionUtilisateur.isAdministrateur()}">	
				<!-- Connection en tant que Administrateur -->
						
							<h1>Administrateur</h1>
							<p>Bienvenue sur la partie Administrateur du Projet ESTER</p>  		
						</c:if>

					
						<c:if test="${sessionScope.sessionUtilisateur.isPreventeur()}">	
				<!-- Connection en tant que Préventeur -->
						
							<h1>Préventeur</h1>
							<p>Bienvenue sur la partie Préventeur du Projet ESTER</p>
						</c:if>
												
							
						<c:if test="${sessionScope.sessionUtilisateur.isAssistant()}">
						
				<!-- Connection en tant que Assistant -->
		
							<h1>Assistant</h1>
							<p>Bienvenue sur la partie Assistant du Projet ESTER</p>
						</c:if>
						
						<c:if test="${sessionScope.sessionUtilisateur.isInfirmier()}">	
				<!-- Connection en tant que Infirmier -->
			
							<h1>Infirmier</h1>
							<p>Bienvenue sur la partie Infirmier du Projet ESTER</p>
						</c:if>
									
						<c:if test="${param.page == 'createUser'}">
				<!-- Création d'un compte Utilisateur -->
								<div class="row pt-2">
							     	 <c:import url="/jsp/Alert.jsp"/>
							 	</div>
								<div class="row pt-2">
							     	 <c:import url="/jsp/createAccount.jsp"/>
								</div>
								
						</c:if>
						
						
						<c:if test="${param.page == 'createSalarie'}">
						
					<!-- Création d'un compte Salarié -->
			
								<div class="row pt-2">
								     <form class="col" id="saisi" method="post">
										<input class="btn btn-info" type="submit" value="Génerer code patient ">        
									 </form>  	
									 <p class="col"> 
									 	<strong>
								     		${ empty message ? '' : message }
								     	</strong> 		     		
								     </p>
						 		</div>
						</c:if>
		
						
						<c:if test="${param.page == 'configurationServeurMail'}">
						
						<!-- Configuration du serveur Mail -->
						
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
							            -
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
						
						
							
							<c:if test='${param.page == "ModifierMotDePasse"}'>
							
											<!-- Changement de Mot de Passe -->
								<div class="row pt-2"> 
								
									<form  id="saisi" method="post">
									 <c:if test="${not empty Warning}">
								      <div class="alert alert-danger alert-dismissible" role="alert">
							          <strong>Erreur</strong> <c:out value = "${Warning}"/> <c:remove var="Warning" scope="session" />
								        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								    </c:if>
								    <c:if test="${not empty Success}">
		    	
								      <div class="alert alert-success alert-dismissible" role="alert">
							          <strong>Succès</strong> <c:out value = "${Success}"/> <c:remove var="Success" scope="session" />
								        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								    </c:if>
									     <div class="pt-2">
												<input type="password" id="inputOldPassword" name="oldPassword" class="form-control" placeholder="Ancien Mot de Passe" required>
												<div class="col pb-4"></div>
								   		 </div> 
								   		 
								   		 <div class="pt-2">								   		 	
												<input type="password" id="inputNewPassword" name="newPassword" class="form-control" placeholder="Nouveau Mot de Passe" onkeyup="return passwordChanged('inputNewPassword');"  onBlur="checkPass('inputNewPassword','inputNew2Password')" required>
								   				<span id="strength" class="col col-xs-2"></span>
								   		 </div> 
								   		 
								   		 <div class="pt-2">
								   		 		<input type="password" id="inputNew2Password" name="confirm" class="form-control" placeholder="Confirmez" onkeyup="checkPass('inputNewPassword','inputNew2Password')"  required>
								   		 </div> 
								   		 
									   	<div id="divcomp">
											   	<div class="row" >
														          		
										      	</div>
										 </div>
								   		 <div class="row pt-2">
									  		  <div class="col"><input type="submit" class="btn btn-info" value="Valider" id="submit" style="float:right;"></div>
									  		  <div class="col"><input type="reset" class="btn btn-danger" value="Annuler"></div>  		  
									  		  
								   		 </div> 
								   		
									</form>
								</div>	
    						</c:if>	
    						
    						<c:if test="${param.page == 'donnerQuestionnaire'}">
				<!-- Attribuer questionnaire à un Salarié -->
				
								<div class="row pt-2">
							     	 <c:import url="/jsp/Alert.jsp"/>
							 	</div>
				
								<div class="row pt-2">
							     	 <c:import url="/jsp/giveQuestionnaire.jsp"/>
								</div>
						</c:if>
										
					</div>
				</div>
			</div> 
						
		    <c:import url="/jsp/Footer.jsp"/>
</body>
</html>