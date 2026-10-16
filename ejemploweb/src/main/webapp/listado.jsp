<%@ page import="escobar.andres.formacion.pojos.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
Iterable<Persona> personas = (Iterable<Persona>) request.getAttribute("personas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<%
		for (var persona : personas) {
		%>
		<li><%=persona%></li>
		<%
		}
		%>
	</ul>

</body>
</html>