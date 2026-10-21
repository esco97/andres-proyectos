package escobar.andres.formacion.tienda.accesodatos;

import escobar.andres.formacion.bibliotecas.DaoJdbc;
import escobar.andres.formacion.tienda.mocks.TiendaMock;
import escobar.andres.formacion.tienda.modelos.Producto;

public class DaoProductoSqlite extends DaoJdbc<Producto> implements DaoProducto{

	public DaoProductoSqlite(String url) {
		super(url);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return TiendaMock.PRODUCTOS.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return TiendaMock.PRODUCTOS.get(id);
	}

	@Override
	public void insertar(Producto producto) {
		System.out.println("INSERTAR: " + producto);
	}

	@Override
	public void modificar(Producto producto) {
		System.out.println("MODIFICAR: " + producto);
	}

	
}
