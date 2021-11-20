package productos;

public interface Producto {
	int getPrecio();

	double getTiempoEnHoras();
	 void restarCupo();

	 String getNombre();
	
	 boolean esPromocion();
	 boolean verificarCupo();
}
