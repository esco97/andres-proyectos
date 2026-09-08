package escobar.andres.formacion.programas;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumeroDiagramaFlujo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Pensamos un número
		int pensado = new Random().nextInt(0, 101);

		int numero;
		// Pedimos un número al usuario

		do {
			System.out.print("Dime un número de 0 a 100: ");

			numero = Integer.parseInt(sc.nextLine());

			// Si pensado == numero
			if (pensado == numero) {
				System.out.println("Has acertado");
				
				break;
			} else {
				if (pensado > numero) {
					System.out.println("ES MAYOR");
				} else {
					System.out.println("Es menor");
				}
			}

		} while (true);
		
		sc.close();
	}
}
