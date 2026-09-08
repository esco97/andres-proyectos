package escobar.andres.formacion.programas;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumeroFuncional {
	// Ámbito de clase a nivel estático
	private static Scanner sc = new Scanner(System.in);
	private static int pensado;

	public static void main(String[] args) {
		pensado = pensarNumero();

		boolean acertado;

		do {
			int numero = pedirNumero();
			acertado = procesarResultado(numero);
		} while (!acertado);
	}

	private static int pensarNumero() {
		return new Random().nextInt(0, 101);
	}

	private static int pedirNumero() {
		System.out.print("Dime un número del 0 al 100: ");

		String texto = sc.nextLine();

		return Integer.parseInt(texto);
	}

	private static boolean procesarResultado(int numero) {
		if (pensado > numero) {
			System.out.println("ES MAYOR");
			return false;
		}

		if (pensado < numero) {
			System.out.println("Es menor");
			return false;
		}

		System.out.println("Has acertado");
		return true;
	}

//	private static boolean procesarResultado(int numero) {
//		if (pensado > numero) {
//			System.out.println("ES MAYOR");
//		} else if (pensado < numero) {
//			System.out.println("Es menor");
//		} else {
//			System.out.println("Has acertado");
//		}
//		
//		return pensado == numero;
//	}

}
