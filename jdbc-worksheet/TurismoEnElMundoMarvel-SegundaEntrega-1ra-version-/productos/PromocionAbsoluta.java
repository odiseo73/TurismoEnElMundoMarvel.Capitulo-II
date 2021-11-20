package productos;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precio;
	public PromocionAbsoluta(Integer id, String nombre, int precio, List<Atraccion> atracciones) {
		super(id, nombre, atracciones);
		this.precio = precio;
	}

	@Override
	public double getPrecioConDescuento() {
		return precio;
		
		
	}



	

	



}
