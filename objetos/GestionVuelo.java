package objetos;

public interface GestionVuelo {
    boolean hayPlazasDisponibles(int numeroBilletesComprar);
    double calcularPrecioTotal(int numeroBilletesComprados);
    double calcularPrecioNoComprados();
    double calcularPrecioBilletes(int numeroBilletes);
}
