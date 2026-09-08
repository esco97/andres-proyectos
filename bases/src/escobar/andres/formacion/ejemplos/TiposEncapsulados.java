package escobar.andres.formacion.ejemplos;

public class TiposEncapsulados {
	public static void main(String[] args) {
		int ip = 5;
		Integer ig = 5;

		System.out.println(ip * 2);
		System.out.println(ig * 2);

		ip = ig;

		ig = ip;

		Integer entero;

		entero = 6;
		
		System.out.println(entero);

		entero = null; // Ahora entero NO TIENE ningún valor

		System.out.println(entero);

		entero = 3;
		
		System.out.println(entero);
	}
}