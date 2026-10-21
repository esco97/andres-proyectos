package escobar.andres.formacion.tienda.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import escobar.andres.formacion.tienda.accesodatos.DaoProducto;
import escobar.andres.formacion.tienda.accesodatos.DaoProductoSqlite;
import escobar.andres.formacion.tienda.modelos.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/formulario")
public class FormularioAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		String sId = request.getParameter("id");

		if (sId != null) {
			// Convertir la información al formato necesario
			Long id = Long.parseLong(sId);
			// Crear objeto basado en información individual
			// Ejecutar lógica de negocio
			DaoProducto dao = new DaoProductoSqlite("jdbc:sqlite:C:/Users/Andres/git/andres-proyectos-bueno/bases/bdd/tienda.db");
			var producto = dao.obtenerPorId(id);
			// Preparar modelo para siguiente vista
			request.setAttribute("producto", producto);
		}
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/admin/formulario.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		
		// Convertir la información al formato necesario
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		BigDecimal precio = new BigDecimal(sPrecio);
		
		// Crear objeto basado en información individual
		Producto producto = new Producto(id, nombre, precio);
		
		// Ejecutar lógica de negocio
		DaoProducto dao = new DaoProductoSqlite("jdbc:sqlite:C:/Users/Andres/git/andres-proyectos-bueno/bases/bdd/tienda.db");

		if(id == null) {
			dao.insertar(producto);
		} else {
			dao.modificar(producto);
		}

		System.out.println(producto);
		
		// Preparar modelo para siguiente vista
		// Saltar a la siguiente vista
		response.sendRedirect("listado");
	}
}
