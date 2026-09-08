package escobar.andres.formacion.pruebas;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

import escobar.andres.formacion.bibliotecas.Matematica;

public class MatematicaPrueba {
	public static void main(String[] args) {
		System.out.println(Math.pow(2, 3));
		
		// Usar NumberFormat con el formato de España
        NumberFormat formatter = NumberFormat.getInstance(Locale.of("es", "ES"));
		
		System.out.println(formatter.format(Matematica.factorial(20)));
		System.out.println(Matematica.factorial(21));

		BigInteger factorialDe100000 = Matematica.factorial(new BigInteger("100000"));
		
		System.out.println(formatter.format(factorialDe100000));
		System.out.println(factorialDe100000.toString().length());
	}
}

