package lectorDeArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import productos.Atraccion;
import productos.Producto;
import productos.Promocion;
import usuario.Usuario;
import dao.AtraccionDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;


public class Parque {
	private UsuarioDAO usuarioDAO;
	private AtraccionDAO atraccionDAO;
	private PromocionDAO promocionDAO;
	
	private List<Usuario> usuarios;
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;
	// despues eliminar atr
	private List<Atraccion> atr;
	
	private ArrayList<Atraccion> atraccionesUsadas;
	
	public Parque(UsuarioDAO dao1, AtraccionDAO dao2, PromocionDAO dao3) throws FileNotFoundException, SQLException {
		this.usuarioDAO = dao1;
		this.atraccionDAO = dao2;
		this.promocionDAO = dao3;
		leerArchivos();
		ofrecerProductos();

	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void leerArchivos() throws FileNotFoundException, SQLException {
		
		usuarios = usuarioDAO.findAll();
		atracciones = atraccionDAO.findAll() ;
		promociones = promocionDAO.findAll();
		//atr ;
	}
	private void generarItinerario(Usuario usuario, List<Producto> productosComprados) throws FileNotFoundException {
		int puntos = 0;
		int tiempo = 0;
		System.out.println("Resumen del itinerario de: " + usuario.getNombre() + "\n");
		System.out.println("Productos Comprados:" + productosComprados.size() + "\n");

		for (Producto producto : productosComprados) {

			producto.getTiempoEnHoras();
			tiempo += producto.getTiempoEnHoras();
		}

		System.out.println("Horas necesarias para realizarlos:" + tiempo + "\n");

		for (Producto producto : productosComprados) {

			producto.getPrecio();
			puntos += producto.getPrecio();
		}

		System.out.println("Puntos Marvel necesarios:" + puntos + "\n");

		PrintWriter salida = new PrintWriter(new File("Itinerario_Usuario_" + usuario.getNombre() + ".txt"));
		salida.write("Resumen del itinerario de: " + usuario.getNombre() + "\n");
		salida.write("Productos Comprados:" + productosComprados.size() + "\n");
		salida.write("Horas necesarias para realizarlos:" + tiempo + "\n");
		salida.write("Puntos Marvel necesarios:" + puntos + "\n");
		salida.close();

	}

	private int compararPrecioPromocion(Usuario o, Promocion p) {
		return Double.compare(o.getDinero(), p.getPrecioConDescuento());
	}

	private int compararPrecioAtraccion(Usuario o, Atraccion a) {
		return Double.compare(o.getDinero(), a.getPrecio());
	}

	private int compararTiempo(Usuario o, Producto p) {
		return Double.compare(o.getTiempoEnHoras(), p.getTiempoEnHoras());
	}


	private boolean verificarRepetidosPromocion(List<Producto> productosComprados, List<Atraccion> atr2) {
		boolean bandera = false;
		for (Atraccion atraccion : atr2) {
			if (productosComprados.contains(atraccion)) {
				bandera = true;
			}
		}
		return bandera;
	}

	private boolean verificarRepetidosAtraccion(List<Producto> productos, Atraccion atr) {
		boolean bandera = false;
for (Producto producto : productos) {
	if(producto.getClass().toString().equals("class mundoMarvel.Promocion")) {
		//producto.getAtraccionesIndividuales().contains(atr.getNombre());
		bandera = true;
	}
	if(producto.getClass().toString().equals("class mundoMarvel.Atraccion")) {
		producto.getNombre().equals(atr.getNombre());
		bandera = true;
	}
}
		return bandera;
	}
	private List<Atraccion> aniadirAtraccionComprada(List<Atraccion> atraccionesCompradas, Producto producto) {
		
		if(producto.esPromocion()) {
			List<Atraccion> lista = producto.getAtracciones();
		for (Atraccion atraccion : lista) {
			if (!compararNombresIguales(atraccionesCompradas, atraccion)) {
				atraccionesCompradas.add(atraccion);
			}
		}
		}
		if(!producto.esPromocion()) {
			
				if (!compararNombresIguales(atraccionesCompradas, producto)) {
					atraccionesCompradas.add((Atraccion) producto);
			}
		}
		return atracciones;
	}
private List<Producto> aniadirProductoComprado(List<Producto> productosComprados, Producto producto){
	if (producto.esPromocion()) {
		for (Atraccion atraccion : producto.getAtracciones()) {
			productosComprados.add(atraccion);
		}
	}
	if (!producto.esPromocion()) {
		productosComprados.add(producto);
	}
	return productosComprados;
}
	private List<Atraccion> aniadirAtraccionesUsadas(List<Atraccion> atr, Atraccion a) {

		if (!compararNombresIguales(atraccionesUsadas, a)) {
			atr.add(a);
		}
		return atr;
	}


	private boolean compararNombresIguales(List<Atraccion> atracciones, Producto producto) {
		boolean bandera = false;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(producto.getNombre())) {
				bandera = true;
			}
		}

		return bandera;
	}
	private void ofrecerProductos() throws FileNotFoundException {

		for (Usuario usuario : usuarios) {

			List<Producto> productosComprados = new LinkedList<Producto>();
			//List<String> productosComprados = new ArrayList<String>();
			System.out.println("----------------------------------------------");
			System.out.println("Bienvenido/a a Mundo Marvel");
			System.out.println("Nombre de Visitante: " + usuario.getNombre());
			System.out.println("Le ofrecemos los siguientes productos");
			System.out.println();

			ofrecerPromociones(usuario, productosComprados);
			ofrecerAtracciones(usuario, productosComprados);

			generarItinerario(usuario, productosComprados);
		}
	}



	void ofrecerPromociones(Usuario usuario, List<Producto> productosComprados) {

		atraccionesUsadas = new ArrayList<Atraccion>();
		List<Atraccion> atraccionesCompradas = usuario.getAtraccionesCompradas();

		for (Promocion promocion : promociones) {
// compararPrecioPromocion, compararTiempo y verificarRepertidosPromocion tienen que ser metodos propios de Promocion
			
//productosComprados puede ser pensada comp una lista de String con los nombre de los productos para despues directamente
//ser colocados en la tabla itinerario			
			if (compararPrecioPromocion(usuario, promocion) >= 0 && (compararTiempo(usuario, promocion) >= 0)
					&& promocion.verificarCupo(atraccionesCompradas)
					&& !verificarRepetidosPromocion(productosComprados, promocion.getAtracciones())) {

				System.out.println(promocion);
				System.out.println("Acepta la sugerencia?" + " Ingrese SI o NO");
				Scanner sc = new Scanner(System.in);
				String respuesta;
				respuesta = sc.nextLine().toUpperCase();

				while (!respuesta.equals("SI") && !respuesta.equals("NO")) {
					System.out.println("Por favor, ingrese SI o NO.");
					respuesta = sc.nextLine().toUpperCase();
				}
				if (respuesta.equals("SI")) {
					//usuario.comprarOfertable(promocion);
					aniadirProductoComprado(productosComprados, promocion);
					aniadirAtraccionComprada(atraccionesCompradas, promocion);
					restarCupo(atraccionesCompradas);
					
					//aniadirOfertable(productosComprados, promocion);
				}
				System.out.println("----------------------------------------------");
			}
		}
	}

	void ofrecerAtracciones(Usuario usuario, List<Producto> productosComprados) {

		atraccionesUsadas = new ArrayList<Atraccion>();

		List<Atraccion> atraccionesCompradas = usuario.getAtraccionesCompradas();

		for (Atraccion atraccion : atr) {
			if (compararPrecioAtraccion(usuario, atraccion) >= 0 && compararTiempo(usuario, atraccion) >= 0
					&& atraccion.verificarCupo(atraccionesUsadas)
					&& !verificarRepetidosAtraccion(productosComprados, atraccion)) {

				System.out.println(atraccion);
				System.out.println("Acepta la sugerencia?" + " Ingrese SI o NO");
				Scanner sc = new Scanner(System.in);
				String respuesta;
				respuesta = sc.nextLine().toUpperCase();

				while (!respuesta.equals("SI") && !respuesta.equals("NO")) {
					System.out.println("Por favor, ingrese SI o NO.");
					respuesta = sc.nextLine().toUpperCase();
				}
				if (respuesta.equals("SI")) {
					//usuario.comprarOfertable(atraccion);
					//aniadirAtraccionesUsadas(atraccionesUsadas, atraccion);
					aniadirProductoComprado(productosComprados,atraccion);
					aniadirAtraccionComprada(atraccionesCompradas, atraccion);
					//aniadirAtraccionesUsadas(atraccionesCompradas, atraccion);

					//restarCupo(atraccionesUsadas, atraccionesCompradas);
					restarCupo(atraccionesCompradas);
					//aniadirOfertable(productosComprados, atraccion);
				}
				System.out.println("----------------------------------------------");
			}
		}
	}

	void aniadirOfertable(List<Producto> productosComprados, Producto o) {
		productosComprados.add(o);
	}

	private void restarCupo(List<Atraccion> atraccionesCompradas) {
		for (Atraccion atraccion : atraccionesCompradas) {
			atraccion.restarCupo();
		}

	}
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}
}


