package productos;

import java.util.ArrayList;
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
	
	public boolean verificarCupo(List<Atraccion> atraccionesCompradas) {
		boolean hayCupo = true;
		List<Atraccion> atraccionesDePromocion = this.getAtracciones();
		for (Atraccion atraccion : atraccionesCompradas) {
			if (!atraccion.hayCupo()) {
				hayCupo = false;
			}
		}
		for (Atraccion atraccion : atraccionesDePromocion) {
			if (!atraccion.hayCupo()) {
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

}
