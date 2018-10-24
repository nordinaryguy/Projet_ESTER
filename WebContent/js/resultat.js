function addChart(divName,i) {
	Resultat.getDataCSV(i, function(data) {
		Resultat.getAnswers(i, function(answers) {
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
	Resultat.sizeDataCSV(function(size) {
    	for(var i = 0; i < size; i++) {
    		var divChart = 'id_q' + i;
    		document.getElementById(divName).innerHTML += '<div id="' + divChart + 
    				'" style="min-width: 310px; max-width: 1000px; margin: 0 auto"></div>';
    		addChart(divChart,i);
    	}
    });
}

function addHisto(divName) {
	Resultat.getCategoriesHisto(function(categories) {
		Resultat.getDataHisto(function(data) {
			Resultat.getColorsHisto(function(colors) {
			    Highcharts.chart(divName, {
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
				  	    categories: categories,
	              	    title: {
	                	      text: 'Score',
	                	      align: 'high'
	                	}
				    },
				    plotOptions: {
				    	column: {
	              	   		colorByPoint: true
	              	   	}
				    },
			    	series: [{
			    		name: 'Score',
			        	data: data
			        }],
				    legend: {
				        enabled: false
				    },
				   	colors: colors,
				    credits: {
				    	enabled: false
				    }
			    });
			});
		});
	});
}


function addRPE(divName) {
	Resultat.getCategoriesRPE(function(categories) {
		Resultat.getDataRPE(function(data) {
			Resultat.getColorsRPE(function(colors) {
                Highcharts.chart(divName, {
              	  chart: {
              	    type: 'bar'
              	  },
              	  title: {
              	    text: null
              	  },
              	  xAxis: {
              	    categories: categories,
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
              	      overflow: 'justify',
              	      format: "{value} %"
              	    }
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
              	  series: [{
              		name: 'RPE',
              	    data: data
              	  }],
              	  colors: colors,
              	  credits: {
                	    enabled: false
                	  }
              	});
            });
        });
    });
}