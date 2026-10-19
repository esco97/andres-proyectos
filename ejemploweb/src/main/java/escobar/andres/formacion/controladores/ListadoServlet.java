package escobar.andres.formacion.controladores;

import java.io.IOException;

import escobar.andres.formacion.daos.DaoPersona;
import escobar.andres.formacion.daos.DaoPersonaSqlite;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información al formato necesario
		// Crear objeto basado en información individual
		// Ejecutar lógica de negocio
		var dao = new DaoPersonaSqlite("jdbc:sqlite:C:/Users/Andres/git/andres-proyectos-bueno/bases/bdd/tienda.db");

		var personas = dao.obtenerTodosConRol();

		// Preparar modelo para siguiente vista
		request.setAttribute("personas", personas);

		// Saltar a la siguiente vista
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
