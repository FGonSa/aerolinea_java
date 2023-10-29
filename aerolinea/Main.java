package aerolinea;

import objetos.*;

public class Main {

	public static void main(String[] args) {

		// VARIABLES
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
		int cantidadBilletes = 0;
		double boteTotal = 0;
		int boteBilletesComprados = 0;
		boolean hayPlazas = false;
		double precioTotalBilletesAComprar = 0;
		boolean compraON = true;
		int compraOption = 0;
		int plazasLibres = 0;

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

							// Recaudación
							boteTotal = objeto_vuelo.calcularPrecioTotal(boteBilletesComprados);
							System.out.println("BILLETES COMPRADOS: " + boteBilletesComprados);
							System.out.println("RECAUDACIÓN TOTAL: " + boteTotal + "€");

							// Plazas que faltan por vender
							plazasLibres = objeto_vuelo.getTotalPlazas() - objeto_vuelo.getPlazasCompradas();
							System.out.println("PLAZAS LIBRES: " + plazasLibres);
							boteTotal = objeto_vuelo.calcularPrecioNoComprados();
							System.out.println("FALTA POR RECAUDAR: " + boteTotal + "€");
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

						// VER DATOS DEL VUELO
						case 1:
							System.out.println(objeto_vuelo.toString());
							break;

						// COMPRA DE BILLETES
						case 2:

							// Comprobamos si hay plazas libres antes de dejar comprar
							plazasLibres = objeto_vuelo.getTotalPlazas() - objeto_vuelo.getPlazasCompradas();

							if (plazasLibres > 0) {
								do {
									
									System.out.println("COMPRA DE BILLETES");
									System.out.println("------------------");

									// Indicamos la cantidad de billetes que queremos comprar
									cantidadBilletes = Funcionalidades.indicarCantidadBilletes();

									if (cantidadBilletes > 0) {
										// comprobamos que haya plazas libres para esa cantidad de billetes
										hayPlazas = objeto_vuelo.hayPlazasDisponibles(cantidadBilletes);

										if (hayPlazas) {
											// Si hay plazas, calculamos el precio que costarán esos billetes
											precioTotalBilletesAComprar = objeto_vuelo
													.calcularPrecioBilletes(cantidadBilletes);

											// Confirmamos compra

											do {
												System.out.println("El precio total de los billetes es "
														+ precioTotalBilletesAComprar + "€");
												System.out.println("¿Confirmas la compra?");
												System.out.println("1) SÍ || 2)NO");
												compraOption = Funcionalidades.selectOption(1, 2);
											} while (compraOption <= 0);

											if (compraOption == 1) {
												System.out.println("COMPRA REALIZADA CON ÉXITO.");

												// Actualizamos cuántos billetes llevamos vendidos
												boteBilletesComprados += cantidadBilletes;

												// Actualizamos las plazas ocupadas
												objeto_vuelo.setPlazasCompradas(boteBilletesComprados);

												// Finalizamos compra
												compraON = false;
											} else {
												System.out.println("COMPRA DE BILLETES CANCELADA.");
												compraON = false;
											}

										} else {

											do {
												System.out.println("No quedan tantas plazas libres.");
												System.out.println("¿Desea volver a intentar otra cantidad?");
												System.out.println("1) SÍ || 2)NO");
												compraOption = Funcionalidades.selectOption(1, 2);
											} while (compraOption <= 0);

											if (compraOption == 2) {
												System.out.println("COMPRA DE BILLETES CANCELADA.");
												compraON = false;
											}
											compraOption = 0;
										}
									} else {
										System.out.println("COMPRA DE BILLETES CANCELADA.");
										compraON = false;
									}
								} while (compraON);
							} else {
								System.out.println("No quedan plazas libres.");
							}
							break;

						// SALIR MENÚ CLIENTE
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
