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
		<tr>
			<th>1</th>
			<th>Portatil</th>
			<th>1024,23€</th>
			<td><a href="formulario">Editar</a> <a href="listado">Borrar</a>
			</td>
		</tr>
	</tbody>

	<tfoot>
		<tr>
			<td colspan="3"></td>
			<td><a href="formulario">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>