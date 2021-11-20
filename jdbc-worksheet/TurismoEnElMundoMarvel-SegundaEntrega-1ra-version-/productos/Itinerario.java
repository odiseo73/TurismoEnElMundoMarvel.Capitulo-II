package productos;

import java.util.LinkedList;
import java.util.List;

public class Itinerario {
	
	private String usuario;
	private String productosComprados;
	private double horasNecesarias;
	private double puntos;

	public Itinerario(String usuario, String productosComprados, double horasNecesarias, double puntos) {
		super();
		
		this.usuario = usuario;
		this.productosComprados = productosComprados;
		this.horasNecesarias = horasNecesarias;
		this.puntos = puntos;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getProductos() {
		return productosComprados;
	}

	public double getHorasNecesarias() {
		return horasNecesarias;
	}

	public double getPuntos() {
		return puntos;
	}
	public LinkedList<String> getProductosComprados(){
		LinkedList<String> productos = new LinkedList<String>();
		String[] array = productosComprados.split(",");
		for (String string : array) {
			productos.add(string);
		}		
		return productos;
		
	}
	//despues se modifica la lista de productosComprados por String
	 public void setProductosComprados(List<Producto> productosComprados) {
		
		 for (Producto producto : productosComprados) {
			this.productosComprados = producto.getNombre() + ",";
			this.horasNecesarias += producto.getTiempoEnHoras();
			this.puntos += producto.getPrecio();
		}
	 }

}
