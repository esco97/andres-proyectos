package escobar.andres.formacion.pruebas;

import java.time.LocalDate;
import java.util.ArrayList;

import escobar.andres.formacion.pojos.Persona;

public class PersonaPrueba {
	public static void main(String[] args) {
		Persona p;

		p = new Persona();

		p.setNombre("Javier");
		p.setFechaNacimiento(LocalDate.of(2000, 1, 2));

		var p2 = new Persona();

		p2.setNombre("Pepe");
		p2.setFechaNacimiento(LocalDate.of(1990, 2, 3));

		System.out.println(p);

		System.out.println(p.getNombre());
		System.out.println(p.getFechaNacimiento());

		System.out.println(p2.getNombre());
		System.out.println(p2.getFechaNacimiento());

		var personas = new ArrayList<Persona>();

		personas.add(p);
		personas.add(p2);
		personas.add(new Persona("Juan", LocalDate.of(1995, 3, 4)));

		for (var persona : personas) {
			System.out.println(persona.getNombre());
		}
		
		Persona p3 = new Persona(p2);
//		Persona p3 = new Persona(p2.getNombre(), p2.getFechaNacimiento());
		
		System.out.println(p3.equals(p2));
		
		p3.setNombre("CAMBIADO");
		
		System.out.println(p3.equals(p2));
		
		System.out.println(p2.getNombre());
		System.out.println(p3.getNombre());
	}
}
