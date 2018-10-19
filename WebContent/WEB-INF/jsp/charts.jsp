<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Charts</title>
        <script type='text/javascript' src='/Projet_ESTER/dwr/engine.js'></script>
        <script type='text/javascript' src='/Projet_ESTER/dwr/util.js'></script>
  		<script type='text/javascript' src='/Projet_ESTER/dwr/interface/Charts.js'></script>
  		<script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<script src="https://code.highcharts.com/modules/export-data.js"></script>
		<script src="${pageContext.request.contextPath}/js/lang/highcharts_french.js"></script>
    </head>
    <body>

  <span id="d2" class="reply"></span>
  		<div id="id1" style="min-width: 310px; max-width: 1000px; height: 400px; margin: 0 auto"></div>
  
		<div id="container" style="min-width: 310px; max-width: 1000px; height: 400px; margin: 0 auto"></div>
    
    <script type='text/javascript' >
    
    Charts.getDataCSV(function(data) {
    	Highcharts.chart('id1', {
	      	  chart: {
	      	    type: 'bar'
	      	  },
	      	  title: {
	      	    text: 'Questionnaire B'
	      	  },
	      	  exporting: {},
	      	  xAxis: {
	      	    categories: []
	      	  },
	      	  yAxis: {
	      	    min: 0,
	      	    max: 100,
	      	    title: {
	      	      text: 'Pourcentage de la population de réference'
	      	    },
	      	    labels: {
	      	      format: " {value} %"
	      	    }
	      	  },
	      	  legend: {
	      	    reversed: true
	      	  },
	      	  plotOptions: {
	      	    series: {
	      	      stacking: 'normal'
	      	    }
	      	  },
	      	  data: {
	      		  csv: data
	      	  },
              series: [],
	      	  colors: [
		      	'#ff3d00',
	      	    '#ff9100',
	      	    '#ffea00',
	      	    '#00e676'
	      	  ]
    	});
    });
    
    Charts.getTotallyAgree(function(data) {
        if (data != null && typeof data == 'object') var totallyAgree = data;
        Charts.getAgree(function(data) {
	        if (data != null && typeof data == 'object') var agree = data;
    			Charts.getDisagree(function(data) {
			        if (data != null && typeof data == 'object') var disagree = data;
    			    Charts.getNotAtAllAgree(function(data) {
    			        if (data != null && typeof data == 'object') var notAtAllAgree = data;
        			    Charts.getQuestions(function(data) {
					        if (data != null && typeof data == 'object') var questions = data;
					        Highcharts.chart('container', {
					      	  chart: {
					      	    type: 'bar'
					      	  },
					      	  title: {
					      	    text: 'Questionnaire B'
					      	  },
					      	  exporting: {},
					      	  xAxis: {
					      	    categories: questions
					      	  },
					      	  yAxis: {
					      	    min: 0,
					      	    max: 100,
					      	    title: {
					      	      text: 'Pourcentage de la population de réference'
					      	    },
					      	    labels: {
					      	      format: " {value} %"
					      	    }
					      	  },
					      	  legend: {
					      	    reversed: true
					      	  },
					      	  plotOptions: {
					      	    series: {
					      	      stacking: 'normal'
					      	    }
					      	  },
					      	  series: [{
					      	    name: 'Tout \à fait d\'accord',
					      	    data: totallyAgree
					      	  }, {
					      	    name: 'D\'accord',
					      	    data: agree
					      	  }, {
					      	    name: 'Pas d\'accord',
					      	    data: disagree
					      	  }, {
					      	    name: 'Pas du tout d\'accord',
					      	    data: notAtAllAgree
					      	  }],
					      	  colors: [
					      	    '#00e676',
					      	    '#ffea00',
					      	    '#ff9100',
					      	    '#ff3d00'
					      	  ]
				      	});
			      	});
		      	});
  			});
		});
	});
    

    </script>
    </body>
</html>

