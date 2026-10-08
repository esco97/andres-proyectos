package escobar.andres.formacion.daos;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.pojos.Persona;

public interface DaoPersona extends Dao<Persona> {
	default Iterable<Persona> obtenerPorNombre(String nombre){
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
