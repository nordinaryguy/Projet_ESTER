<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Charts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <script type='text/javascript' src='/Projet_ESTER/dwr/engine.js'></script>
        <script type='text/javascript' src='/Projet_ESTER/dwr/util.js'></script>
  		<script type='text/javascript' src='/Projet_ESTER/dwr/interface/Charts.js'></script>
  		
  		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  		
  		<script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<script src="https://code.highcharts.com/modules/export-data.js"></script>
		
		<script src="${pageContext.request.contextPath}/js/charts.js"></script>
		<script src="${pageContext.request.contextPath}/js/lang/highcharts_french.js"></script>
    </head>
    <body>
    
    <nav class="navbar navbar-light bg-light">
	  <a class="navbar-brand" href="#">
	    Résultat
	  </a>
	</nav>
    
    <div class="card-group">
    
	<div class="card">
	  	<div class="card-header">
	  		<h5 class="card-title">Situation du score de l'histogramme de la population de référence</h5>
	  	</div>
	  	<div id="histo-div" class="card-body">
	  		<div id="id_h0" style="min-width: 310px; max-width: 1000px; height: 400px; margin: 0 auto"></div>
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
	  		<div id="id_s0" style="min-width: 310px; max-width: 1000px; height: 400px; margin: 0 auto"></div>
   		</div>
   	</div>
	
    </div>
    
    <script type='text/javascript' >
    Highcharts.chart('id_h0', {
    	title: {
    	    text: null
    	},
        chart: {
            type: 'column'
        },

        yAxis: {
        	title: { text: 'Pourcentage' },
      	    labels: { format: "{value} %"}
        },
        
        xAxis: {
      	    categories: []
        },

        plotOptions: {
        	colorByPoint: true
        },
        
        data: {
        	csv: 'categorie,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15\nScore,11.9,9.6,33.5,9,2,2,0.4,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2'
        },
        
        legend: {
            enabled: false
        },
	   	colors: [
		      	'#00e676',
	      	    '#00e676',
	      	    '#00e676',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF',
	      	    '#2962FF'
		],
	    credits: {
	    	enabled: false
	    }
    });
    
    Highcharts.chart('id_s0', {
    	  chart: {
    	    type: 'bar'
    	  },
    	  title: {
    	    text: null
    	  },
    	  xAxis: {
    	    categories: ['Pas d\'éfort du tout 6', 
    	    	'Extrêmement léger 7', 
    	    	'8', 
    	    	'Très leger 9', 
    	    	'10',
    	    	'Léger 11',
    	    	'12',
    	    	'Un peu dur 13',
    	    	'14',
    	    	'Dur 15',
    	    	'16',
    	    	'Très dur 17',
    	    	'18',
    	    	'Extrêment dur 19',
    	    	'Epuisant 20'],
    	    title: {
    	      text: null
    	    }
    	  },
    	  yAxis: {
    	    min: 0,
    	    title: {
    	      text: 'Pourcentage',
    	      align: 'high'
    	    },
    	    labels: {
    	      overflow: 'justify'
    	    },
      	    labels: { format: "{value} %" }
    	  },
    	  tooltip: {
    	    valueSuffix: ' %'
    	  },
    	  plotOptions: {
    	    bar: {
    	      dataLabels: {
    	        enabled: true,
    	        formatter: function () { return this.y + " %"; }
    	      },
        	  colorByPoint: true
    	    }
    	  },
          legend: {
              enabled: false
          },
    	  credits: {
    	    enabled: false
    	  },
    	  series: [{
    		name: 'RPE',
    	    data: [8.1,5.1,0,6.8,1,19.5,5.1,24.3,5.6,16.2,1.8,4.1,0.5,0.5,1.5]
    	  }],
      	  colors: ['#00e676',
	      	    '#00e676',
	      	    '#00e676',
	      	    '#00e676',
	      	    '#ffea00',
	      	    '#ffea00',
	      	    '#ff9100',
	      	    '#ff9100',
	      	    '#ff9100',
	      	    '#ff9100',
		      	'#ff3d00',
		      	'#ff3d00',
		      	'#ff3d00',
		      	'#ff3d00',
		      	'#ff3d00'
	      	  ]
    	});
    
    addAllChart("chart-div");
    
    </script>
    </body>
</html>

