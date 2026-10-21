package escobar.andres.formacion.tienda.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;

import escobar.andres.formacion.bibliotecas.DaoException;
import escobar.andres.formacion.bibliotecas.DaoJdbc;
import escobar.andres.formacion.tienda.mocks.TiendaMock;
import escobar.andres.formacion.tienda.modelos.Producto;

public class DaoProductoSqlite extends DaoJdbc<Producto> implements DaoProducto{

	public DaoProductoSqlite(String url) {
		super(url);

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new DaoException("No se ha podido encontrar el driver de SQLite", e);
		}
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return ejecutarConsultaSql("SELECT * FROM productos", rs -> filaAProductos(rs));
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return ejecutarConsultaSqlUno("SELECT * FROM productos WHERE id=?", rs -> filaAProductos(rs), id);
	}

	@Override
	public void insertar(Producto producto) {
		ejecutarConsultaSql("INSERT INTO productos (nombre, precio) VALUES (?,?)", producto.getNombre(), producto.getPrecio());
	}

	@Override
	public void modificar(Producto producto) {
		ejecutarConsultaSql("UPDATE productos SET nombre=?, precio=? WHERE id=?", producto.getNombre(), producto.getPrecio(), producto.getId());
	}

	@Override
	public void borrar(Long id) {
		ejecutarConsultaSql("DELETE FROM productos WHERE id=?", id);
	}

	private Producto filaAProductos(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");
			var precio = rs.getBigDecimal("precio");
			
			return new Producto(id, nombre, precio);
		} catch (SQLException e) {
			throw new DaoException("Fallo al mapear", e);
		}
	}

	
}
