<?php
function get_ubicacion($conn, $ciudadId){
	require 'DBconfig.php';
	require_once 'Pais.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.ciudad WHERE ciudad_id = '.$ciudadId);
	$res = $result->fetch_row();
	$return = array();
	$campos = array("ciudad_id", "nombre", "pais_id");
	$ciudad = null;
	
	if(!is_null($res)){
		$ciudad = limpiar_ciudad($res,$campos);
		$return['pais'] = get_pais($conn, $ciudad['pais_id']);
	}else{
		$return['pais'] = null;
	}
	$return['ciudad'] = $ciudad;
	
	return $return;
}

function get_ciudades($conn, $paisId){
	require 'DBconfig.php';

	$result = $conn->query('SELECT ciudad_id, nombre FROM '.$mysql_database.'.ciudad WHERE pais_id = '.$paisId);
	$campos = array("ciudad_id", "nombre");
	
	$ciudades = array();
	$res = $result->fetch_row();
	
	while(!is_null($res)){
		$ciudades[] = limpiar_ciudad($res,$campos);
		$res = $result->fetch_row();
	}
	return $ciudades;
}

function limpiar_ciudad($ciudad, $columnas){
	$res = array();
	$size = count($columnas);
	for($i=0; $i<$size; $i++){
		$res[$columnas[$i]] = $ciudad[$i];
	}
	return $res;
}
