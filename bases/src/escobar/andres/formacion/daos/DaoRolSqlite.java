package escobar.andres.formacion.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import escobar.andres.formacion.bibliotecas.DaoException;
import escobar.andres.formacion.bibliotecas.DaoJdbc;
import escobar.andres.formacion.pojos.Rol;

public class DaoRolSqlite extends DaoJdbc<Rol> implements DaoRol {

	public DaoRolSqlite(String url) {
		super(url);
	}

	@Override
	public Iterable<Rol> obtenerTodos() {
		return ejecutarConsultaSql("SELECT * FROM roles", rs -> filaAObjeto(rs));
	}

	@Override
	public Rol obtenerPorId(Long id) {
		return ejecutarConsultaSqlUno("SELECT * FROM roles WHERE id=?", rs -> filaAObjeto(rs), id);
	}
	
	private Rol filaAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");
			var descripcion = rs.getString("descripcion");
			
			return new Rol(id, nombre, descripcion);
		} catch (SQLException e) {
			throw new DaoException("No se ha podido procesar el rol");
		}
	}
}
