package escobar.andres.formacion.bibliotecas;

import java.math.BigInteger;

public class Matematica {
	// 4! = 1 * 2 * 3 * 4
	public static long factorial(long numero) {
		long total = 1;
		
		for(long contador = 1; contador <= numero; contador ++) {
			total *= contador;
		}
		
		return total;
	}
	
	public static BigInteger factorial(BigInteger numero) {
		BigInteger total = BigInteger.ONE;
		
		for(BigInteger contador = BigInteger.ONE; contador.compareTo(numero) <= 0; contador = contador.add(BigInteger.ONE)) {
			total = total.multiply(contador);
		}
		
		return total;
	}
}
