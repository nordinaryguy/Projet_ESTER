<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Résultat</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <script type='text/javascript' src='/Projet_ESTER/dwr/engine.js'></script>
        <script type='text/javascript' src='/Projet_ESTER/dwr/util.js'></script>
  		<script type='text/javascript' src='/Projet_ESTER/dwr/interface/Resultat.js'></script>

	    <link rel="stylesheet" href="<c:url value="/css/default.css"/>">
	    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	    <script src="<c:url value="/js/jquery.min.js"/>"></script>
	    <script src="<c:url value="/js/popper.min.js"/>"></script>
	    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  		
  		<script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<script src="https://code.highcharts.com/modules/export-data.js"></script>
		
		<script src="<c:url value="/js/resultat.js"/>"></script>
		<script src="<c:url value="/js/lang/highcharts_french.js"/>"></script>
    </head>
    <body>
  	<c:import url="/jsp/MenuPage.jsp"/>
    
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

