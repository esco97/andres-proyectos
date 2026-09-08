package escobar.andres.formacion.ejemplos;

import java.util.ArrayList;

public class Colecciones {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("Uno");
		al.add("lasdjflaksdjf");
		al.add("Dso");
		al.add("Cuatro");
		
		System.out.println(al);
		
		al.remove(1);
		
		al.set(1, "Dos");
		
		al.add(2, "Tres");
		
//		al.set(1, null);
		
		System.out.println(al);
		
		System.out.println(al.get(3));
		
		System.out.println(al.size());
	}
}
