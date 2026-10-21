<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<!--<p>${producto}</p>-->

<form action="listado" method="post">
		<input type="text" placeholder="Nombre" value="${producto.nombre}">
		<input type="number" step=".01" placeholder="Precio" value="${producto.precio}">
		
		<button>Guardar</button>
	</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>