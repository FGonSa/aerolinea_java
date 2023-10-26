package aerolinea;

import java.util.InputMismatchException;
import java.util.Scanner;

import objetos.Trabajador;
import objetos.Vuelo;

public class Main {

	final static int MIN_OPTION_MAIN_MENU = 0;
	final static int MAX_OPTION_MAIN_MENU = 2;

	final static int MIN_OPTION_ADMIN_MENU = 0;
	final static int MAX_OPTION_ADMIN_MENU = 3;

	final static String ADMIN_USER = "123";
	final static String ADMIN_PASS = "123";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuOption = -1;
		int menuAdminOption = -1;
		boolean accesoMenuAdmin = false;
		Vuelo objeto_vuelo = null;

		// INICIO APP
		// Creamos el vuelo
		objeto_vuelo = initVuelo();

		// Lanzamos Menú Principal
		do {
			initMenu();
			menuOption = selectOption();

			if (menuOption == 1) {
				accesoMenuAdmin = loginAdmin();
				if (accesoMenuAdmin == true) {

					do {
						initMenuAdmin();
						menuAdminOption = selectOption(MAX_OPTION_ADMIN_MENU);

						if (menuAdminOption == 1) {
							System.out.println(objeto_vuelo.toString());
							;
						}
					} while (menuAdminOption != 0);

				}
			}

		} while (menuOption != 0);
		System.out.println("Aplicación cerrada.");
	}

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

			if (option > MAX_OPTION || option < MIN_OPTION_MAIN_MENU) {
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

			if (option > MAX_OPTION_MAIN_MENU || option < MIN_OPTION_MAIN_MENU) {
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

		if ((username.equals(ADMIN_USER)) && (password.equals(ADMIN_PASS))) {
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
			System.out.println("i es uno.");
			break;
		case 2:
			System.out.println("i es dos.");
			break;
		case 3:
			System.out.println("i es tres.");
			break;
		}

		return null;

	}

} // Final Main