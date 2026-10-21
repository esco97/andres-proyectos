package escobar.andres.formacion.tienda.controladores;

import java.io.IOException;

import escobar.andres.formacion.tienda.accesodatos.DaoProducto;
import escobar.andres.formacion.tienda.accesodatos.DaoProductoSqlite;
import escobar.andres.formacion.tienda.mocks.TiendaMock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin/listado")
public class ListadoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información al formato necesario
		// Crear objeto basado en información individual
		// Ejecutar lógica de negocio
		DaoProducto dao = new DaoProductoSqlite("jdbc:sqlite:C:/Users/Andres/git/andres-proyectos-bueno/bases/bdd/tienda.db");
		
		var productos = dao.obtenerTodos();
				
		// Preparar modelo para siguiente vista
			request.setAttribute("productos", productos);
		
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/admin/listado.jsp").forward(request, response);

	}

}
