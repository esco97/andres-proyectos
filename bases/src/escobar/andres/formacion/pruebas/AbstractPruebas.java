package escobar.andres.formacion.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import escobar.andres.formacion.pojos.Local;
import escobar.andres.formacion.pojos.Trabajador;
import escobar.andres.formacion.pojos.TrabajadorIndefinido;
import escobar.andres.formacion.pojos.TrabajadorPorHoras;

public class AbstractPruebas {
	public static void main(String[] args) {
		var responsable = new TrabajadorIndefinido("Javier", "Lete", LocalDate.of(2000, 1, 2), "12345678Z",
				"1234-1234-1234-1234", new BigDecimal("23456"), 14);

		var local = new Local("Ejemplo clases abstractas", responsable);

		local.entrar(responsable);
		local.entrar(new TrabajadorIndefinido("Juan", "Ricoz", LocalDate.of(2000, 1, 2), "12345678Z",
				"1234-1234-1234-1234", new BigDecimal("234566"), 12));
		local.entrar(new TrabajadorPorHoras("Pepe", "Pérez", LocalDate.of(2000, 1, 2), "12345678Z",
				"1234-1234-1234-1234", new BigDecimal("23"), 100));

		BigDecimal total = BigDecimal.ZERO;

		for (var visitante : local.getVisitantes()) {
			System.out.println(visitante);
			
			if (visitante instanceof Trabajador trabajador) {
				System.out.println(trabajador.getSueldoMensual());
				
				total = total.add(trabajador.getSueldoMensual());
			}
		}
		
		System.out.println("TOTAL");
		System.out.println(total);
		
		Calendar cal = new GregorianCalendar();
		
		System.out.println(cal);
		
		Number n = new BigDecimal("12345.67");
		
		System.out.println(n);
	}

}
