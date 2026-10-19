<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>

	<form action="formulario" method="post">
		<input type="text" name="nombre" placeholder="Nombre">
		<input type="date" name="fecha-nacimiento" placeholder="Fecha de nacimiento">
		
		<button>Guardar</button>
	</form>

</body>
</html>