package productos;

import java.util.List;

public class PromocionAxB extends Promocion {
public PromocionAxB(String nombre, List<Atraccion> atracciones) {
		super(nombre, atracciones);
		
	}


private double precio;
	

	@Override
	public double getPrecioConDescuento() {
		
		return super.getPrecio() - super.getAtracciones().get(0).getPrecio();
		
	}



}
