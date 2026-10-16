package escobar.andres.formacion.ejemplos.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saludo")
public class Saludar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			
			String nombre = request.getParameter("nombre");
			
			response.getWriter().printf("""
					<!DOCTYPE html>
					<html>
					<head>
					</head>
					<body>
						<h1>Hola %s</h1>
					</body>
					</html>
					""", nombre);
		}
}
