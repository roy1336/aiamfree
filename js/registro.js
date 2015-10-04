
var datos={"nombre":"",
			"correo":"",
			"password":"",
			"repassword":"",
			"ciudad":"",
		"twitter":"",
	"facebook":"",
"instagram":"",
"profesion":"",
"idiomas":[],
"competencias":""};

lista_habilidades=[];

$(function(){
	$('#enviar-formulario').click(function(){
		for(llave in datos){
			if(llave != 'idiomas' && llave != 'competencias'){
			datos[llave] = $('#'+llave).val();
		}
}
		array = $('.idioma-input');
		for(i =0; i< array.length; i++){
			if(array[i].checked){
				datos['idiomas'].push(array[i].value());
			}
		}
competencias = "";

		for(i =0; i< lista_habilidades.length -1; i++){
			competencias += lista_habilidades[i]+ "; ";
	}
	if(lista_habilidades.length > 0)
competencias += lista_habilidades[lista_habilidades.length -1]

datos["competencias"] = competencias;

redirect.click();
	});
});


