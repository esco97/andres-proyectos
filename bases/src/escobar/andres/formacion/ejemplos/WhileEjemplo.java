package escobar.andres.formacion.ejemplos;

public class WhileEjemplo {
	public static void main(String[] args) {
		int contador = 1;
		
		while (contador <= 10) {
			System.out.println(contador);
			contador++;
		}
		
		contador = 1;
		
		do {
			System.out.println(contador);
			contador++;
		} while (contador <=10);
	}
}
