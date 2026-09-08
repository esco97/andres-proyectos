package escobar.andres.formacion.ejemplos;

import java.util.Scanner;

public class SwitchEjemplo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime la opción: ");
		
		int opcion = Integer.parseInt(sc.nextLine());
		
		switch(opcion) {
		case 1:
			System.out.println("Opción 1");
			break;
		case 2:
			System.out.println("Opción 2");
			break;
		default:
			System.out.println("No conozco la opción");
		}
		
		if(opcion == 1) {
			System.out.println("Opción 1");
		} else if(opcion == 2) {
			System.out.println("Opción 2");
		} else {
			System.out.println("No conozco esa opción");
		}
		
		sc.close();
	}
}
