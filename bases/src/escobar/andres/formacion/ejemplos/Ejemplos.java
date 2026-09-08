package escobar.andres.formacion.ejemplos;

import java.util.*;

/**
 * Clase de ejemplos varios de programación básica en Java
 * @author Javier Lete
 */
public class Ejemplos {
	/**
	 * Método de arranque de la aplicación
	 * @param args argumentos de arranque de la aplicación
	 */
	public static void main(String[] args) {
		/*
		 * Código de ejemplo en el que veremos varias cosas como:
		 * - tipos
		 * - declaración de variables...
		 */
		System.out.println("Hola"); // Esto muestra "Hola" en la consola
		
		double a = 0.1;
		double b = 0.2;
		
		double total = a + b;
		
		System.out.println(total);
		
		long l = 9123456123456123456L;
		
		System.out.println(l);
		
		int i = 5;
		
		System.out.println((int)a + i);
	
		System.out.println(i + l);
		
		i = (int) total;
		
		String nombreCompleto = "Javier Lete";
		
		System.out.println("Hola " + nombreCompleto);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime tu nombre: ");
		
		nombreCompleto = sc.nextLine(); // System.console().readLine();
		
		nombreCompleto = nombreCompleto.trim(); // Quitamos los espacios de los extremos
		
		System.out.println("Ahora eres " + nombreCompleto);
		
		System.out.println(nombreCompleto.toUpperCase());
		
		System.out.println("El valor de i es " + i);
		
		int i1 = 5;
		int i2 = 5;
		
		System.out.println(i1 == i2);
		
		String s1 = new String("Texto");
		String s2 = new String("Texto");
		
		System.out.println(s1 == s2); // Son el MISMO OBJETO, REFERENCIA, PUNTERO, ZONA DE MEMORIA
		System.out.println(s1.equals(s2)); // MISMO CONTENIDO, "GEMELOS"
		
		sc.close();
	}
}