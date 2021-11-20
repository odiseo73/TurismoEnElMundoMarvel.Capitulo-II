package productos;

import java.util.List;

public abstract class Promocion implements Producto {

	private String nombre;
	private List<Atraccion> atracciones;
    private Integer id;
	
	
	public Promocion(Integer id,String nombre, List<Atraccion> atracciones) {
		this.nombre = nombre;
		this.atracciones = atracciones;
		this.id = id;
	}

	public abstract double getPrecioConDescuento();

	public String getNombre() {
		return nombre;
	}

	public int getPrecio() {
		int precio = 0;
		for (Atraccion atraccion : atracciones) {
			precio += atraccion.getPrecio();
		}
		return precio;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	//que hace esto
	public boolean verificarCupo(List<Atraccion> atraccionesCompradas) {
		boolean hayCupo = true;
		List<Atraccion> atraccionesDePromocion = this.getAtracciones();
		for (Atraccion atraccion : atraccionesCompradas) {
			if (!atraccion.verificarCupo()) {
				hayCupo = false;
			}
		}
		for (Atraccion atraccion : atraccionesDePromocion) {
			if (!atraccion.verificarCupo()) {
				hayCupo = false;
			}
		}
		return hayCupo;
	}
	
	public void restarCupo() {
		for (Atraccion atracciones : atracciones) {
			atracciones.restarCupo();
		}
	}

	public boolean esPromocion() {
		return true;
	}

	public double getTiempoEnHoras() {
		double tiempo = 0;
		for (Atraccion atraccion : atracciones) {
			tiempo += atraccion.getTiempoEnHoras();
		}
		return tiempo;
	}

	@Override
	public String toString() {
		return "Promocion: " + "\n" + "Nombre: " + nombre + "\n" + "Atracciones incluidas: "
				+ getAtracciones() + "\n" + "Duracion: " + getTiempoEnHoras() + " horas" + "\n"
				+ "Precio Original: " + getPrecio() + " Puntos Marvel" + "\n" + "Precio con descuento:"
				+ getPrecioConDescuento() + " Puntos Marvel" + "\n";
	}

	private boolean verificarRepetidos(List<Producto> productosComprados) {
		boolean bandera = false;
		for (Atraccion atraccion : this.atracciones) {
			if (productosComprados.contains(atraccion)) {
				bandera = true;
			}
		}
		return bandera;
	}
	
}
