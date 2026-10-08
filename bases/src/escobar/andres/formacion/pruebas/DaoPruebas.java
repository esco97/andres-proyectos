package escobar.andres.formacion.pruebas;

import escobar.andres.formacion.daos.DaoPersona;
import escobar.andres.formacion.daos.DaoPersonaSqlite;

public class DaoPruebas {
	
	public static void main(String[] args) {
		DaoPersona dao = new DaoPersonaSqlite("jdbc:sqlite:bdd/tienda.db");
		
//		dao.insertar(new Persona());
//		dao.insertar(new Persona("Javier"));
		
//		for(var p: dao.obtenerTodos()) {
//			System.out.println(p);
//		}

//		dao.insertar(new Persona("Pedro"));

		for(var p: dao.obtenerTodos()) {
			System.out.println(p);
		}
		
		for(var p: dao.obtenerTodosConRol()) {
			System.out.println(p);
			System.out.println(p.getNombre() + " tiene el rol " + p.getRol().getNombre());
		}
		
		
	}
}

