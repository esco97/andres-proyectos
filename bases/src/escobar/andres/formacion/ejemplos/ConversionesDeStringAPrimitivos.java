package escobar.andres.formacion.ejemplos;

public class ConversionesDeStringAPrimitivos {
	public static void main(String[] args) {
		String intTexto ="54";
		
		int i = Integer.parseInt(intTexto);
		
		System.out.println(i);
		
		char letraA = 'A';

		System.out.println(letraA);
		
		System.out.println((int)letraA);
		
		System.out.println((char)97);
		
		String charTexto = "     Esto es un texto";
		
		char c = charTexto.trim().charAt(0);
		
		System.out.println(c);
		
		String booleanTexto = "SI";
		
		boolean b = booleanTexto.equalsIgnoreCase("si");
		
		System.out.println(b);

	}

}
