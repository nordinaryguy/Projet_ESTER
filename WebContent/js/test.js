
function init (){
	
	function $_GET(param){
		var vars = {};
		window.location.href.replace(location.hash,'').replace(/[?&]+([^=&]+)=?([^&]*)?/gi, //regexp,
				function(m,key,value){ //callback
			vars[key] = value !== undefined ? value : '';
			}
		);
		
		if (param){
			return vars[param] ? vars[param] : null;
		}
		return vars;
	}
	
	var $_GET = $_GET();
	$("#container_page").load($_GET['type']+" #container");

}