<?php
function get_pais($conn, $paisId){
	require 'DBconfig.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.pais WHERE pais_id = '.$paisId);
	$res = $result->fetch_row();
	$return = null;
	$campos = array("pais_id", "nombre");
	
	if(!is_null($res)){
		$return = limpiar_pais($res,$campos);
	}
	return $return;
}

function get_all_paises($conn){
	require 'DBconfig.php';
	require_once 'Ciudad.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.pais');
	$res = $result->fetch_row();
	$return = array();
	$campos = array("pais_id", "nombre");
	
	while(!is_null($res)){
		$return[] = limpiar_pais($res,$campos);
		$res = $result->fetch_row();
	}
	
	$size = count($return);
	for($i = 0; $i<$size; $i++){
		$return[$i]["ciudades"] = get_ciudades($conn, $return[$i]['pais_id']);
	}
	
	return $return;
}

function limpiar_pais($pais, $columnas){
	$res = array();
	$size = count($columnas);
	for($i=0; $i<$size; $i++){
		$res[$columnas[$i]] = $pais[$i];
	}
	return $res;
}
