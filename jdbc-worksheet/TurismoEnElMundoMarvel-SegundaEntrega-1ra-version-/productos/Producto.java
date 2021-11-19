package productos;

import java.util.List;

public interface Producto {
	int getPrecio();

	double getTiempoEnHoras();
	 void restarCupo();

	 String getNombre();
	
	 List<Atraccion> getAtracciones();
	
	 boolean esPromocion();
	 boolean verificarCupo(List<Atraccion> atr);
}
