<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr-FR">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="icon" href="UA.png">

    <title>Connexion</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

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

        <h1 class="font-weight-normal">Connexion</h1>
    
        <div class="btn-group btn-group-toggle" role="group">
          <button type="radio" id="btnEntreprise" class="btn btn-secondary" onclick="showDiv('divSalarie')">Salarié</button>
          <button type="radio" id="btnEntreprise" class="btn btn-secondary" onclick="showDiv('divEntreprise')">Entreprise</button>
          <button type="radio" id="btnUtilisateur" class="btn btn-secondary" onclick="showDiv('divUtilisateur')">Utilisateur</button>
        </div>
    
        <form id="divSalarie" style="display:none;" class="form-signin" method="post">
          <div class="form-label-group">
            <input type="text" id="inputIdentifiant" name="Identifiant" class="form-control" placeholder="Identifiant" required>
            <label for="inputIdentifiant">Identifiant</label>
          </div>
          <div class="btn-group" role="group"">
            <button class="btn btn-primary" type="submit">Valider</button>
            <button class="btn btn-secondary" type="reset">Effacer</button>
          </div>
        </form>

        <div id="divEntreprise" style="display:none;" class="form-signin" method="post"> 
          <div class="form-label-group">
            <input type="email" id="inputEmail" class="form-control" placeholder="Email" required>
            <label for="inputEmail">Adresse Email</label>
          </div>
          <div class="form-label-group">
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <label for="inputPassword">Mot de Passe</label>
          </div>
          <div class="btn-group" role="group"">
            <button class="btn btn-primary" type="submit">Valider</button>
            <button class="btn btn-secondary" type="reset">Effacer</button>
          </div>
        </div>

        <div id="divUtilisateur" style="display:none;" class="form-signin" method="post">
            <div class="btn-group" role="group"">
              <button class="btn btn-primary" type="submit">Valider</button>
              <button class="btn btn-secondary" type="reset">Effacer</button>
            </div>
        </div>

        <div class="row pt-5 text-muted text-center">
          <div class="col-md-4 pr-1 " ><a href="#">Inscription</a></div>
          <div class="col-md-4" ><a href="#">Projet</a></div>
          <div class="col-md-4  pl-1" ><a href="#">Contacts</a></div>
        </div>
          
      </div>
    </div>
  </body>
</html>
