package escobar.andres.formacion.pruebas;

import java.util.Scanner;

import escobar.andres.formacion.bibliotecas.Dni;

public class DniPrueba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime un número de DNI: ");
		
		String dni = sc.nextLine();
		
		System.out.println(Dni.numeroConLetra(dni));
		
		System.out.print("Dame un DNI con letra: ");
		
		String dniConLetra = sc.nextLine();
		
		if(Dni.validar(dniConLetra)) {
			System.out.println("DNI correcto");
		} else {
			System.out.println("DNI incorrecto");
		}
		
		sc.close();
	}
}