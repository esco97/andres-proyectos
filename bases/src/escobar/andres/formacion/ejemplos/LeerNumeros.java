package escobar.andres.formacion.ejemplos;

import java.util.Scanner;

public class LeerNumeros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime un número y te lo multiplico por 2: ");
		
		int numero = sc.nextInt();
		
		System.out.println(numero * 2);
		
		sc.close();
	}
}
