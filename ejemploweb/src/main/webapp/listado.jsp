<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/includes/cabecera.jsp" %>

	<ul>
		<c:forEach items="${personas}" var="persona">
			<li>${persona.nombre}: ${persona.fechaNacimiento}, ${persona.edad} ${persona.rol.nombre}</li>
		</c:forEach>
	</ul>

<%@ include file="/includes/pie.jsp" %>>