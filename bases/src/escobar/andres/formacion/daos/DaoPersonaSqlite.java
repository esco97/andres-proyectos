package escobar.andres.formacion.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import escobar.andres.formacion.bibliotecas.DaoException;
import escobar.andres.formacion.bibliotecas.DaoJdbc;
import escobar.andres.formacion.pojos.Persona;
import escobar.andres.formacion.pojos.Rol;

public class DaoPersonaSqlite extends DaoJdbc<Persona> implements DaoPersona {

	public DaoPersonaSqlite(String url) {
		super(url);
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		return ejecutarConsultaSql("SELECT * FROM personas", rs -> filaAObjeto(rs));
	}

	@Override
	public Iterable<Persona> obtenerTodosConRol() {
		return ejecutarConsultaSql("""
				SELECT p.*, r.nombre rol_nombre, r.descripcion rol_descripcion
				FROM personas p
				JOIN roles r ON p.rol_id = r.id;
				""", rs -> filaAObjetoConRol(rs));
	}

	@Override
	public Persona obtenerPorIdConRol(Long id) {
		return ejecutarConsultaSqlUno("""
				SELECT p.*, r.nombre rol_nombre, r.descripcion rol_descripcion
				FROM personas p
				JOIN roles r ON p.rol_id = r.id
				WHERE p.id=?
				""", rs -> filaAObjeto(rs), id);
	}
	
	@Override
	public Iterable<Persona> obtenerPorNombre(String nombre) {
		return ejecutarConsultaSql("SELECT * FROM personas WHERE nombre LIKE ?", rs -> filaAObjeto(rs), "%" + nombre + "%");
	}

	@Override
	public Persona obtenerPorId(Long id) {
		return ejecutarConsultaSqlUno("SELECT * FROM personas WHERE id=?", rs -> filaAObjeto(rs), id);
	}

	@Override
	public void insertar(Persona persona) {
		ejecutarConsultaSql("INSERT INTO personas (nombre, fecha_nacimiento, rol_id) VALUES (?,?,?)",
				objetoAFila(persona));
	}

	@Override
	public void modificar(Persona persona) {
		ejecutarConsultaSql("UPDATE personas SET nombre=?, fecha_nacimiento=?, rol_id=? WHERE id=?",
				objetoAFila(persona));
	}

	@Override
	public void borrar(Long id) {
		ejecutarConsultaSql("DELETE FROM personas WHERE id=?", id);
	}

	private static Persona filaAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");

			var fechaNacimientoOriginal = rs.getString("fecha_nacimiento");
			var fechaNacimiento = fechaNacimientoOriginal == null || fechaNacimientoOriginal.isBlank() ? null
					: LocalDate.parse(fechaNacimientoOriginal);

			return new Persona(id, nombre, fechaNacimiento);
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	private static Persona filaAObjetoConRol(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");

			var fechaNacimientoOriginal = rs.getString("fecha_nacimiento");
			var fechaNacimiento = fechaNacimientoOriginal == null || fechaNacimientoOriginal.isBlank() ? null
					: LocalDate.parse(fechaNacimientoOriginal);

			var idRol = rs.getLong("rol_id");
			var nombreRol = rs.getString("rol_nombre");
			var descripcionRol = rs.getString("rol_descripcion");

			var rol = new Rol(idRol, nombreRol, descripcionRol);

			return new Persona(id, nombre, fechaNacimiento, rol);
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	private static Object[] objetoAFila(Persona persona) {
		return new Object[] { persona.getNombre(),
				persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString(),
				persona.getRol().getId(), persona.getId() };
	}
}

	/*
	 * Primeras Sqlite
	 * 
	 * @Override public Iterable<Persona> obtenerTodos() { try (var con =
	 * DriverManager.getConnection(url); var pst =
	 * con.prepareStatement("SELECT * FROM personas"); var rs = pst.executeQuery())
	 * { var personas = new ArrayList<Persona>();
	 * 
	 * while (rs.next()) { var id = rs.getLong("id"); var nombre =
	 * rs.getString("nombre");
	 * 
	 * var fechaNacimientoOriginal = rs.getString("fecha_nacimiento"); var
	 * fechaNacimiento = fechaNacimientoOriginal == null ? null :
	 * LocalDate.parse(fechaNacimientoOriginal);
	 * 
	 * var persona = new Persona(id, nombre, fechaNacimiento);
	 * 
	 * personas.add(persona); }
	 * 
	 * return personas; } catch (SQLException e) { throw new
	 * DaoException("No se ha podido hacer la operación con la base de datos", e); }
	 *
	 * }
	 * 
	 * @Override public Persona obtenerPorId(Long id) { try (var con =
	 * DriverManager.getConnection(url); var pst =
	 * con.prepareStatement("SELECT * FROM personas WHERE id=?"); ) { pst.setLong(1,
	 * id);
	 * 
	 * var rs = pst.executeQuery();
	 * 
	 * while (rs.next()) { var nombre = rs.getString("nombre");
	 * 
	 * var fechaNacimientoOriginal = rs.getString("fecha_nacimiento"); var
	 * fechaNacimiento = fechaNacimientoOriginal == null ? null :
	 * LocalDate.parse(fechaNacimientoOriginal);
	 * 
	 * var persona = new Persona(id, nombre, fechaNacimiento);
	 * 
	 * return persona; }
	 * 
	 * return null; } catch (SQLException e) { throw new
	 * DaoException("No se ha podido hacer la operación con la base de datos", e); }
	 *
	 * }
	 * 
	 * @Override public void insertar(Persona persona) { try (var con =
	 * DriverManager.getConnection(url)) { var pst = con.
	 * prepareStatement("INSERT INTO personas (nombre, fecha_nacimiento) VALUES(?,?)"
	 * );
	 * 
	 * pst.setString(1, persona.getNombre()); pst.setString(2,
	 * persona.getFechaNacimiento() == null ? null :
	 * persona.getFechaNacimiento().toString());
	 * 
	 * pst.executeUpdate(); } catch (SQLException e) { throw new
	 * DaoException("No se ha podido hacer la operación con la base de datos", e);
	 * }* }
	 * 
	 * @Override public void modificar(Persona persona) { try (var con =
	 * DriverManager.getConnection(url)) { var pst = con.
	 * prepareStatement("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?"
	 * );
	 * 
	 * pst.setString(1, persona.getNombre()); pst.setString(2,
	 * persona.getFechaNacimiento() == null ? null :
	 * persona.getFechaNacimiento().toString()); pst.setLong(3, persona.getId());
	 * 
	 * pst.executeUpdate(); } catch (SQLException e) { throw new
	 * DaoException("No se ha podido hacer la operación con la base de datos", e);
	 * }* }
	 * 
	 * @Override public void borrar(Long id) { try (var con =
	 * DriverManager.getConnection(url)) { var pst =
	 * con.prepareStatement("DELETE FROM personas WHERE id=?");
	 * 
	 * pst.setLong(1, id);
	 * 
	 * pst.executeUpdate(); } catch (SQLException e) { throw new
	 * DaoException("No se ha podido hacer la operación con la base de datos", e);
	 * }* }
	 */