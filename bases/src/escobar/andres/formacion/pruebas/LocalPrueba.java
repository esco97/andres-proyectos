package escobar.andres.formacion.pruebas;

import java.time.LocalDate;

import escobar.andres.formacion.pojos.Local;
import escobar.andres.formacion.pojos.Persona;

public class LocalPrueba {
	public static void main(String[] args) {
		var responsable = new Persona("Javier", LocalDate.of(2000, 6, 12));
		
		Local local = new Local("Ipartek", responsable);
		
		local.entrar(responsable);
		local.entrar(new Persona("Pepe", LocalDate.of(1995, 2, 3)));
		local.entrar(new Persona("Juan", LocalDate.of(2000, 2, 1)));
		local.entrar(responsable);
//		local.entrar(null);
//		local.entrar(new Persona("Otro", null));
		
		System.out.println(local);
		
		System.out.println(local.getVisitantes().size());
		
		System.out.println(local.getVisitantes());
		
		for(var visitante: local.getVisitantes()) {
			System.out.println(visitante.getNombre());
		}
		
		Local local2 = new Local("Bilbao", responsable);
		
		local2.entrar(new Persona("Pepe", LocalDate.of(1995, 2, 3)));
		local2.entrar(new Persona("Juan", LocalDate.of(2000, 2, 1)));
		local2.entrar(responsable);
		
		System.out.println(Local.compararVisitantes(local, local2));
		System.out.println(local.compararVisitantes(local2));
	}
}
