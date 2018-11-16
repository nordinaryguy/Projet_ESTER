<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr-FR">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="/Projet_ESTER/IMG/UA.png">

    <title>Connexion</title>

    <link rel="stylesheet" href="/Projet_ESTER/css/bootstrap.min.css">
    <script src="/Projet_ESTER/js/jquery.min.js"></script>
    <script src="/Projet_ESTER/js/popper.min.js"></script>
    <script src="/Projet_ESTER/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="/Projet_ESTER/css/Accueil.css" rel="stylesheet">

    <script>
      function showDiv(name) {
        document.getElementById('divSalarie').style.display = "none";
        document.getElementById('divEntreprise').style.display = "none";
        document.getElementById('divUtilisateur').style.display = "none";
        document.getElementById(name).style.display = "block";
      }
    </script>
  </head>
  <body>
  
    <div class="container-fluid text-center mb-4" id="container">

	    <c:if test="${not empty Success}">
	      <div class="alert alert-success alert-dismissible" role="alert">
          <strong>Succès</strong> <c:out value = "${Success}"/>
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	    </c:if>
	
	    <c:if test="${not empty Warning}">
	      <div class="alert alert-warning alert-dismissible" role="alert">
          <strong>Attention</strong> <c:out value = "${Warning}"/>
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	    </c:if>

        <h1 class="font-weight-normal">Connexion</h1>
    
        <div class="btn-group" role="group">
          <button id="btnEntreprise" class="btn btn-secondary" type="button" onclick="showDiv('divSalarie')">Salarié</button>
          <button id="btnEntreprise" class="btn btn-secondary" type="button" onclick="showDiv('divEntreprise')">Entreprise</button>
          <button id="btnUtilisateur" class="btn btn-secondary" type="button" onclick="showDiv('divUtilisateur')">Utilisateur</button>
        </div>
    
        <form id="divSalarie" style="display:none;" class="form-signin" method="post">
          <div class="form-label-group">
            <input type="text" id="inputIdentifiant" name="Identifiant" class="form-control" placeholder="Identifiant" required>
            <label for="inputIdentifiant">Identifiant</label>
          </div>
          <input type="hidden" name="Type" value="Salarie" />
          <div class="btn-group" role="group">
            <button class="btn btn-primary" type="submit">Valider</button>
            <button class="btn btn-secondary" type="reset">Effacer</button>
          </div>
        </form>

        <form id="divEntreprise" style="display:none;" class="form-signin" method="post"> 
          <div class="form-label-group">
            <input type="email" id="inputEmailEntreprise" name="Email" class="form-control" placeholder="Email" required>
            <label for="inputEmailEntreprise">Adresse Email</label>
          </div>
          <div class="form-label-group">
            <input type="password" id="inputPasswordEntreprise" name="Password" class="form-control" placeholder="Password" required>
            <label for="inputPasswordEntreprise">Mot de Passe</label>
          </div>
          <input type="hidden" name="Type" value="Entreprise" />
          <div class="btn-group" role="group">
            <button class="btn btn-primary" type="submit">Valider</button>
            <button class="btn btn-secondary" type="reset">Effacer</button>
          </div>
        </form>

        <form id="divUtilisateur" style="display:none;" class="form-signin" method="post">
            <div class="form-label-group">
              <input type="email" id="inputEmailUtilisateur" name="Email" class="form-control" placeholder="Email" required>
              <label for="inputEmailUtilisateur">Adresse Email</label>
            </div>
            <div class="form-label-group">
              <input type="password" id="inputPasswordUtilisateur" name="Password" class="form-control" placeholder="Password" required>
              <label for="inputPasswordUtilisateur">Mot de Passe</label>
            </div>
            <input type="hidden" name="Type" value="Utilisateur" />
            <div class="btn-group" role="group"">
              <button class="btn btn-primary" type="submit">Valider</button>
              <button class="btn btn-secondary" type="reset">Effacer</button>
            </div>
        </form>

        <div class="row pt-5 text-muted text-center">
          <div class="col-md-4 pr-1 " ><a href="#">Inscription</a></div>
          <div class="col-md-4" ><a href="#">Projet</a></div>
          <div class="col-md-4  pl-1" ><a href="#">Contacts</a></div>
        </div>
          
      </div>
    </div>
  </body>
</html>
