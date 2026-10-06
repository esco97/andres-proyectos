package escobar.andres.formacion.ejemplos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ficheros {
	private static final boolean APPEND = true;
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("fichero.txt", APPEND);
		PrintWriter pw = new PrintWriter(fw, AUTO_FLUSH);
		
		pw.println(LocalDateTime.now());
		pw.println("Hola desde el fichero");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader("fichero.txt");
		Scanner sc = new Scanner(fr);
		
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
		fr.close();
	}
}
