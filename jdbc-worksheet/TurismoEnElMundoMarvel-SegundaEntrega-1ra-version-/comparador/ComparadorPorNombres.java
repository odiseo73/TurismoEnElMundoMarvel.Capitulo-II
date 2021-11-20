package comparador;

import java.util.Comparator;

import productos.Atraccion;

public class ComparadorPorNombres implements Comparator<Atraccion> {

	public int compare(Atraccion o1, Atraccion o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
