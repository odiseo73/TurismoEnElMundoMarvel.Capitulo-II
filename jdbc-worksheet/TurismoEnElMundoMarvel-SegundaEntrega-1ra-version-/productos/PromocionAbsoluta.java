package productos;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precio;
	public PromocionAbsoluta(String nombre, int precio, List<Atraccion> atracciones) {
		super(nombre, atracciones);
		this.precio = precio;
	}

	@Override
	protected double getPrecioConDescuento() {
		return precio;
		
		
	}



}
