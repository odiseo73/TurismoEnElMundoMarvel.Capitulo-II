package productos;

import java.util.List;
import java.util.Objects;

public class Atraccion implements Producto {
	
private int id;
	private String nombre;
	private int precio;
	private double tiempoEnHoras;
	private final int CUPO_INICIAL;
	private int cupoDisponible;

	public Atraccion(int id, String nombre, int precio, double tiempoEnHoras, int cupo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.tiempoEnHoras = tiempoEnHoras;
		this.CUPO_INICIAL = cupo;
		this.cupoDisponible = cupo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getTiempoEnHoras() {
		return tiempoEnHoras;
	}

	public int getCupoInicial() {
		return CUPO_INICIAL;
	}

	public int getCupoDisponible() {
		return cupoDisponible;
	}

	public void restarCupo() {
		this.cupoDisponible -= 1;
	}

	public boolean hayCupo() {
		return this.cupoDisponible > 0;
	}
	
		
	public boolean esPromocion() {
		return false;
	}

		
	@Override
	public String toString() {
		return "Atraccion: "+ "\n" + "Nombre: " + nombre + "\n" + "Puntos Marvel: "  + precio + "\n" + "Duracion:"
				+ tiempoEnHoras + " horas" + "\n";
	}

	public int getPrecio() {

		return precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CUPO_INICIAL, cupoDisponible, tiempoEnHoras, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return CUPO_INICIAL == other.CUPO_INICIAL && cupoDisponible == other.cupoDisponible
				&& Double.doubleToLongBits(tiempoEnHoras) == Double.doubleToLongBits(other.tiempoEnHoras)
				&& Objects.equals(nombre, other.nombre) && precio == other.precio;
	}

	public List<Atraccion> getAtracciones() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		return id;
	}

	public boolean verificarCupo(List<Atraccion> atraccionesCompradas) {
		boolean hayCupo = true;
		for (Atraccion atraccion : atraccionesCompradas) {
			if (!atraccion.hayCupo()) {
				hayCupo = false;
			}
		}
		return hayCupo;
	}


}
