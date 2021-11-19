package usuario;

import java.util.LinkedList;
import java.util.List;

import productos.Atraccion;

//import java.util.List;


public class Usuario {
private int id;
	private String nombre;
	private double tiempoDisponible;
	private double dinero;
	private List<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>();
	//private List<Atraccion> atraccionesCompradas;
	
	public Usuario(int id, String nombre, double dinero, double tiempoEnHoras) {
		this.id = id;
		this.nombre = nombre;
		this.tiempoDisponible = tiempoEnHoras;
		this.dinero = dinero;
	}
	public String getNombre() {
		return nombre;
	}
	public double getTiempoEnHoras() {
		return tiempoDisponible;
	}
	public double getDinero() {
		return dinero;
	}
	public int getId() {
		return id;
	}
	public List<Atraccion> getAtraccionesCompradas(){
		return atraccionesCompradas;
	}
/*
	public void comprarOfertable(Ofertable o) {
			this.dinero -= o.getPrecio();
			this.tiempoDisponible -= o.getTiempoEnHoras();
			
			if (o.esPromocion()) {
				for (Atraccion atraccion : o.getAtracciones()) {
					this.atraccionesCompradas.add(atraccion);
				}
			}
			if (!o.esPromocion()) {
				atraccionesCompradas.add((Atraccion) o);
			}
	}
	*/

	@Override
	public String toString() {
		return "Usuario [Nombre=" + nombre + ", TiempoEnHoras=" + tiempoDisponible + ", Dinero=" + dinero + "]" + "\n";
	}
	
	//tieneDineroSuficiente
	//tieneTiempoSuficiente

}
	   
