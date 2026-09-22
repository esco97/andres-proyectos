package escobar.andres.formacion.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import escobar.andres.formacion.pojos.Local;
import escobar.andres.formacion.pojos.Trabajador;
import escobar.andres.formacion.pojos.TrabajadorIndefinido;

public class TrabajadorPrueba {
	public static void main(String[] args) {
		Trabajador trabajador = new TrabajadorIndefinido("Javier", "Lete", LocalDate.of(2000, 1, 2), "12345678Z", "1234-1234-1234-1234", new BigDecimal("12345"), 14);
		
		System.out.println(trabajador);
		
		Local local = new Local("Curso", trabajador);
		
		System.out.println(local);
		
		local.entrar(trabajador);
		
		System.out.println(local.getVisitantes());
		
	}
}
