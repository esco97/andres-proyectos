package escobar.andres.formacion.daos;

import java.util.ArrayList;
import java.util.List;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.pojos.Persona;

public class DaoPersonaList implements Dao<Persona>{

	private final static List<Persona> personas = new ArrayList<>();
	
	@Override
	public Iterable<Persona> obtenerTodos() {
		return personas;
	}

	@Override
	public Persona obtenerPorId(Long id) {
		for(var p: personas) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(Persona persona) {
		Long id = 0L;
		
		for(var p: personas) {
			if(p.getId() > id) {
				id = p.getId();
			}
		}
		
		persona.setId(++id);
		
		personas.add(persona);
	}

	@Override
	public void modificar(Persona persona) {
		for(int i = 0; i < personas.size(); i++) {
			var p = personas.get(i);
			
			if(p.getId() == persona.getId()) {
				personas.set(i, persona);
			}
		}
	}

	@Override
	public void borrar(Long id) {
		personas.remove(obtenerPorId(id));
	}

}
