<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp" %>>

	<form action="formulario" method="post">
		<input type="text" name="nombre" placeholder="Nombre">
		<input type="date" name="fecha-nacimiento" placeholder="Fecha de nacimiento">
		
		<button>Guardar</button>
	</form>

<%@ include file="/includes/pie.jsp" %>>