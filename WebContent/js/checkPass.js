function checkPass(pass1,pass2){
		    var champA = document.getElementById(pass1).value;
		    var champB = document.getElementById(pass2).value;
		    var divcomp = document.getElementById("divcomp");
		    if(!passwordChanged(pass1)){
		    	strength.innerHTML = " Saisi un mot de passe plus fort";
		        strength.style.color="red";
		        document.getElementById('submit').disabled = true;
		    }else if(champA == champB)
		    {
		    divcomp.innerHTML = "Mot de passe identiques";
		    divcomp.style.color='green';
		    document.getElementById('submit').disabled = false;
		    }
		    else if(champA.length != champB.length){
		    	document.getElementById('submit').disabled = true;
		    }else{
		    divcomp.innerHTML = "les deux mot de passe ne sont pas identiques";
		    divcomp.style.color='red';
		    document.getElementById('submit').disabled = true;
		    }
}

function passwordChanged(password) {
	document.getElementById('submit').disabled = true;
	divcomp.innerHTML = " ";
	var strength = document.getElementById("strength");
	/*[10 or plus characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character]*/
	var strongRegex = new RegExp("^(?=.{10,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
	/*9 or plus characters which contains (lowercase and uppercase letters) or ((uppercase or lowercase) letters and numeric digits)  */
	var mediumRegex = new RegExp("^(?=.{9,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
	/*minimum 8 any characters */
	var enoughRegex = new RegExp("(?=.{8,}).*", "g");
	var pwd = document.getElementById(password);
	if (pwd.value.length==0) {
	strength.innerHTML = " Tapez un mot de passe";
	strength.style.color="black";
	return false;
	} else if (false == enoughRegex.test(pwd.value)) {
	strength.innerHTML = " Plus de caractères ";
    strength.style.color="black";
    return false;
	} else if (strongRegex.test(pwd.value)) {
	strength.innerHTML = "<span> Fort!</span>";
	strength.style.color="green";
	return true;
	} else if (mediumRegex.test(pwd.value)) {
	strength.innerHTML = "<span> Moyen!</span>";
	strength.style.color="orange";
	return true;
	} else {
	strength.innerHTML = "<span> Faible!</span>";
	strength.style.color="red";
	return false;
	}
}