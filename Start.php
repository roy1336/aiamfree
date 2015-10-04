<?php
require_once "Models/DBconfig.php";
require_once "Models/Freelancer.php";
require_once "Models/Proyecto.php";
require_once "Models/Idioma.php";
require_once "Models/Pais.php";
require_once "Models/Profesion.php";
require_once "Models/Ciudad.php";

$data = array();

if(!isset($conn)){
	$conn = new mysqli($mysql_host, $mysql_user, $mysql_password, $mysql_database);
}

$freelancers = get_all_freelancer($conn);
//$idiomas = get_all_idiomas($conn);
//$paises = get_all_paises($conn);
//$profesiones = get_all_profesiones($conn);

$data['freelancers']=$freelancers;
//$data['idiomas']=$idiomas;
//$data['paises']=$paises;
//$data['profesiones']=$profesiones;

header("Access-Control-Allow-Origin: *");
print_r(json_encode($freelancers));

?>