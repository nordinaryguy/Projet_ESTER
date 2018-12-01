function populateSelect(file,objet){
	$.getJSON(file, function( json ) {
		  $.each(json, function(i) {
			  document.getElementById(objet).innerHTML +="<option value=\""+json[i].name+"\">"+json[i].code+" "+json[i].name + "</option>";
		  });
	 });
}

function populateDep(s1,s2){
	document.getElementById(s2).innerHTML ="";
	console.log("Region changé");
	console.log( document.getElementById(s1).value);
	var option;
	$.getJSON("src/regions.json", function( json ) {
		  $.each(json, function(i) {
			  if(json[i].name == document.getElementById(s1).value){
				  console.log(json[i].name);
				  option=json[i].code;
				console.log(json[i].code);

			  }
		  });
	 });
	
	$.getJSON("src/departments.json", function( json ) {
		  $.each(json, function(i) {
			  if(json[i].region_code==option){
				  console.log(json[i].name);
				  document.getElementById(s2).innerHTML +="<option value=\""+json[i].name+"\">"+json[i].code+" "+json[i].name + "</option>";
			  }
		  });
	 });
	
}

function populateReg(s1,s2){
	document.getElementById(s2).innerHTML ="";
	var option;
	console.log("Departement changé");
	$.getJSON("src/departments.json", function( json ) {
		  $.each(json, function(i) {
			  if(json[i].name == document.getElementById(s1).value){
				  option=json[i].region_code;
			  }
		  });
	 });
	
	$.getJSON("src/regions.json", function( json ) {
		  $.each(json, function(i) {
			  if(json[i].code == option){
				  document.getElementById(s2).innerHTML ="<option value=\""+json[i].name+"\">"+json[i].code+" "+json[i].name + "</option>";
			  }
		  });
	 });
	
}