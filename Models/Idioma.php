<?php
function get_idioma($conn, $idiomaId){
	require 'DBconfig.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.idioma WHERE idioma_id = '.$idiomaId);
	$res = $result->fetch_row();
	$return = null;
	$campos = array("idioma_id", "nombre");
	
	if(!is_null($res)){
		$return = limpiar_idioma($res,$campos);
	}
	
	return $return;
}

function get_idiomas($conn, $freelancerId){
	require 'DBconfig.php';
	
	$result = $conn->query('SELECT idioma_id FROM '.$mysql_database.'.freelancer_idioma WHERE freelancer_id='.$freelancerId);
	$res = $result->fetch_row();
	$return = array();
	$campos = array("idioma_id", "nombre");
	
	while(!is_null($res)){
		$return[] = get_idioma($conn,$res[0]);
		$res = $result->fetch_row();
	}
	
	return $return;
}

function get_all_idiomas($conn){
	require 'DBconfig.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.idioma');
	$res = $result->fetch_row();
	$return = array();
	$campos = array("idioma_id", "nombre");
	
	while(!is_null($res)){
		$return[] = limpiar_idioma($res,$campos);
		$res = $result->fetch_row();
	}
	
	return $return;
}

function limpiar_idioma($idioma, $columnas){
	$res = array();
	$size = count($columnas);
	for($i=0; $i<$size; $i++){
		$res[$columnas[$i]] = $idioma[$i];
	}
	return $res;
}
