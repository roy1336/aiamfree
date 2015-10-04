<?php
function get_freelancer($conn,$id){
	require 'DBconfig.php';
	require_once 'Idioma.php';
	require_once 'Ciudad.php';
	require_once 'Profesion.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.freelancer WHERE freelancer_id = '.$id);
	
	$res = $result->fetch_row();
	$freelancer = null;
	$campos = array("freelancer_id", "nombre", "correo", "disponibilidad", "rating", "facebook", "twitter", "instagram", "password", "celular", "competencias", "profesion_id", "ciudad_id");
	if(!is_null($res)){
		$freelancer = limpiar_freelancer($res, $campos);
		$freelancer["profesion"] = get_profesion($conn, $freelancer['profesion_id']);
		$freelancer["idiomas"] = get_idiomas($conn, $freelancer['freelancer_id']);
		$freelancer["ubicacion"] = get_ubicacion($conn, $freelancer['ciudad_id']);
		unset($freelancer["ciudad_id"]);
		unset($freelancer["profesion_id"]);
	}
	return $freelancer;
}

function get_all_freelancer($conn){
	require 'DBconfig.php';
	require_once 'Proyecto.php';
	require_once 'Idioma.php';
	require_once 'Ciudad.php';
	require_once 'Profesion.php';
	
	$result = $conn->query('SELECT * FROM '.$mysql_database.'.freelancer');
	$res = $result->fetch_row();
	$return = array();
	$campos = array("freelancer_id", "nombre", "correo", "disponibilidad", "rating", "facebook", "twitter", "instagram", "password", "celular", "competencias", "profesion_id", "ciudad_id");
	
	while(!is_null($res)){
		$return[] = limpiar_freelancer($res,$campos);
		$res = $result->fetch_row();
	}

	$size = count($return);
	
	for($i = 0; $i<$size; $i++){
		$return[$i]["proyectos"] = get_proyectos($conn, $return[$i]['freelancer_id']);
		$return[$i]["profesion"] = get_profesion($conn, $return[$i]['profesion_id']);
		$return[$i]["idiomas"] = get_idiomas($conn, $return[$i]['freelancer_id']);
		$return[$i]["ubicacion"] = get_ubicacion($conn, $return[$i]['ciudad_id']);
		unset($return[$i]["ciudad_id"]);
		unset($return[$i]["profesion_id"]);
	}
	
	
	return $return;
}

function limpiar_freelancer($freelancer, $columnas){
	$res = array();
	$size = count($columnas);
	for($i=0; $i<$size; $i++){
		$res[$columnas[$i]] = $freelancer[$i];
	}
	return $res;
}
