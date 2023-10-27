package aerolinea;

import objetos.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuOption = -1;
		int menuAdminOption = -1;
		boolean accesoMenuAdmin = false;
		Vuelo objeto_vuelo = null;
		Trabajador trabajadores[] = new Trabajador[Constantes.TRABAJADORES_LENGTH];

		// INICIO APP
		// Creamos el vuelo
		objeto_vuelo = Funcionalidades.initVuelo();

		// Lanzamos Menú Principal
		do {
			Funcionalidades.initMenu();
			menuOption = Funcionalidades.selectOption();

			if (menuOption == 1) {
				accesoMenuAdmin = Funcionalidades.loginAdmin();
				if (accesoMenuAdmin == true) {

					do {
						Funcionalidades.initMenuAdmin();
						menuAdminOption = Funcionalidades.selectOption(Constantes.MAX_OPTION_ADMIN_MENU);

						if (menuAdminOption == 1) {
							System.out.println(objeto_vuelo.toString());

						}
					} while (menuAdminOption != 0);

				}
			}

		} while (menuOption != 0);
		System.out.println("Aplicación cerrada.");
	}

} // Final Main
