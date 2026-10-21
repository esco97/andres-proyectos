<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Opciones</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th>${p.id}</th>
				<td>${p.nombre}</td>
				<td><fmt:formatNumber type="currency" value="${p.precio}" /></td>
				<td><a href="formulario?id=${p.id}">Editar</a> <a href="listado">Borrar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

	<tfoot>
		<tr>
			<td colspan="3"></td>
			<td><a href="formulario">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>