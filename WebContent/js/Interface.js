
function init(){
	function GET_param(param){
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
	
	var $_GET = GET_param();
	$("#gjs").load($_GET['type']+" #container", function() {
		grapesjs.init({
	        showOffsets: 1,
	        noticeOnUnload: 0,
	        storageManager: { autoload: 0 },
	        height: '600px',
	        width: 'auto',
	        container: '#gjs',
	        fromElement: true,
	        showDevices: false,
	        plugins: ['grapesjs-blocks-bootstrap4'],
	        pluginsOpts: {
	          'grapesjs-blocks-bootstrap4': {
	            blocks: {},
	            blockCategories: {},
	            labels: {},
	            gridDevicesPanel: true
	          }
	        },
	        blockManager: {
	            appendTo: '#blocks',
	            blocks: [
	              {
	                id: 'section', // id is mandatory
	                label: '<b>Section</b>', // You can use HTML/SVG inside labels
	                attributes: { class:'gjs-block-section' },
	                content: `<section>
	                  <h1>This is a simple title</h1>
	                  <div>This is just a Lorem text: Lorem ipsum dolor sit amet</div>
	                </section>`,
	              }, {
	                id: 'text',
	                label: 'Text',
	                content: '<div data-gjs-type="text">Insert your text here</div>',
	              }, {
	                id: 'image',
	                label: 'Image',
	                // Select the component once it's dropped
	                select: true,
	                // You can pass components as a JSON instead of a simple HTML string,
	                // in this case we also use a defined component type `image`
	                content: { type: 'image' },
	                // This triggers `active` event on dropped components and the `image`
	                // reacts by opening the AssetManager
	                activate: true,
	              }
	            ]
	          },
	        canvas: {
	          styles: [
	            'https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'
	          ],
	          scripts: [
	            'https://code.jquery.com/jquery-3.3.1.min.js',
	            'https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js',
	            'https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js'
	          ],
	        }
		});
	});
}

function Verifie_annulation(){
	var verif=confirm("Êtes-vous sûr de vouloir annuler les modifiations");
	if(verif){
		window.close();
	}	 
}

function valider(){
	
}

function reset(){
	
}


