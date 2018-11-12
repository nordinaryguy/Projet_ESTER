function changedSelection(){
	var optionSelected=document.getElementById("typeCompte").value;
	document.getElementById("saisi").innerHTML = "";
	if(optionSelected =="salarie"){
		var x = document.createElement("INPUT");
		x.setAttribute("type", "button");
	    x.setAttribute("value", "Generer code salarié");
	    document.getElementById("saisi").appendChild(x);
	}else if(optionSelected!="ligne1"){
		var x = document.createElement("INPUT");
	    x.setAttribute("type", "email");
	    x.setAttribute("placeholder", "Adresse email");
	    x.setAttribute("id","adress_Email");
	    x.setAttribute("class","form-control");
	    x.setAttribute("name","email");
	    
	    var btn = document.createElement("INPUT");
	    btn.setAttribute("type", "button");
	    btn.setAttribute("value", "creer");
	    document.getElementById("saisi").appendChild(x);
	    document.getElementById("saisi").appendChild(btn);
	}
	
}