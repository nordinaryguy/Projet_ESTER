<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questionnaire</title>

<link href="/Projet_ESTER/css/old/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="/Projet_ESTER/css/old/bootstrap.min.css" rel="stylesheet">
    <link href="/Projet_ESTER/css/style.css" rel="stylesheet">
    <script src="/Projet_ESTER/js/old/jquery.min.js"></script>
    <script src="/Projet_ESTER/js/popper.min.js"></script>
    <script src="/Projet_ESTER/js/old/bootstrap.min.js"></script>
    <script src="/Projet_ESTER/js/fb.js"></script>
    <script src="/Projet_ESTER/js/slideBare.js"></script>
</head>
<body>
<!-- entete de page (logo) -->


 
  <div class="shadowbottom" >
    <div class="repeating-linear">
      <div class="row">
            <div class="col-md-7" style="text-align: center;" >
              <img src="/Projet_ESTER/img/irset.png" width="150px";margin-top="80px" >
            </div>
            <div class="col-md-3" style="text-align: center;" >
              <img src="/Projet_ESTER/img/ua_h.png" width="150px" >
            </div>
    	 </div>
   
     </div>
   </div>
   <!-- questionnaire -->
    <div class="container" style="background-color: white; margin-top: 5%;">
    <form action="post">
      <!--question 1-->
      <div class="row">
        <div class="col-6">
          <label >1) Comment Ã©valuez-vous l'intensitÃ© des efforts physiques de votre travail au cours d'une journÃ©e de travail ?</label>
        </div>
        <div class="col-2">
            <select name="select1">
              <option>6 Pas d'effort du tout</option>
              <option>7 Extremement lÃ©ger</option>
              <option>9 trÃ©s lÃ©ger</option>
              <option>11 lÃ©ger</option>
              <option>13 un peu dur</option>
              <option>15 Dur</option>
              <option>17 trÃ¨s dur</option>
              <option>19 Extremement dur Epuisant</option>
              <option>20 Epuisant</option>
            </select>
        </div>
      </div>
      <!--question 2-->
      <div class="row">
        <label >2) Votre travail nÃ©cessite-t-il de rÃ©pÃ©ter les mÃªmes actions plus de 2 Ã  4 fois environ par minute ?</label>
      </div>
      <div class="row">
         <div class="col-md-5 valtype" data-valtype="checkboxes">
            <label class="checkbox"><input type="checkbox" value="Non ou presque jamais" name="checkbox1"> Non ou presque jamais </label>
            <label class="checkbox"><input type="checkbox" value=" Rarement (moins de 2h/jour)" name="checkbox2"> Rarement (moins de 2h/jour)</label>
          </div>
           <div class="col-md-5 valtype" data-valtype="checkboxes">
            <label class="checkbox"><input type="checkbox" value="Souvent (de 2 Ã  4h/jour)" name="checkbox3"> Souvent (de 2 Ã  4h/jour)</label>
            <label class="checkbox"><input type="checkbox" value="Toujours ou presque toujours(>4h/jours)" name="checkbox4" > Toujours ou presque toujours(>4h/jours)</label>
          </div>
      </div>
      <!--question 3-->
      <div class="row">
        <label> 3) Devez-vous vous pencher en avant / sur le cÃ´tÃ© rÃ©guliÃ¨rement ou de maniÃ¨re prolongÃ©e?</label>
      </div>
      <div class="row">
         <div class="col-md-5 valtype" data-valtype="checkboxes">
            <label class="checkbox"><input type="checkbox" value="Jamais" name="checkbox1">Jamais </label>
            <label class="checkbox"><input type="checkbox" value="Rarement (moins de 2h/jour)" name="checkbox2"> Rarement (moins de 2h/jour)</label>
          </div>
           <div class="col-md-5 valtype" data-valtype="checkboxes">
            <label class="checkbox"><input type="checkbox" value="Souvent (de 2 Ã  4h/jour)" name="checkbox3"> Souvent (de 2 Ã  4h/jour)</label>
            <label class="checkbox"><input type="checkbox" value=" Toujours(>4h/jours)" name="checkbox4"> Toujours(>4h/jours)</label>
          </div>
      </div>
      <!--question 4-->
      
      <div class="row">
        <div class="col-md-4" data-valtype="checkboxes">
          <label> 4) Travaillez-vous avec un ou deux bras en l'air (au-dessus des Ã©paules) rÃ©guliÃ¨rement ou de maniÃ¨re prolongÃ©e?</label>
        </div>
        <div class="col-md-2 ">
          <img src="">
        </div>
        <div class="col-md-1 " data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Jamais ou presque jamais" name="checkbox1">Jamais ou presque jamais </label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Rarement (moins de 2h/jour)" name="checkbox2"> Rarement (moins de 2h/jour)</label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Souvent (de 2 Ã  4h/jour)" name="checkbox3"> Souvent (de 2 Ã  4h/jour)</label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Toujours(>4h/jours)" name="checkbox4"> Toujours(>4h/jours)</label>
        </div>
      </div>
      <!--question 5-->
      <div class="row">
        <div class="col-md-4" data-valtype="checkboxes">
          <label> 5) FlÃ©chir le(s) coude(s) rÃ©guliÃ¨rement ou de maniÃ¨re prolongÃ©e ?</label>
        </div>
        <div class="col-md-2 ">
          <img src="">
        </div>
        <div class="col-md-1 " data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Jamais ou presque jamais"name="checkbox1">Jamais ou presque jamais </label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value=" Rarement (moins de 2h/jour)" name="checkbox2"> Rarement (moins de 2h/jour)</label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value=" Souvent (de 2 Ã  4h/jour)" name="checkbox3"> Souvent (de 2 Ã  4h/jour)</label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Toujours(>4h/jours)" name="checkbox4"> Toujours(>4h/jours)</label>
        </div>
      </div>
      <!--question 6-->
      <div class="row">
        <div class="col-md-4" data-valtype="checkboxes">
          <label> 6) Presser ou prendre fermement des objets ou des piÃ¨ces entre le pouce et l'index?</label>
        </div>
      </div>
      <div class="row" >
         <div class="col-md-5 valtype" data-valtype="checkboxes">
            <label class="checkbox"><input type="checkbox" value="Jamais" name="checkbox1" >Jamais </label>
            <label class="checkbox"><input type="checkbox" value="Rarement (moins de 2h/jour)" name="checkbox2"> Rarement (moins de 2h/jour)</label>
          </div>
           <div class="col-md-5 valtype" data-valtype="checkboxes">
            <label class="checkbox"><input type="checkbox" value="Souvent (de 2 Ã  4h/jour)"name="checkbox3"> Souvent (de 2 Ã  4h/jour)</label>
            <label class="checkbox"><input type="checkbox" value=" Toujours(>4h/jours)" name="checkbox4"> Toujours(>4h/jours)</label>
          </div>
          <div class="col-md-2 ">
            <img src="">
          </div>
      </div>
      <!--question 7-->
      <div class="row">
        <div class="col-md-4" data-valtype="checkboxes">
          <label> 7) Dans mon travail jâai la possibilitÃ© d'influencer le dÃ©roulement de mon travail</label>
        </div>
        <div class="col-md-1 " data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Pas du tout d accord" name="checkbox1">Pas du tout dâaccord </label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Pas dâaccord" name="checkbox2"> Pas dâaccord</label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="dâaccord" name="checkbox3"> Pas dâaccord </label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Tout Ã  fait dâaccord" name="checkbox4"> Tout Ã  fait dâaccord</label>
        </div>
      </div>
      <!--question 8-->
      <div class="row">
        <div class="col-md-4" data-valtype="checkboxes">
          <label> 8) Les collÃ¨gues avec qui je travaille m'aident Ã  mener les tÃ¢ches Ã  bien</label>
        </div>
        <div class="col-md-1 " data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Pas du tout d accord" name="checkbox1">Pas du tout dâaccord </label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Pas dâaccord" name="checkbox2"> Pas dâaccord</label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="dâaccord" name="checkbox3"> Pas dâaccord </label>
        </div>
        <div class="col-md-1 valtype" data-valtype="checkboxes">
          <label class="checkbox"><input type="checkbox" value="Tout Ã  fait dâaccord" name="checkbox4"> Tout Ã  fait dâaccord</label>
        </div>
      </div>
      <!--submit btn-->
      <div class="row" style="text-align: center;">
        <input type="submit" value="envoyer"/> 
      </div>
      </form>
   </div>
   
   <c:import url="/jsp/Footer.jsp"/>
   
  
  </body>
</html>

