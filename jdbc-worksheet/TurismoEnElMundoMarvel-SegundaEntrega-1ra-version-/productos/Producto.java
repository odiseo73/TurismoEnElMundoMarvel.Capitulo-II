package productos;

import java.util.List;

public interface Producto {
	double getPrecio();
double getPrecioConDescuento();
	double getTiempoEnHoras();
	 void restarCupo();

	 String getNombre();
	
	 boolean esPromocion();
	 boolean compararNombresIguales(List<Atraccion> atraccionesCompradas, Producto productoOfrecido);

	List<Atraccion> getAtracciones();
}
