package escobar.andres.formacion.daos;

import java.util.ArrayList;
import java.util.List;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.pojos.Persona;

public class DaoPersonaListConLambdas implements Dao<Persona>{

	private final static List<Persona> personas = new ArrayList<>();
	
	@Override
	public Iterable<Persona> obtenerTodos() {
		return personas;
	}

	@Override
	public Persona obtenerPorId(Long id) {
		return personas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	@Override
	public void insertar(Persona persona) {
		Long idNuevo = personas.stream().map(p -> p.getId()).reduce(0L, 
				(resultado, id) -> (resultado < id) ? id : resultado) + 1;
		
		// map
//		List<Long> ids = new ArrayList<>();
		
//		for(var p: personas) {
//			ids.add(p.getId()); // p -> p.getId()
//		}	
		
		// reduce
//		Long idn = 0L; // 0L
		
//		for(var id: ids) {
//			if(idn < id) { // (resultado < id)
//				idn = id; // ? id
//			} else {
//				idn = idn; // : resultado
//			}
//		}
		
//		idn++; // + 1
			
		persona.setId(idNuevo);
		
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
		var persona = personas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
		
		personas.remove(persona);
	}

}
