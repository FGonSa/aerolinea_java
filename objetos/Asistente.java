package objetos;

public class Asistente extends Trabajador {
	private String nombre;
	private String apellidos;
	private String DNI;
	
	public Asistente(String nombre, String apellidos, String dNI) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
	}

	@Override
	public String toString() {
		return "Asistente [nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + "]";
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
	
	
	
	
}
