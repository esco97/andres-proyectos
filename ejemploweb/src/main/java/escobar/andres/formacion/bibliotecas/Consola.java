package escobar.andres.formacion.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Function;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);

	public static String leerString(String mensaje) {
		System.out.print(mensaje + ": ");

		var texto = SC.nextLine();
		
		return texto.isBlank() ? null: texto;
	}

	public static void cerrarConsola() {
		SC.close();
	}

//	private interface Convertible<T> {
//		T convertir(String texto);
//	}

	public static <T extends Comparable<T>> T leerGenerico(String mensaje, T minimo, T maximo,
//			Convertible<T> conversor) {
			Function<String, T> conversor) {
		boolean correcto = false;
		T valor = null;

		do {
			try {
//				valor = conversor.convertir(leerString(mensaje));
				String texto = leerString(mensaje);
				
				if(texto == null) {
					return null;
				}
				
				valor = conversor.apply(texto);

				if (valor.compareTo(minimo) >= 0 && valor.compareTo(maximo) <= 0) {
					correcto = true;
				} else {
					System.out.println("El valor debe estar entre " + minimo + " y " + maximo);
				}
			} catch (Exception e) {
				System.out.println("El formato no es correcto");
				System.out.println(e.getMessage());
			}
		} while (!correcto);

		return valor;
	}

//	private static class ConvertirAEntero implements Convertible<Integer> {
//
//		@Override
//		public Integer convertir(String texto) {
//			return Integer.parseInt(texto);
//		}
//
//	}

//	private static class ConvertirADouble implements Convertible<Double> {
//		
//		@Override
//		public Double convertir(String texto) {
//			return Double.parseDouble(texto);
//		}
//		
//	}

//	public static Integer leerInteger(String mensaje, Integer minimo, Integer maximo) {
//		Convertible<Integer> conversor = new ConvertirAEntero();
//		
//		return leerGenerico(mensaje, minimo, maximo, conversor);
//	}
//
//	public static Double leerDouble(String mensaje, Double minimo, Double maximo) {
//		
//		return leerGenerico(mensaje, minimo, maximo, new Convertible<Double>() {
//			@Override
//			public Double convertir(String texto) {
//				return Double.parseDouble(texto);
//			}
//		});
//	}

	public static Integer leerInteger(String mensaje) {
		return leerInteger(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static Integer leerInteger(String mensaje, Integer minimo) {
		return leerInteger(mensaje, minimo, Integer.MAX_VALUE);
	}

	public static Integer leerInteger(String mensaje, Integer minimo, Integer maximo) {
		return leerGenerico(mensaje, minimo, maximo, texto -> Integer.parseInt(texto));
	}

	public static Double leerDouble(String mensaje) {
		return leerDouble(mensaje, Double.MIN_NORMAL, Double.MAX_VALUE);
	}

	public static Double leerDouble(String mensaje, Double minimo) {
		return leerDouble(mensaje, minimo, Double.MAX_VALUE);
	}

	public static Double leerDouble(String mensaje, Double minimo, Double maximo) {
		return leerGenerico(mensaje, minimo, maximo, texto -> Double.parseDouble(texto));
	}

	public static BigDecimal leerBigDecimal(String mensaje, BigDecimal minimo, BigDecimal maximo) {
		return leerGenerico(mensaje, minimo, maximo, texto -> new BigDecimal(texto));
	}

	public static LocalDate leerLocalDate() {
		return leerLocalDate("Introduce una fecha (formato: AAAA-MM-DD)");
	}

	public static LocalDate leerLocalDate(String mensaje) {
		return leerLocalDate(mensaje, LocalDate.MIN, LocalDate.MAX);
	}

	public static LocalDate leerLocalDate(String mensaje, LocalDate minimo, LocalDate maximo) {
		return (LocalDate) leerGenerico(mensaje, minimo, maximo, texto -> {
			System.out.println("Conversión de fecha");
			return LocalDate.parse(texto);
		});
	}
}
