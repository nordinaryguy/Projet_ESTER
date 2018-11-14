
function actualise_Questionnaires(){
	function $_GET(param){
		var vars = {};
		window.location.href.replace(location.hash,'').replace(/[?&]+([^=&]+)?=([^&]*)?/gi, //regexp,
				function(m,key,value){ //callback	test.html?type=Accueil.html test.html?page=Accueil.html
			vars[key] = value !== undefined ? value : '';
			}
		);
//		
		if (param){
			return vars[param] ? vars[param] : null;
		}
		return vars;
	}
	
	var $_GET = $_GET();
	$("#container_pourTout").load($_GET['page']+" #container_lien", function() {
		
		
	});
	

}