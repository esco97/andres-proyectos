package escobar.andres.formacion.ejemplos.servlets;

import java.io.IOException;

import escobar.andres.formacion.daos.DaoPersona;
import escobar.andres.formacion.daos.DaoPersonaSqlite;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscarpersona")
public class BuscarPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			
			String sId = request.getParameter("id");
			Long id = Long.parseLong(sId);
			
			DaoPersona dao = new DaoPersonaSqlite("jdbc:sqlite:C:/Users/Andres/git/andres-proyectos-bueno/bases/bdd/tienda.db");
			
			var persona = dao.obtenerPorId(id);
			
			response.getWriter().printf("""
					<!DOCTYPE html>
					<html>
					<head>
					</head>
					<body>
						<h1>%s</h1>
					</body>
					</html>
					""", persona.getNombre());
		}
}
