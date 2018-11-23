<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ESTER</title>
<link rel="stylesheet" href="<c:url value="/css/Acceuil.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/form-patient.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/populateSelect.js"/>"></script>
	
</head>
<body>
	    <c:import url="/jsp/Menu.jsp"/>

<div class="pre-scrollable container-fluid">
  			<div class="row">
  
				<nav class="col-xs-2 navbar navbar-collapse bg-nav">
			    	<button class="navbar-toggler btn btn-outline-primary my-2 my-sm-0 " type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">Menu
			      	<span class="navbar-toggler-icon"></span>
			    	</button>
			  	</nav>
				 <div class="collapse" id="navbarToggleExternalContent">
			  		<ul>
			  		
			  			<li class="nav-item">
				       		<a class="nav-link" data-toggle="modal" data-target="#CreerCompte" href="#">Création des comptes</a>			       		
				        </li>
			  		
				  		<li class="nav-item dropdown">
					        <a class="nav-link dropdown-toggle" href="#" id="gestionComptesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Gestion des comptes
					        </a>		 
								 <div class="dropdown-menu" aria-labelledby="gestionComptesMenu">
						          <a class="dropdown-item" href="#">Administrateur</a>
						          <a class="dropdown-item" href="#">Médecins</a>
						          <a class="dropdown-item" href="#">Préventeurs</a>
						          <a class="dropdown-item" href="#">Infirmiers</a>
						          <a class="dropdown-item" href="#">Assistants</a>
						          <a class="dropdown-item" href="#">Entreprises</a>
						          <a class="dropdown-item" href="#">Salariés</a>
								</div>
						</li>				        
						
						<li class="nav-item">
				        	<a class="nav-link" href="#">Modifier les valeurs de référence</a>
				        </li>		
				        
						<li class="nav-item dropdown">
				       		<a class="nav-link dropdown-toggle" href="#" id="gestionQuestionnaireMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion des questionnaires</a>
						 
							 <div class="dropdown-menu" aria-labelledby="gestionQuestionnaireMenu">
					          <a class="dropdown-item" href="#">Créer un questionnaire</a>
					          <a class="dropdown-item" href="#">Modifier un questionnaire</a>
					          <a class="dropdown-item" href="#">Modifier la gestion des questionnaires</a>	
					        </div>
					   	</li>	        
				              
				        <li class="nav-item">
				       		<a class="nav-link" href="#">Gestion Base de Données</a>
				        </li>
				        
				       	<li class="nav-item">
				        	<a class="nav-link" data-toggle="modal" data-target="#ModifierInterface" href="#">Gestion Interface</a>
				        </li>
				        
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Statistiques</a>
				        </li>
				        
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Exporter les données</a>
				        </li>
				        				  
				    </ul> 
			    </div>
			    
				<div class="col">
					<div id="container" class="container-fluid" style="background:white">
					    <h1>Administrateur</h1>
						<p>Bienvenue sur la partie Administrateur du Projet ESTER</p>    
					</div>
				</div>
			</div> 
		</div>
	</div>
	
	
	<div class="modal" id="CreerCompte">
			<div class="modal-dialog">
			    <div class="modal-content">
						
						      <!-- Modal Header -->
				      <div class="modal-header">
					        <h4 class="modal-title">Créer un nouveau compte</h4>
					       	<button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
						
						      <!-- Modal body -->
				      <div class="modal-body">
					      	 <label for="typeCompte">Choisissez un type de compte :</label>		     
						     <select id="typeCompte" size="1">
							     <option>Médecin</option>
								 <option>Assistant</option>
							     <option>Infirmier</option>
							     <option>Préventeur</option>
						     </select>
							     
						     <div class="pt-2">
							        <input type="email" id="adress_Email" class="form-control" placeholder="Adresse Email" required>
							      </div>
								    		        
						      </div>
						
						      <!-- Modal footer -->
						   	  <div class="modal-footer">
						      	<button type="button" class="btn btn-outline-primary" data-dismiss="modal">Valider</button>
						        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Annuler</button>
						      </div>
						
					</div>
		  </div>
	</div>
	
	<div class="modal" id="ModifierInterface">
			<div class="modal-dialog">
			    <div class="modal-content">
						
						      <!-- Modal Header -->
				      <div class="modal-header">
					        <h4 class="modal-title">Modification d'Interface</h4>
					       	<button type="button" class="close" data-dismiss="modal">&times;</button>
				      </div>
						
						      <!-- Modal body -->
				      <div class="modal-body">
					      	 <label for="typePage">Choisissez la page à modifier :</label>		     
						     <select id="typePage" size="1">
						     	 <option value="Accueil.html">Accueil</option>
						     	 <option value="PremiereConnexionParMedecin.html">Première Connexion pour les Soignants</option>
								 <option value="PremiereConnexionPourSalaries.html">Première Connexion pour les Salariés</option>
						     	 <option value="Administrateur.html">Adminsitrateur</option>
							     <option value="Medecin.html">Médecin</option>
								 <option value="Assistant.html">Assistant</option>
							     <option value="Infirmier.html">Infirmier</option>
							     <option value="Preventeur.html">Préventeur</option>
							     <option value="Entreprise.html">Entreprise</option>
							     <option value="Salarie.html">Salarié</option>
						     </select>
							     								    		        
						      </div>
						
						      <!-- Modal footer -->
						   	  <div class="modal-footer">
						      	<button type="button" class="btn btn-outline-primary" data-dismiss="modal" onclick='select_value()'>Valider</button>
						        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Annuler</button>
						      </div>
						
					</div>
		  </div>
	</div>
			  	<c:import url="/jsp/Footer.jsp"/>
	

</body>
</html>