package aerolinea;

import objetos.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuOption = -1;
		int menuAdminOption = -1;
		int menuClientOption = -1;
		boolean accesoMenuAdmin = false;
		boolean accesoMenuClient = false;
		Vuelo objeto_vuelo = null;
		Trabajador trabajadores[] = new Trabajador[Constantes.TRABAJADORES_LENGTH];
		Trabajador trabajadorCreado = null;
		boolean arrayTrabajadoresLleno = false;
		boolean minimoUnTrabajador = false;
		int posicionArrayTrabajadores = -1;
		int contadorPosicionesVacias = 0;
		boolean vueloOptimo = false;

		// INICIO APP
		// Creamos el vuelo
		objeto_vuelo = Funcionalidades.initVuelo();

		// Lanzamos Menú Principal
		do {
			Funcionalidades.initMenu();
			menuOption = Funcionalidades.selectOption();

			switch (menuOption) {

			// ACCEDER COMO ADMIN
			case 1:
				accesoMenuAdmin = Funcionalidades.loginAdmin();
				if (accesoMenuAdmin == true) {

					do {
						Funcionalidades.initMenuAdmin();
						menuAdminOption = Funcionalidades.selectOption(Constantes.MAX_OPTION_ADMIN_MENU);

						switch (menuAdminOption) {

						// VER DATOS VUELO
						case 1:
							System.out.println(objeto_vuelo.toString());
							break;

						// AÑADIR TRABAJADOR
						case 2:

							// Comprobamos si existen posiciones vacías
							contadorPosicionesVacias = Funcionalidades.encontrarPosicionVacia(trabajadores);

							if (contadorPosicionesVacias == -1) {
								arrayTrabajadoresLleno = true;
							}

							if (arrayTrabajadoresLleno) {
								System.out.println("No se pueden añadir más trabajadores.");
							} else {

								// Creamos el objeto
								trabajadorCreado = Funcionalidades.crearTrabajador(trabajadores);

								// Buscamos posición vacía para introducirlo
								posicionArrayTrabajadores = Funcionalidades.encontrarPosicionVacia(trabajadores);

								// Introducimos el objeto en el array
								trabajadores[posicionArrayTrabajadores] = trabajadorCreado;

								// Actualizamos el array de trabajadores del vuelo
								objeto_vuelo.setTrabajadores(trabajadores);

								// Reiniciamos el objeto
								trabajadorCreado = null;

							}
							break;

						// VER DATOS TRABAJADOR
						case 3:

							// Comprobamos que exista mínimo un trabajador
							if (trabajadores[0] != null) {
								minimoUnTrabajador = true;
							}

							// Si existe mínimo un trabajador, mostramos datos
							if (minimoUnTrabajador) {
								Funcionalidades.datosTrabajadores(trabajadores);
							} else {
								System.out.println("No hay datos de trabajadores para mostrar.");
							}
							break;
						}

					} while (menuAdminOption != 0);

				}
				break;

			// ACCEDER COMO CLIENTE
			case 2:
				vueloOptimo = Funcionalidades.comprobarTripulacion(trabajadores);

				if (vueloOptimo) {
					accesoMenuClient = true;
				} else {
					accesoMenuClient = false;
				}

				if (accesoMenuClient == true) {
					do {
						Funcionalidades.initMenuClient();
						menuClientOption = Funcionalidades.selectOption(Constantes.MAX_OPTION_CLIENT_MENU);
						switch (menuClientOption) {
						case 1:
							System.out.println(objeto_vuelo.toString());
							break;
						case 2:
							System.out.println("COMPRA DE BILLETES");
							System.out.println("------------------");
							break;
						case 0:
							break;
						}
					} while (menuClientOption != 0);
				} else {
					System.out.println("No existe vuelo disponible todavía.");
				}

				break;

			// CERRAR APP
			case 0:
				break;
			}

		} while (menuOption != 0);
		System.out.println("Aplicación cerrada.");
	}

} // Final Main
