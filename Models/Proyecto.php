<?php

function get_proyectos($conn,$freelancer_id){
	require 'DBconfig.php';

	$result = $conn->query('SELECT proyecto_id, link, descripcion, imagen, nombre FROM '.$mysql_database.'.proyecto WHERE freelancer_id = '.$freelancer_id);
	
	$proyectos = array();
	$res = $result->fetch_row();
	
	while(!is_null($res)){
		$proyectos[] = limpiar_proyecto($res);
		$res = $result->fetch_row();
	}
	return $proyectos;
}

function limpiar_proyecto($proyecto){
	$limpio = array();
	$limpio["proyecto_id"] = $proyecto[0];
	$limpio["link"] = $proyecto[1];
	$limpio["descripcion"] = $proyecto[2];
	$limpio["imagen"] = $proyecto[3];
	$limpio["nombre"] = $proyecto[4];
	
	return $limpio;
}