package escobar.andres.formacion.controladores;

import java.io.IOException;
import java.time.LocalDate;

import escobar.andres.formacion.daos.DaoPersonaSqlite;
import escobar.andres.formacion.pojos.Persona;
import escobar.andres.formacion.pojos.Rol;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger información de la petición
		String nombre = request.getParameter("nombre");
		String strFechaNacimiento = request.getParameter("fecha-nacimiento");
		
		// Convertir la información al formato necesario
		LocalDate fechaNacimiento = LocalDate.parse(strFechaNacimiento);
		
		// Crear objeto basado en información individual
		var rol = new Rol(2L, null, null);
		var persona = new Persona(null, nombre,fechaNacimiento, rol);
		
		// Ejecutar lógica de negocio
		var dao = new DaoPersonaSqlite("jdbc:sqlite:C:/Users/Andres/git/andres-proyectos-bueno/bases/bdd/tienda.db");

		dao.insertar(persona);

		// Preparar modelo para siguiente vista
		// Saltar a la siguiente vista
		response.sendRedirect("listado");
	}

}
