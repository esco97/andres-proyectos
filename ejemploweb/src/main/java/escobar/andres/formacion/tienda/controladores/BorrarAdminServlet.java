package escobar.andres.formacion.tienda.controladores;

import java.io.IOException;

import escobar.andres.formacion.tienda.mocks.TiendaMock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin/borrar")
public class BorrarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		String sId = request.getParameter("id");
		
		// Convertir la información al formato necesario
		Long id = Long.parseLong(sId);
		
		// Crear objeto basado en información individual
		// Ejecutar lógica de negocio
		System.out.println("Borrando producto id " + id);
		
		// Preparar modelo para siguiente vista
			request.setAttribute("productos", TiendaMock.PRODUCTOS.values());
		
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/admin/listado.jsp").forward(request, response);

	}

}
