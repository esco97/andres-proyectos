<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<!--<p>${producto}</p>-->

<form action="formulario" method="post">
		<input name=id type="hidden" value="${producto.id}">
		<input name="nombre" type="text" placeholder="Nombre" value="${producto.nombre}">
		<input name="precio" type="number" step=".01" placeholder="Precio" value="${producto.precio}">
		
		<button>Guardar</button>
	</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>