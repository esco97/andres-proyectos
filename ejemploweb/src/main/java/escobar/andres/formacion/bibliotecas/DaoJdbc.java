package escobar.andres.formacion.bibliotecas;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Function;

public class DaoJdbc<T> {
		
	private final String url;

	public DaoJdbc(String url) {
		super();
		this.url = url;
	}

	protected T ejecutarConsultaSqlUno(String sql, Function<ResultSet, T> mapeador, Object... parametros) {
		var objetos = ejecutarConsultaSql(sql, mapeador, parametros);
		
		if (objetos.iterator().hasNext()) {
			return objetos.iterator().next();
		} else {
			return null;
		}
	}

	protected Iterable<T> ejecutarConsultaSql(String sql, Object... parametros) {
		return ejecutarConsultaSql(sql, null, parametros);
	}

	protected Iterable<T> ejecutarConsultaSql(String sql, Function<ResultSet, T> mapeador, Object... parametros) {
		try (var con = DriverManager.getConnection(url); var pst = con.prepareStatement(sql);) {
	
			int posicion = 1;
	
			for (var parametro : parametros) {

				if(parametro == null && posicion == parametros.length) {
					break;
				}
				
				pst.setObject(posicion, parametro);
				posicion++;
			}
	
			if (mapeador != null) {
				var rs = pst.executeQuery();
				var objetos = new ArrayList<T>();
	
				while (rs.next()) {
					objetos.add(mapeador.apply(rs));
				}
				return objetos;
			} else {
				pst.executeUpdate();
				return null;
			}
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

}