package escobar.andres.formacion.ejemplos;

public class OperadorTresPuntos {
	public static void main(String[] args) {
		System.out.println(suma(1, 2, 3, 4, 3, 4, 6, 7, 4, 4, 2, 3, 4));
	
		int[] datos = {1, 2, 34, 3, 5, 6, 7};
		
		System.out.println(suma(datos));
	}
	
	private static int suma(int... valores) {
		int total = 0;
		
		for(var valor: valores) {
			total += valor;
		}
		
		return total;
	}
}
