package escobar.andres.formacion.ejemplos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class Fechas {

	public static void main(String[] args) {
		LocalDateTime ahora = LocalDateTime.now();
		
		System.out.println(ahora);
		
		ahora = LocalDateTime.now();
		
		System.out.println(ahora);
		
		LocalDateTime fechaInicial = LocalDateTime.of(2025, 1, 31, 15, 00);
		
		System.out.println(fechaInicial);
		
		LocalDateTime mesQueViene = fechaInicial.plusMonths(1);
		
		System.out.println(mesQueViene);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println(ahora.format(dtf));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime la fecha y hora (AAAA-MM-DDTHH:MM): ");
		
		String texto = sc.nextLine();
		
		LocalDateTime fechaHora = LocalDateTime.parse(texto);
		
		System.out.println(fechaHora.format(dtf));
		
		System.out.print("Dime la fecha y hora (DD/MM/AAAA HH:MM): ");
		
		texto = sc.nextLine();
		
		fechaHora = LocalDateTime.parse(texto, dtf);
		
		System.out.println(fechaHora);
		
		System.out.println(fechaHora.get(ChronoField.DAY_OF_MONTH));
		System.out.println(fechaHora.getDayOfMonth());
		
		sc.close();

	}

}
