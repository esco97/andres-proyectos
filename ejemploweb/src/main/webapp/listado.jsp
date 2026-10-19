<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>

	<ul>
		<c:forEach items="${personas}" var="persona">
			<li>${persona.nombre}: ${persona.fechaNacimiento}, ${persona.edad} ${persona.rol.nombre}</li>
		</c:forEach>
	</ul>

</body>
</html>