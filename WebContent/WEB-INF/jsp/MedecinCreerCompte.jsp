<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr-FR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="UA.png">

    <title>ESTER</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    <!-- Custom styles for this template -->
    <link href="/Projet_ESTER/CSS/Accueil.css" rel="stylesheet">
    
</head>

<body >  
	<div class="container-fluid pr-0 pl-0 fixed-top">
  
		<div class="row">
			<div class="col-md-12">
  				<nav class=" navbar navbar-expand-xs navbar-expand-lg mt-0">
  					<div class=" collapse navbar-collapse container-fluid ">	
 		
						<div class="row pl-2 pr-2">
							<div class="col-xs-12 pl-2 pr-2"><img src="http://ester.univ-angers.fr/_resources-images/logo/logo-labo_max0x0.png" alt="Logo Irset" width="205" height="90"></div>
  						</div>
  	
  						<form class="form-inline pl-2 pr-2 row">
							<div class="col-xs-8 pr-1 pl-2"> <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"></div>
	  						<div class="col-xs-4 pl-1 pr-2"> <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button></div>
  						</form>

  						<div class="row pl-2 pr-2">
						  	<ul class="navbar-nav">
						      <li class="nav-item dropdown">
						        <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Mentions légales</a>
						      </li>
						      <li class="nav-item dropdown">
						        <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Projet</a>
						      </li>
						      <li class="nav-item dropdown">
						        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          Contacts
						        </a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						          <a class="dropdown-item" href="#">Action</a>
						          <a class="dropdown-item" href="#">Another action</a>
						          <a class="dropdown-item" href="#">Something else here</a>
						        </div>
						      </li>
						    </ul>  	
						</div>
  	
					  	<div class="row pl-2 pr-2">
							   <div class="col-xs-12 pl-2 pr-2 "><button class="btn btn-outline-primary my-2 my-sm-0">Déconnexion</button></div>		
						</div>   	
  	
					  	<div class="row pl-2 pr-2">
					  			<div class="col-xs-12 pl-2 pr-2"><img src="http://www.univ-angers.fr/_contents-images/ametys-internal%253Asites/univangers/ametys-internal%253Acontents/logo-article-8/_metadata/content/_data/ua_h_couleur_ecran.png_57x189" alt="" width="189" height="57"></div>
					  	</div>
  		
					</div>  

				</nav>
			</div>
		</div>

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
				       		<a class="nav-link" href="#">Création des comptes</a>			       		
				        </li>
						
						<li class="nav-item dropdown">
					        <a class="nav-link dropdown-toggle" href="#" id="gestionSalariesMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          Gestion des salariés
					        </a>	 
								 <div class="dropdown-menu" aria-labelledby="gestionSalariesMenu">
						         	<a class="dropdown-item" href="#">Liste des salariés</a>
						         	<a class="dropdown-item" href="#">Profil du salarié</a>		
						       	 </div>
						</li>		
				        
						<li class="nav-item dropdown">
				       		<a class="nav-link dropdown-toggle" href="#" id="gestionQuestionnaireMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion des questionnaires</a>
						 
							 <div class="dropdown-menu" aria-labelledby="gestionQuestionnaireMenu">
					         	<a class="dropdown-item" href="#">Créer un questionnaire</a>
					         	<a class="dropdown-item" href="#">Modifier un questionnaire</a>
		          			 	<a class="dropdown-item" href="#">Administrer les questionnaires</a>	
					         </div>
					   	</li>	        
				              
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Modifier les valeurs de référence</a>
				        </li>
				        
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Afficher les statistiques</a>
				        </li>
				        
				        <li class="nav-item">
				        	<a class="nav-link" href="#">Exporter les données</a>
				        </li>
				        				  
				    </ul> 
			    </div>
			    
				<div class="col-xs-10">
					<div class="container-fluid" style="background:white">
					    <h1>Médecin</h1>
						<p>Bienvenue sur la partie Médecin du Projet ESTER</p>
					</div>
				</div>
			</div> 
		</div>
	</div>
	
	<div class="text-center mb-4" id="CreerCompte">
			<div class="row">
				    <h4 class="modal-title">Créer un nouveau compte Salarié :</h4>
		    </div>
						
			<div class="container">
				     <form class="pt-2 row" id="saisi" method="post">
						<input type="submit" value="Génerer code patient ">        
					 </form>  	
					 <p class="row"> 
				     		${ empty message ? '' : message }
				     </p>	  	        
			 </div>
						
	</div>
    
</body>
</html>