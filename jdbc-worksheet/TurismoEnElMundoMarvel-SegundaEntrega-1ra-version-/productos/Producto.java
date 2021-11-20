package productos;

import java.util.List;

public interface Producto {
	int getPrecio();

	double getTiempoEnHoras();
	 void restarCupo();

	 String getNombre();
	
	 boolean esPromocion();
	 

	List<Atraccion> getAtracciones();
}
