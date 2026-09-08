package escobar.andres.formacion.ejemplos;

import java.util.Scanner;

public class LeerCombinadoChapuza {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Dime un número y te lo multiplico por 2: ");

		int numero = sc.nextInt();
		sc.nextLine();
		
		System.out.println(numero * 2);
		
		System.out.print("Dime tu nombre: ");

		String nombre = sc.nextLine();

		System.out.println("Hola " + nombre);

		sc.close();
	}
}
