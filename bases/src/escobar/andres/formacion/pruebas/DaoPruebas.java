package escobar.andres.formacion.pruebas;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.daos.DaoPersonaFichero;
import escobar.andres.formacion.daos.DaoPersonaTreeMap;
import escobar.andres.formacion.pojos.Persona;

public class DaoPruebas {
	
	public static void main(String[] args) {
		Dao<Persona> dao = new DaoPersonaFichero("fichero.dat");
		
		dao.insertar(new Persona());
		dao.insertar(new Persona("javier"));
		
		for(var p: dao.obtenerTodos()) {
			System.out.println(p);
		} 
		

		Dao<Persona> dao2 = new DaoPersonaTreeMap();
		
		dao2.insertar(new Persona());
		dao2.insertar(new Persona("javier"));
		
		for(var p: dao2.obtenerTodos()) {
			System.out.println(p);
		} 
	}
}
