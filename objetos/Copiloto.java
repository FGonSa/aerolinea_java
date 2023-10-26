package objetos;


public class Copiloto extends Trabajador {
	
	private String nombre;
	private String apellidos;
	private String DNI;
	private boolean master;
	
	public Copiloto(String nombre, String apellidos, String dNI, boolean master) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.master = master;
	}
	
	

	@Override
	public String toString() {
		return "Copiloto [nombre= " + nombre + ", apellidos= " + apellidos + ", DNI= " + DNI + ", master= " + master + "]";
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

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}
	
	
	
}
