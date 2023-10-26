package objetos;

import java.time.LocalDate;

public class Piloto extends Trabajador {

	private String nombre;
	private String apellidos;
	private String DNI;
	private String telefono;
	private String referencia;
	private LocalDate fecha;
	
	
	
	public Piloto(String nombre, String apellidos, String dNI, String telefono, String referencia, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.telefono = telefono;
		this.referencia = referencia;
		this.fecha = fecha;
	}



	@Override
	public String toString() {
		return "Piloto [nombre= " + nombre + ", apellidos= " + apellidos + ", DNI= " + DNI + ", telefono= " + telefono
				+ ", referencia= " + referencia + ", fecha= " + fecha + "]";
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getReferencia() {
		return referencia;
	}



	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
}
