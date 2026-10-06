package escobar.andres.formacion.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.bibliotecas.DaoException;
import escobar.andres.formacion.bibliotecas.DaoJdbc;
import escobar.andres.formacion.pojos.Persona;

public class DaoPersonaSqlite extends DaoJdbc<Persona> implements Dao<Persona> {

	public DaoPersonaSqlite(String url) {
		super(url);
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		return ejecutarConsultaSql("SELECT * FROM personas", rs -> filAObjeto(rs));
	}

	@Override
	public Persona obtenerPorId(Long id) {
		return ejecutarConsultaSqlUno("SELECT * FROM personas WHERE id=?", rs -> filAObjeto(rs), id);
	}

	@Override
	public void insertar(Persona persona) {
		ejecutarConsultaSql("INSERT INTO personas (nombre, fecha_nacimiento) VALUES(?,?)", persona.getNombre(),
				persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString());
	}

	@Override
	public void modificar(Persona persona) {
		ejecutarConsultaSql("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?", objetoAFila(persona));
	}

	@Override
	public void borrar(Long id) {
		ejecutarConsultaSql("DELETE FROM personas WHERE id=?", id);
	}

	private static Persona filAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");

			var fechaNacimientoOriginal = rs.getString("fecha_nacimiento");
			var fechaNacimiento = fechaNacimientoOriginal == null ? null : LocalDate.parse(fechaNacimientoOriginal);

			return new Persona(id, nombre, fechaNacimiento);
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	private static Object[] objetoAFila(Persona persona) {
		return new Object[] { persona.getNombre(),
				persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString(), persona.getId() };
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

}
