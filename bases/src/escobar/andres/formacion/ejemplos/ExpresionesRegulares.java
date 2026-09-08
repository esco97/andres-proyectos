package escobar.andres.formacion.ejemplos;

public class ExpresionesRegulares {
	public static void main(String[] args) {
		String texto = "A2345678Z";
		
		// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html#sum
		if(texto.matches("^[XYZ\\d]\\d{7}[A-Z]$")) {
			System.out.println("Concuerda");
		} else {
			System.out.println("No concuerda");
		}
	}
}
