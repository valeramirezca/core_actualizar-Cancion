<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de Cancion</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>Detalle de cancion</h1>
	<p>${cancion.titulo}</p>
	<p>Artista: ${cancion.artista}</p>
	<p>Album: ${cancion.album}</p>
	<p>Genero: ${cancion.genero}</p>
	<p>Idioma: ${cancion.idioma}</p>
	<a href="/canciones/formulario/editar/${cancion.id}">Editar cancion</a>
<br>
    <a href="/canciones/eliminar/${cancion.id}">Eliminar cancion</a>
<br>
	<a href="/canciones">Volver a lista de canciones</a>
	
</body>
</html>
