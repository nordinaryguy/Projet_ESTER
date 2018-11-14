
	function ouvrir_premiereCo(typeCompte){
		if (document.getElementById(typeCompte).value=="1"){
			location.replace("PremiereConnexionParMedecin.html");
		}
		else if (document.getElementById(typeCompte).value=="2"){
			location.replace("PremiereConnexionPourSalaries.html");
		}
	}
