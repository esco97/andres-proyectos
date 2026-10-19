<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<form action="formulario" method="post">
		<input type="text" placeholder="Nombre">
		<input type="number" step=".01" placeholder="Precio">
		
		<button>Guardar</button>
	</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>