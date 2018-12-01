<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<link rel="icon" href="<c:url value="/img/ua.png"/>">
	
	<title>Questionnaire</title>

	<link rel="stylesheet" href="<c:url value="/css/old/bootstrap-responsive.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/old/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/menu.css"/>">
    
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/old/bootstrap.min.js"/>"></script>
    
</head>
<body>

	<!-- entete de page (logo) -->


	<nav class="navbar navbar-expand-lg fixed-top navbar-dark shadowbottom">
		 <div class="row">
		 	 <div class="col-md-1" style="text-align:center;"><a href="<c:url value="/utilisateur"/>"><img src="<c:url value="/img/retour.png"/>" alt="retour"  width="65"></a></div>
		 	 <div class="col-md-3" style="text-align:center;"><img src="<c:url value="/img/irset.png"/>" alt="Logo-ister" width="155"></div>
			 <div class="col-md-3" style="text-align:center;"><img src="<c:url value="/img/ua_h.png"/>" alt="Logo-Université-Angers" width="170"></div>
			 <div class="col-md-3" style="text-align:center;"><img src="<c:url value="/img/Sante_publique.jpg"/>" alt="Logo-Santé_publique_France" width="130"></div>
		</div>   
	</nav>   

   <!-- questionnaire -->
    <div class="container" style="background-color: white; margin-top: 5%;">
	    <form action="post" class="row" style="padding-left:80px">
	    
	      <!--question 1-->
		      <div class="row">
		        <div class="col">
		          <label >1) Comment évaluez-vous l'intensité des efforts physiques de votre travail au cours d'une journée de travail ?</label>
		        </div>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
		        <div class="col">
		            <select name="select1">
		              <option>6 Pas d'effort du tout</option>
		              <option>7 Extremement léger</option>
		              <option>9 très léger</option>
		              <option>11 Léger</option>
		              <option>13 Un peu dur</option>
		              <option>15 Dur</option>
		              <option>17 Très dur</option>
		              <option>19 Extremement dur Epuisant</option>
		              <option>20 Epuisant</option>
		            </select>
		        </div>
		      </div>
		      
	      <!--question 2-->
		      <div class="row">
		        <label >2) Votre travail nécessite-t-il de répéter les mêmes actions plus de 2 à 4 fois environ par minute ?</label>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
		         <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Jamais" name="question2" >Jamais </label>
		            <label class="radio"><input type="radio" value="Rarement (moins de 2h/jour)" name="question2"> Rarement (moins de 2h/jour)</label>
		          </div>
		           <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Souvent (de 2 à 4h/jour)" name="question2"> Souvent (de 2 à 4h/jour)</label>
		            <label class="radio"><input type="radio" value=" Toujours(>4h/jours)" name="question2"> Toujours(>4h/jours)</label>
		          </div>
		      </div>
		      
	      <!--question 3-->
		      <div class="row">
		        	<label> 3) Devez-vous vous pencher en avant / sur le côté régulièrement ou de manière prolongée?</label>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
		         <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Jamais" name="question3" >Jamais </label>
		            <label class="radio"><input type="radio" value="Rarement (moins de 2h/jour)" name="question3"> Rarement (moins de 2h/jour)</label>
		          </div>
		          <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Souvent (de 2 à 4h/jour)" name="question3"> Souvent (de 2 à 4h/jour)</label>
		            <label class="radio"><input type="radio" value=" Toujours(>4h/jours)" name="question3"> Toujours(>4h/jours)</label>
		          </div>
		      </div>
		      
	      <!--question 4-->
		      <div class="row">
			          <label> 4) Travaillez-vous avec un ou deux bras en l'air (au-dessus des épaules) régulièrement ou de manière prolongée?</label>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
			      <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Jamais" name="question4" >Jamais </label>
		            <label class="radio"><input type="radio" value="Rarement (moins de 2h/jour)" name="question4"> Rarement (moins de 2h/jour)</label>
		          </div>
		           <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Souvent (de 2 à 4h/jour)" name="question4"> Souvent (de 2 à 4h/jour)</label>
		            <label class="radio"><input type="radio" value=" Toujours(>4h/jours)" name="question4"> Toujours(>4h/jours)</label>
		          </div>
		      </div>
		      
	      <!--question 5-->
		      <div class="row">
		          <label> 5) Fléchir le(s) coude(s) régulièrement ou de manière prolongée ?</label>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
		         <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Jamais" name="question5" >Jamais </label>
		            <label class="radio"><input type="radio" value="Rarement (moins de 2h/jour)" name="question5"> Rarement (moins de 2h/jour)</label>
		          </div>
		           <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Souvent (de 2 à 4h/jour)" name="question5"> Souvent (de 2 à 4h/jour)</label>
		            <label class="radio"><input type="radio" value=" Toujours(>4h/jours)" name="question5"> Toujours(>4h/jours)</label>
		          </div>
		      </div>
		      
	      <!--question 6-->
		      <div class="row">
		          <label> 6) Presser ou prendre fermement des objets ou des pièces entre le pouce et l'index?</label>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
		         <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Jamais" name="question6" >Jamais </label>
		            <label class="radio"><input type="radio" value="Rarement (moins de 2h/jour)" name="question6"> Rarement (moins de 2h/jour)</label>
		          </div>
		           <div class="col-md-5 valtype" data-valtype="radios">
		            <label class="radio"><input type="radio" value="Souvent (de 2 à 4h/jour)" name="question6"> Souvent (de 2 à 4h/jour)</label>
		            <label class="radio"><input type="radio" value=" Toujours(>4h/jours)" name="question6"> Toujours(>4h/jours)</label>
		          </div>
		          
		      </div>
		      
	      <!--question 7-->
		      <div class="row">
		          <label> 7) Dans mon travail, j'ai la possibilité d'influencer le déroulement de mon travail</label>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
		         <div class="col-md-5 valtype" data-valtype="radios">
		          <label class="radio"><input type="radio" value="Pas du tout d'accord" name="question7">Pas du tout d'accord </label>
		          <label class="radio"><input type="radio" value="Pas d'accord" name="question7"> Pas d'accord</label>
		          </div>
		           <div class="col-md-5 valtype" data-valtype="radios">
		          <label class="radio"><input type="radio" value="Plutôt d'accord" name="question7"> Plutôt d'accord </label>
		          <label class="radio"><input type="radio" value="Tout à fait d'accord" name="question7"> Tout à fait d'accord</label>
		          </div>
		      </div>
	      
	      <!--question 8-->
		      <div class="row">
		          <label> 8) Les collègues avec qui je travaille m'aident à mener les tâches à bien</label>
		      </div>
		      <div class="row" style="padding-left:80px;padding-bottom:10px;">
		         <div class="col-md-5 valtype" data-valtype="radios">
		          <label class="radio"><input type="radio" value="Pas du tout d'accord" name="question8">Pas du tout d'accord </label>
		          <label class="radio"><input type="radio" value="Pas d'accord" name="question8"> Pas d'accord</label>
		          </div>
		           <div class="col-md-5 valtype" data-valtype="radios">
		          <label class="radio"><input type="radio" value="Plutôt d'accord" name="question8"> Plutôt d'accord </label>
		          <label class="radio"><input type="radio" value="Tout à fait d'accord" name="question8"> Tout à fait d'accord</label>
		          </div>
		      </div>
		      
	      <!--submit btn-->
	      
		      <div class="row" style="text-align: center; padding-right:80px">
		        <input type="submit" value="Envoyer"/>
		        <input type="reset" value="Réinitialiser"/> 
		        
		      </div>
	      </form>
        
   </div>
   
	 <div class="row" style="padding-bottom:20px">
        <div class="col-md-12"> </div>
        
    </div>
    
	<div class="row" style="text-align:center">
		<div class="col-md-3"></div>
		<div class="col-md-2" style="text-align:center;"><a href="<c:url value="/jsp/EnDev.jsp"/>">Mentions Légales</a></div>
		<div class="col-md-2" style="text-align:center;"><a href="<c:url value="/jsp/EnDev.jsp"/>">Projet</a></div>
		<div class="col-md-2" style="text-align:center;"><a href="<c:url value="/jsp/EnDev.jsp"/>">Contacts</a></div>
	</div>  

</body>
</html>

