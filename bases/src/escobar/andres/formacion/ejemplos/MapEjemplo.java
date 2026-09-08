package escobar.andres.formacion.ejemplos;

import java.util.HashMap;

public class MapEjemplo {
	public static void main(String[] args) {
		var diccionario = new HashMap<String, String>();
		
		diccionario.put("hola", "hello");
		diccionario.put("perro", "dog");
		
		System.out.println(diccionario);
		System.out.println(diccionario.get("perro"));
		
		var numeros = new HashMap<String, Integer>();
		
		numeros.put("uno", 1);
		numeros.put("dos", 2);
		
		System.out.println(numeros);
		System.out.println(numeros.get("dos"));
		
		String[] inverso = {"cero", "uno", "dos" };
		
		System.out.println(inverso[1]);
		
		var numerosInverso = new HashMap<Integer, String>();
		
		numerosInverso.put(3, "tres");
		numerosInverso.put(5, "cinco");
		
		System.out.println(numerosInverso.get(3));
	}
}
