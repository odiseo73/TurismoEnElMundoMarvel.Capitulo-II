package productos;

import java.util.List;

public class PromocionAxB extends Promocion {
public PromocionAxB(Integer id, String nombre, List<Atraccion> atracciones) {
		super(id, nombre, atracciones);
		
	}


private double precio;
	

	@Override
	public double getPrecioConDescuento() {
		
		return super.getPrecio() - super.getAtracciones().get(0).getPrecio();
		
	}


	public void restarCupo() {
		// TODO Auto-generated method stub
		
	}


	


}
