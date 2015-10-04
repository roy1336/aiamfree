<?php
function get_profesion($conn, $profesionId){
	require 'DBconfig.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.profesion WHERE profesion_id = '.$profesionId);
	$res = $result->fetch_row();
	$return = null;
	$campos = array("profesion_id", "nombre");
	
	if(!is_null($res)){
		$return = limpiar_profesion($res,$campos);
	}
	
	return $return;
}

function get_all_profesiones($conn){
	require 'DBconfig.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.profesion');
	$res = $result->fetch_row();
	$return = array();
	$campos = array("profesion_id", "nombre");
	
	while(!is_null($res)){
		$return[] = limpiar_profesion($res,$campos);
		$res = $result->fetch_row();
	}
	
	$size = count($return);
	
	return $return;
}

function limpiar_profesion($profesion, $columnas){
	$res = array();
	$size = count($columnas);
	for($i=0; $i<$size; $i++){
		$res[$columnas[$i]] = $profesion[$i];
	}
	return $res;
}
