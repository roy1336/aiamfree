<?php
require_once "Models/DBconfig.php";
require_once "Models/Freelancer.php";
require_once "Models/Proyecto.php";

header("Access-Control-Allow-Origin: *");
if(!isset($conn)){
	$conn = new mysqli($mysql_host, $mysql_user, $mysql_password, $mysql_database);
}

$result = array();

$result['user'] = array();
$result['proyectos'] = array();

if(isset($_GET['id'])){
	$id = $_GET['id'];
	$usuario = get_freelancer($conn, $id);
	
	if(!is_null($usuario)){	
		$result['user'] = $usuario;
		$result['proyectos'] = get_proyectos($conn, $usuario['freelancer_id']);
		$conn->close();
		echo json_encode($result);
		
		
	}else{
		$conn->close();
		die(json_encode($result));
	}
}else{
	$conn->close();
	die(json_encode($result));
}