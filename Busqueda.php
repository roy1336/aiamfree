<?php
require_once "Models/DBconfig.php";

if(!isset($conn)){
	$conn = new mysqli($mysql_host, $mysql_user, $mysql_password, $mysql_database);
}

$busqueda = 0;

if(isset($_GET['idioma'])){
	$busqueda += 1;
}
if(isset($_GET['competencias'])){
	$busqueda += 2;
}
if(isset($_GET['profesion'])){
	$busqueda += 4;
}

switch($busqueda){
	case 1://buscar solo idioma
		//$where;
		break;
	case 2://buscar solo competencias
		break;
	case 3://buscar idioma y competencias
		break;
	case 4://buscar solo profesion
		break;
	case 5://buscar idioma y profesion
		break;
	case 6://buscar profesion y competencias
		break;
	case 7://buscar todo
		break;
	default:
		$where = '1=2';
		break;
}

$result = $conn->query('SELECT * FROM '.$mysql_database.'.freelancer WHERE '.$where);



