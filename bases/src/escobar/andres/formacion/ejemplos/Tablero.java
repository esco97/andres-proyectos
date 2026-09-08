package escobar.andres.formacion.ejemplos;

import java.util.Arrays;

public class Tablero {
	public static void main(String[] args) {
		// Primero filas y luego columnas
		char[][] tablero = new char[8][9];

		tablero[0][0] = 'T';
		tablero[1][0] = 'P';
		tablero[6][7] = 'p';
		tablero[7][7] = 't';

		System.out.println(Arrays.toString(tablero[0]));
		System.out.println(Arrays.toString(tablero[1]));
		System.out.println(Arrays.toString(tablero[2]));
		System.out.println(Arrays.toString(tablero[3]));
		System.out.println(Arrays.toString(tablero[4]));
		System.out.println(Arrays.toString(tablero[5]));
		System.out.println(Arrays.toString(tablero[6]));
		System.out.println(Arrays.toString(tablero[7]));

		System.out.println(tablero.length);
		System.out.println(tablero[0].length);
		
		// Primero filas y luego columnas
		String[][] tablero2 = new String[8][8];

		tablero2[0] = new String[] { "T", " ", " ", " ", " ", " ", " ", " " };
		tablero2[7] = new String[] { " ", " ", " ", " ", " ", " ", " ", "t" };

		System.out.println(Arrays.toString(tablero2[0]));
		System.out.println(Arrays.toString(tablero2[1]));
		System.out.println(Arrays.toString(tablero2[2]));
		System.out.println(Arrays.toString(tablero2[3]));
		System.out.println(Arrays.toString(tablero2[4]));
		System.out.println(Arrays.toString(tablero2[5]));
		System.out.println(Arrays.toString(tablero2[6]));
		System.out.println(Arrays.toString(tablero2[7]));
	}

}
