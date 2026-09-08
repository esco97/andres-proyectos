package escobar.andres.formacion.ejemplos;

import java.util.Scanner;

public class IfEjemplo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("¿Sí y no? ");
		
		String respuesta = sc.nextLine();
		
		if(respuesta.equalsIgnoreCase("si")) {
			System.out.println("Perfecto");
		} else if (respuesta.equalsIgnoreCase("tal vez")) {
			System.out.println("Vaya... Yo pensaba que sí...");
		} else {
			System.out.println("¡Pues ya no t'ajunto!");
		}
		
		sc.close();
	}
}
