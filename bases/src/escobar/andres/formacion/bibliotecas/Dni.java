package escobar.andres.formacion.bibliotecas;

public class Dni {
	public static char calcularLetra(String numero) {
		numero = numero.toUpperCase();
		
		String numeroSinLetras = numero.replace('X', '0').replace('Y', '1').replace('Z', '2');
		
		int numeroEntero = Integer.parseInt(numeroSinLetras);
		
		return calcularLetra(numeroEntero);
	}
	
	public static char calcularLetra(int numero) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		int resto = numero % 23;
		
		return letras.charAt(resto);
	}
	
	public static String numeroConLetra(String numero) {
		numero = numero.toUpperCase();
		
		return numero + calcularLetra(numero);
	}
	
	public static String numeroConLetra(int numero) {
		return "" + numero + calcularLetra(numero);
	}
	
	public static boolean validar(String numeroConLetra) { // 12345678Z
		numeroConLetra = numeroConLetra.toUpperCase();
		
		char letra = numeroConLetra.charAt(8);
		
		return letra == calcularLetra(numeroConLetra.substring(0, 8));
	}
}
