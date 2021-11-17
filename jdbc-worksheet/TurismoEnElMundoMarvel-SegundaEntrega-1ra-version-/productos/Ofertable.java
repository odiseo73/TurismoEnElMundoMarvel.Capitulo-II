package productos;

import java.util.List;

public interface Ofertable {

	int getPrecio();

	double getTiempoEnHoras();
	void restarCupo();

	String getNombre();
	
	public List<Atraccion> getAtracciones();
	
	boolean esPromocion();
}
