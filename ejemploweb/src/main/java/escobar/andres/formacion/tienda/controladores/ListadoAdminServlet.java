package escobar.andres.formacion.tienda.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import escobar.andres.formacion.tienda.modelos.Producto;
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
			var productos = List.of(
				new Producto(1L, "Portátil", new BigDecimal("1234.56")),
				new Producto(2L, "Ratón", new BigDecimal("34.56")),
				new Producto(3L, "Monitor", new BigDecimal("234.56"))
				);
		
		// Preparar modelo para siguiente vista
			request.setAttribute("productos", productos);
		
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/admin/listado.jsp").forward(request, response);

	}

}
