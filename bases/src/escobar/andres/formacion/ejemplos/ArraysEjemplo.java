package escobar.andres.formacion.ejemplos;

import java.util.Arrays;

public class ArraysEjemplo {
	public static void main(String[] args) {
		var tamano = 2;
		var arr = new int[tamano]; // 2 posiciones dentro del array
		
		arr[0] = 5; // posición 0
		arr[1] = 6; // posición 1
//		arr[2] = 7; // NO HAY posición 2
			
		System.out.println(Arrays.toString(arr));
		
		System.out.println(arr[1]);
		
		System.out.println(arr.length);
		
		arr = new int[5];
		
		System.out.println(Arrays.toString(arr));
	}
}
