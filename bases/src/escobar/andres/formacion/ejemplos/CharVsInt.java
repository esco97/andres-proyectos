package escobar.andres.formacion.ejemplos;

public class CharVsInt {
	public static void main(String[] args) {
		String texto = "2002";
		
		int total = 0;
		
		for(int i = 0; i < texto.length(); i++) {
			total += texto.charAt(i) - '0';
		}
		
		System.out.println(total);
		
		total = 0;
		
		for(char c: texto.toCharArray()) { // [ '2', '0', '0', '2']
			total += c - '0';
		}
		
		System.out.println(total);
	}
}
