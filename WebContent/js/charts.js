function addChart(divName,i) {
    Charts.getDataCSV(i, function(data) {
	    Charts.getAnswers(i, function(answers) {
	    	Highcharts.chart(divName, {
		      	  chart: {
		      	    type: 'bar'
		      	  },
		      	  title: {
		      	    text: null
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
		      	      format: "{value} %"
		      	    }
		      	  },
		      	  legend: {
		      	    reversed: true
		      	  },
		      	  plotOptions: {
		      	    series: {
		      	      stacking: 'normal',
	                    dataLabels: {
	                        enabled: true,
	                        color: '#000',
	                        style: {fontWeight: 'bolder'},
	                        formatter: function() {
	                        	if(answers[this.x] == this.series.name)
	                        		return "✓";
	                        },
	                        inside: true
	                    }
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
		      	  ],
		  	      credits: {
			    	enabled: false
			      }
	    	});
    	});
	});
}

function addAllChart(divName) {
    Charts.sizeDataCSV(function(size) {
    	for(var i = 0; i < size; i++) {
    		var divChart = 'id_q' + i;
    		document.getElementById(divName).innerHTML += '<div id="' + divChart + 
    				'" style="min-width: 310px; max-width: 1000px; height: 400px; margin: 0 auto"></div>';
    		addChart(divChart,i);
    	}
    });
}