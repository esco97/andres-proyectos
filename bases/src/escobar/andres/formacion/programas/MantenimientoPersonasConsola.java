package escobar.andres.formacion.programas;

import static escobar.andres.formacion.bibliotecas.Consola.*;

import escobar.andres.formacion.bibliotecas.Dao;
import escobar.andres.formacion.daos.DaoPersona;
import escobar.andres.formacion.daos.DaoPersonaSqlite;
import escobar.andres.formacion.pojos.Persona;

public class MantenimientoPersonasConsola {
	private static final DaoPersona DAO = new DaoPersonaSqlite("jdbc:sqlite:bdd/tienda.db");
	
	private static final boolean CON_ID = true;
	private static final boolean SIN_ID = false;

	public static void main(String[] args) {

		int opcion;

		do {
			menu();
			opcion = leerInteger("Dime una opción");
			procesar(opcion);
		} while (opcion != 0);
	}

	private static void menu() {
		System.out.println("""
				1. Listado
				2. Buscar id

				3. Añadir
				4. Modificar
				5. Borrar

				0. Salir
				""");

	}

	private static void procesar(int opcion) {
		switch (opcion) {
		case 1 -> listado();
		case 2 ->  buscar();
		case 3 -> anyadir();
		case 4 -> modificar();
		case 5 -> borrar();
		case 0 -> System.out.println("Gracias por usar esta aplicación");
		default -> System.out.println("Opción incorrecta");
		}
	}

	private static void listado() {
		for (var persona : DAO.obtenerTodos()) {
			mostrarFilaPersona(persona);
		}
	}
	
	private static void buscar() {
		var id = leerInteger("Dime el id a buscar");

		var persona = DAO.obtenerPorId((long) id);

		mostrarFichaPersona(persona);
	}

	private static void anyadir() {
		var persona = pedirDatosPersona(SIN_ID);

		DAO.insertar(persona);
	}

	private static void modificar() {
		var persona = pedirDatosPersona();

		DAO.modificar(persona);
	}

	private static void borrar() {
		var id = leerInteger("Dime el id a borrar");

		DAO.borrar((long) id);
	}

	private static void mostrarFilaPersona(Persona persona) {
		System.out.println(persona);
	}

	private static void mostrarFichaPersona(Persona persona) {
		System.out.println(persona);
	}

	private static Persona pedirDatosPersona() {
		return pedirDatosPersona(CON_ID);
	}

	private static Persona pedirDatosPersona(boolean conId) {
		do {
			try {
				Long id = null;

				if (conId) {
					id = (long) leerInteger("Id");
				}

				var nombre = leerString("Nombre");
				var fechaNacimiento = leerLocalDate("Fecha de nacimiento");

				var persona = new Persona(id, nombre, fechaNacimiento);

				return persona;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
	}
}
