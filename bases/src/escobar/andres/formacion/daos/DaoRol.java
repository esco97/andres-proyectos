package escobar.andres.formacion.daos;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.pojos.Rol;

public interface DaoRol extends Dao<Rol> {
	default Rol obtenerPorNombre(String nombre) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}