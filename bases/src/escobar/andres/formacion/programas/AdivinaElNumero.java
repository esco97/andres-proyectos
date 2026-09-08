package escobar.andres.formacion.programas;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Pensamos un número
		int numeroAdivinar = new Random().nextInt(0, 101);

		int numero;
		
		do {
			// Le decimos al usuario que nos de un número
			System.out.print("Dime un número del 0 al 100: ");
			// Escuchamos la respuesta
			numero = sc.nextInt();
			// Si el número es igual que el que hemos pensado...
			if (numero == numeroAdivinar) {
				// ...mostrar felicitaciones
				System.out.println("¡Felicidades! ¡¡Has acertado!!");
				// Si el número es mayor...
			} else if (numeroAdivinar > numero) {
				// ...decir que es mayor
				System.out.println("ES MAYOR");
				// Si no...
			} else {
				// ...decir que es menor
				System.out.println("Es menor");
			} 
			// Repetir mientras el número no sea igual al pensado
		} while (numero != numeroAdivinar);
		
		sc.close();
	}
}
