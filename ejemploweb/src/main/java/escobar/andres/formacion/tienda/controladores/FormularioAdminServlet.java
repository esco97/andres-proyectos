package escobar.andres.formacion.tienda.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import escobar.andres.formacion.tienda.mocks.TiendaMock;

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
			var producto = TiendaMock.PRODUCTOS.get(id);
			// Preparar modelo para siguiente vista
			request.setAttribute("producto", producto);
		}
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/admin/formulario.jsp").forward(request, response);

	}

}
