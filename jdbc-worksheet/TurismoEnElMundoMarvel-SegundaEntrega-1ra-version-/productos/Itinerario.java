package productos;

public class Itinerario {
	private int id;
	private String usuarios;
	private String productos;
	private double horasNecesarias;
	private double puntos;

	public Itinerario(int id, String usuarios, String productos, double horasNecesarias, double puntos) {
		super();
		this.id = id;
		this.usuarios = usuarios;
		this.productos = productos;
		this.horasNecesarias = horasNecesarias;
		this.puntos = puntos;
	}

	public int getId() {
		return id;
	}

	public String getUsuarios() {
		return usuarios;
	}

	public String getProductos() {
		return productos;
	}

	public double getHorasNecesarias() {
		return horasNecesarias;
	}

	public double getPuntos() {
		return puntos;
	}

}
