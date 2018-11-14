<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Résultat</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <script type='text/javascript' src='/Projet_ESTER/dwr/engine.js'></script>
        <script type='text/javascript' src='/Projet_ESTER/dwr/util.js'></script>
  		<script type='text/javascript' src='/Projet_ESTER/dwr/interface/Resultat.js'></script>
  		
<<<<<<< HEAD
  		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
=======
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
>>>>>>> 6dd11efae1e3473f43bcc21851fc7aff3a3d1abe
  		
  		<script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<script src="https://code.highcharts.com/modules/export-data.js"></script>
		
		<script src="${pageContext.request.contextPath}/js/resultat.js"></script>
		<script src="${pageContext.request.contextPath}/js/lang/highcharts_french.js"></script>
    </head>
    <body>
    
    <nav class="navbar navbar-light bg-light">
	  <a class="navbar-brand" href="#">
	  <img src="http://www.univ-angers.fr/_resources/com/logo/_GENERIQUE/VERTICAL/ECRAN/PNG/ua_v_couleur_ecran.png" width="30" height="30" class="d-inline-block align-top" alt="">
	    Résultat
	  </a>
	</nav>
    
    <div class="card-group">
    
	<div class="card">
	  	<div class="card-header">
	  		<h5 class="card-title">Situation du score de l'histogramme de la population de référence</h5>
	  	</div>
	  	<div id="histo-div" class="card-body">
	  		<div id="id_histo" style="min-width: 310px; max-width: 1000px; margin: 0 auto"></div>
   		</div>
   	</div>
    
	<div class="card">
	  	<div class="card-header">
	  		<h5 class="card-title">Comparaison des réponses à la population de référence* (Hommes de 50 ans ou plus, B=396)</h5>
	  		<h6 class="card-subtitle mb-2 text-muted">*Population de référence : échantillion du réseaux de surveillance des TMS en entreprise dans les Pays de la Loire (2002-2005)</h6>
	  	</div>
	  	<div id="chart-div" class="card-body">
	  	</div>
	</div>
	
	<div class="card">
	  	<div class="card-header">
	  		<h5 class="card-title">Intensité des efforts physiques (échelle Rating Scale of Perceived Extertion (RPE) de Borg)</h5>
	  	</div>
	  	<div id="strong-div" class="card-body">
	  		<div id="id_rpe" style="min-width: 310px; max-width: 1000px; margin: 0 auto"></div>
   		</div>
   	</div>
	
    </div>
    
    <script type='text/javascript' >

    addHisto("id_histo")
    addAllChart("chart-div");
    addRPE("id_rpe");
    
    </script>
    </body>
</html>

