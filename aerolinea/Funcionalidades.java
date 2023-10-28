package aerolinea;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import objetos.Asistente;
import objetos.Copiloto;
import objetos.Piloto;
import objetos.Trabajador;
import objetos.Vuelo;

public class Funcionalidades {
	public static void initMenu() {

		System.out.println("==============");
		System.out.println("MENÚ PRINCIPAL");
		System.out.println("==============");
		System.out.println("1. Acceder como ADMINISTRADOR");
		System.out.println("2. Acceder como CLIENTE");
		System.out.println("0. Salir");
	}

	public static void initMenuAdmin() {

		System.out.println("==============");
		System.out.println("MENÚ ADMINISTRACIÓN");
		System.out.println("==============");
		System.out.println("1. Ver Datos del Vuelo");
		System.out.println("2. Alta de Trabajador");
		System.out.println("3. Ver Datos Trabajadores");
		System.out.println("0. Salir al Menú Principal");
	}

	public static int selectOption(int MAX_OPTION) {
		int option = -1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escoja una opción:");

		try {
			option = scanner.nextInt();

			if (option > MAX_OPTION || option < Constantes.MIN_OPTION_MAIN_MENU) {
				System.out.println("Debes escoger una opción válida.");
			}
		} catch (InputMismatchException ime) {
			System.out.println("ERROR: Debes introducir un número.");
		}

		return option;
	}

	public static int selectOption() {
		int option = -1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escoja una opción:");

		try {
			option = scanner.nextInt();

			if (option > Constantes.MAX_OPTION_MAIN_MENU || option < Constantes.MIN_OPTION_MAIN_MENU) {
				System.out.println("Debes escoger una opción válida.");
			}
		} catch (InputMismatchException ime) {
			System.out.println("ERROR: Debes introducir un número.");
		}

		return option;
	}

	public static boolean loginAdmin() {
		Scanner scanner = new Scanner(System.in);
		String username = "";
		String password = "";
		boolean acceso = false;

		System.out.println("Introduzca nombre de usuario: ");
		username = scanner.nextLine();
		System.out.println("Introduzca password: ");
		password = scanner.nextLine();

		if ((username.equals(Constantes.ADMIN_USER)) && (password.equals(Constantes.ADMIN_PASS))) {
			acceso = true;
			System.out.println("Login correcto.");
		} else {
			acceso = false;
			System.out.println("Login incorrecto. Regreso al Menú Principal.");
		}
		return acceso;

	}

	public static Vuelo initVuelo() {

		Vuelo objeto_vuelo = null;

		Scanner scanner = new Scanner(System.in);
		String nombreVuelo;
		String origen;
		String destino;
		int duracion = 0;
		int cantidadPlazas = 0;
		double precioPlaza = 0;
		boolean allCorrect = false;

		System.out.println("Introduzca origen del vuelo: ");
		origen = scanner.nextLine();
		System.out.println("Introduzca destino del vuelo: ");
		destino = scanner.nextLine();
		System.out.println("Introduzca nombre del vuelo: ");
		nombreVuelo = scanner.nextLine();

		do {
			try {
				System.out.println("Introduzca duración en minutos del vuelo: ");
				duracion = scanner.nextInt();
				if (duracion <= 0) {
					System.out.println("Debes introducir una duración correcta.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("ERROR: Debes introducir un número.");
				scanner.next(); // Limpia el búfer de entrada
			}
		} while (duracion <= 0);

		do {
			try {
				System.out.println("Introduzca el nº de plazas: ");
				cantidadPlazas = scanner.nextInt();
				if (cantidadPlazas <= 0) {
					System.out.println("Debes introducir una cantidad correcta.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("ERROR: Debes introducir un número.");
				scanner.next(); // Limpia el búfer de entrada
			}
		} while (cantidadPlazas <= 0);

		do {
			try {
				System.out.println("Introduzca el precio de cada plaza: ");
				precioPlaza = scanner.nextDouble();
				if (precioPlaza <= 0) {
					System.out.println("Debes introducir un precio correcto.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("ERROR: Debes introducir un número.");
				scanner.next(); // Limpia el búfer de entrada
			}

		} while (precioPlaza <= 0);

		return objeto_vuelo = new Vuelo(nombreVuelo, origen, destino, duracion, cantidadPlazas, 0, precioPlaza, null);

	}

	public static Trabajador crearTrabajador() {

		// Variables
		Trabajador objeto_trabajador = null;
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		// Lógica
		do {
			System.out.println("Selecciona qué tipo de trabajador quieres crear: ");
			System.out.println("1) PILOTO || 2) COPILOTO || 3) ASISTENTE");

			try {
				opcion = scanner.nextInt();
				if (opcion <= 0 || opcion > 3) {
					System.out.println("Debes introducir una opción correcta.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("ERROR: Debes introducir un número.");
				scanner.next(); // Limpia el búfer de entrada
			}
		} while (opcion <= 0 || opcion > 3);

		// SWITCH PARA CREAR TRABAJADOR
		switch (opcion) {
		case 1:
			objeto_trabajador = crearPiloto();
			break;
		case 2:
			objeto_trabajador = crearCopiloto();
			break;
		case 3:
			objeto_trabajador = crearAsistente();
			break;
		}

		return objeto_trabajador;

	}

	public static Piloto crearPiloto() {

		Piloto obj_piloto = null;
		// nom, cognoms, dni, telèfon, referència i data de naixement.
		String nombre;
		String apellidos;
		String dni;
		String telefono;
		String referencia;
		LocalDate fecha;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce nombre: ");
		nombre = scanner.nextLine();
		System.out.println("Introduce apellidos: ");
		apellidos = scanner.nextLine();
		System.out.println("Introduce DNI: ");
		dni = scanner.nextLine();
		System.out.println("Introduce teléfono: ");
		telefono = scanner.nextLine();
		System.out.println("Introduce referencia: ");
		referencia = scanner.nextLine();

		// Lo suyo sería introducir la fecha manualmente
		// Pero por ahora lo dejo así
		fecha = LocalDate.now();
		System.out.println("La fecha de creación es: " + fecha);

		System.out.println("Piloto creado con éxito.");

		return obj_piloto = new Piloto(nombre, apellidos, dni, telefono, referencia, fecha);
	}

	public static int encontrarPosicionVacia(Trabajador[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) { // Aquí asumimos que null indica una posición vacía, ajusta según tus
									// necesidades
				return i;
			}
		}
		return -1; // Devuelve -1 si no se encuentra ninguna posición vacía
	}

	public static void datosTrabajadores(Trabajador[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				System.out.println(array[i].toString());
			}

		}
	}

	public static Copiloto crearCopiloto() {

		Copiloto obj_copiloto = null;

		String nombre;
		String apellidos;
		String dni;
		boolean master = false;
		int opcion = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce nombre: ");
		nombre = scanner.nextLine();
		System.out.println("Introduce apellidos: ");
		apellidos = scanner.nextLine();
		System.out.println("Introduce DNI: ");
		dni = scanner.nextLine();

		do {
			System.out.println("Tiene el máster de aviación?");
			System.out.println("1) SÍ || 2) NO");
			try {
				opcion = scanner.nextInt();
				if (opcion <= 0 || opcion > 2) {
					System.out.println("Debes introducir una opción correcta.");
				}

			} catch (InputMismatchException ime) {
				System.out.println("ERROR: Debes introducir un número.");
				scanner.next(); // Limpia el búfer de entrada
			}
		} while (opcion <= 0 || opcion > 2);

		if (opcion == 1) {
			master = true;
		}

		System.out.println("Copiloto creado con éxito.");

		return obj_copiloto = new Copiloto(nombre, apellidos, dni, master);
	}

	public static Asistente crearAsistente() {

		Asistente obj_asistente = null;

		String nombre;
		String apellidos;
		String dni;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce nombre: ");
		nombre = scanner.nextLine();
		System.out.println("Introduce apellidos: ");
		apellidos = scanner.nextLine();
		System.out.println("Introduce DNI: ");
		dni = scanner.nextLine();

		System.out.println("Asistente creado con éxito.");

		return obj_asistente = new Asistente(nombre, apellidos, dni);
	}
}
