package objetos;

import java.util.Arrays;

import aerolinea.Constantes;

public class Vuelo implements GestionVuelo {

	private String avion;
	private String origen;
	private String destino;
	private int duracion;
	private int totalPlazas;
	private int plazasCompradas = 0;
	private double precioPlaza;
	private Trabajador trabajadores[] = new Trabajador[Constantes.TRABAJADORES_LENGTH];

	public Vuelo(String avion, String origen, String destino, int duracion, int totalPlazas, int plazasCompradas,
			double precioPlaza, Trabajador[] trabajadores) {
		super();
		this.avion = avion;
		this.origen = origen;
		this.destino = destino;
		this.duracion = duracion;
		this.totalPlazas = totalPlazas;
		this.plazasCompradas = plazasCompradas;
		this.precioPlaza = precioPlaza;
		this.trabajadores = trabajadores;
	}

	@Override
	public String toString() {
		return "Vuelo [vuelo=" + avion + ", origen=" + origen + ", destino=" + destino + ", duracion=" + duracion
				+ ", totalPlazas=" + totalPlazas + ", plazasCompradas=" + plazasCompradas + ", precioPlaza="
				+ precioPlaza + ", trabajadores=" + Arrays.toString(trabajadores) + "]";
	}

	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getTotalPlazas() {
		return totalPlazas;
	}

	public void setTotalPlazas(int totalPlazas) {
		this.totalPlazas = totalPlazas;
	}

	public int getPlazasCompradas() {
		return plazasCompradas;
	}

	public void setPlazasCompradas(int plazasCompradas) {
		this.plazasCompradas = plazasCompradas;
	}

	public double getPrecioPlaza() {
		return precioPlaza;
	}

	public void setPrecioPlaza(double precioPlaza) {
		this.precioPlaza = precioPlaza;
	}

	public Trabajador[] getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(Trabajador[] trabajadores) {
		this.trabajadores = trabajadores;
	}

	// MÉTODOS INTERFAZ
	@Override
	public boolean hayPlazasDisponibles(int numeroBilletesComprar) {
		// Calcular si hi ha places disponibles a l’avió a partir de les places totals i
		// del número
		// de bitllets a comprar.
		int resultado = 0;

		resultado = this.totalPlazas - numeroBilletesComprar;

		if (resultado > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double calcularPrecioTotal(int numeroBilletesComprados) {
		// Calcular el preu total dels bitllets comprats.
		double precioTotal = 0;

		precioTotal = this.precioPlaza * numeroBilletesComprados;
		return precioTotal;
	}

	@Override
	public double calcularPrecioNoComprados() {
		// Calcular el preu total dels bitllets no comprats.
		int plazasSinOcupar = 0;
		double total = 0;

		plazasSinOcupar = this.totalPlazas - this.plazasCompradas;
		total = plazasSinOcupar * this.precioPlaza;
		return total;
	}

	@Override
	public double calcularPrecioBilletes(int numeroBilletes) {
		// Calcular el preu del número de bitllets rebut per paràmetre.
		double total = 0;

		total = numeroBilletes * this.precioPlaza;
		return total;
	}

}
