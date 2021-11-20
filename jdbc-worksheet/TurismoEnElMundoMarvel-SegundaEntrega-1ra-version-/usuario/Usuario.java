package usuario;

import java.util.LinkedList;
import java.util.List;

import productos.Atraccion;
import productos.Itinerario;
import productos.Producto;

//import java.util.List;

public class Usuario {
	private int id;
	private String nombre;
	private double tiempoDisponible;
	private double dineroDisponible;
	private List<Atraccion> atraccionesCompradas;
	private Itinerario itinerario;
	// private List<Atraccion> atraccionesCompradas;

	public Usuario(int id, String nombre, double dinero, double tiempoEnHoras) {
		this.id = id;
		this.nombre = nombre;
		this.tiempoDisponible = tiempoEnHoras;
		this.dineroDisponible = dinero;
		this.atraccionesCompradas = new LinkedList<Atraccion>();
		this.itinerario = new Itinerario(this.getNombre(), "", 0, 0);
	}

	public String getNombre() {
		return nombre;
	}

	public double getTiempoEnHoras() {
		return tiempoDisponible;
	}

	public double getDinero() {
		return dineroDisponible;
	}

	public int getId() {
		return id;
	}

	public Itinerario getItinerario() {
		return this.itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public boolean tieneComprado(Producto productoOfrecido,List<Producto> productosComprados) {
		boolean bandera = false;
		for (Producto productoComprado : productosComprados) {
	
			if(productoOfrecido.getNombre().equals(productoComprado.getNombre())){
				bandera = true;
			}
		
	}
		return bandera;
	}
	public List<Atraccion> getAtraccionesCompradas() {
		return atraccionesCompradas;
	}

	public boolean comprarProducto(Producto o) {

		this.dineroDisponible -= o.getPrecio();
		this.tiempoDisponible -= o.getTiempoEnHoras();

		if (o.esPromocion()) {
			for (Atraccion atraccion : o.getAtracciones()) {
				this.atraccionesCompradas.add(atraccion);
			}
		}
		if (!o.esPromocion()) {
			atraccionesCompradas.add((Atraccion) o);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Usuario [Nombre=" + nombre + ", TiempoEnHoras=" + tiempoDisponible + ", Dinero=" + dineroDisponible
				+ "]" + "\n";
	}

	public boolean puedeComprar(Producto o) {
		if ((this.dineroDisponible >= o.getPrecio()) && (this.tiempoDisponible >= o.getTiempoEnHoras())) {
			return true;
		} else {
			return false;
		}
	}

}
