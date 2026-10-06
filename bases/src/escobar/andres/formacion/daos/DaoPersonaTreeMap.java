package escobar.andres.formacion.daos;

import java.util.SortedMap;
import java.util.TreeMap;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.pojos.Persona;

public class DaoPersonaTreeMap implements Dao<Persona>{
	protected static SortedMap<Long, Persona> personas = new TreeMap<>();

	@Override
	public Iterable<Persona> obtenerTodos() {
		return personas.values();
	}

	@Override
	public Persona obtenerPorId(Long id) {
		return personas.get(id);
	}

	@Override
	public void insertar(Persona persona) {
		Long id = personas.size() == 0 ? 1L : personas.lastKey() + 1L;
		
		persona.setId(id);
		
		personas.put(id, persona);
	}

	@Override
	public void modificar(Persona persona) {
		personas.put(persona.getId(), persona);
	}

	@Override
	public void borrar(Long id) {
		personas.remove(id);
	}
	
}
