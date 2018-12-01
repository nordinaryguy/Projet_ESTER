function populateSelect(file,objet){
	$.getJSON(file, function( json ) {
		  $.each(json, function(i) {
			  document.getElementById(objet).innerHTML +="<option value=\""+json[i].name+"\">"+json[i].code+" "+json[i].name + "</option>";
		  });
	 });
}