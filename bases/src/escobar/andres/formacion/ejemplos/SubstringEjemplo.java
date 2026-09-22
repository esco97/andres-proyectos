package escobar.andres.formacion.ejemplos;

public class SubstringEjemplo {
	public static void main(String[] args) {
		String texto = "Mi texto maravilloso";
		
		int numeroCaracteresAQuitar = 5;

		int longitud = texto.length();
		int posicionFin = longitud - numeroCaracteresAQuitar;
		
		String cachoIzquierda = texto.substring(0, posicionFin);
		
		System.out.println(cachoIzquierda);
		
		String cachoDerecha = texto.substring(numeroCaracteresAQuitar, texto.length());
		
		System.out.println(cachoDerecha);
	}

}
