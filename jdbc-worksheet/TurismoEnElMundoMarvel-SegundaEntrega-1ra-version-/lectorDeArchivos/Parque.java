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
import productos.Ofertable;
import productos.Promocion;
import usuario.Usuario;
import dao.AtraccionDAO;
import dao.UsuarioDAO;


public class Parque {
	private UsuarioDAO dao1;
	private AtraccionDAO dao2;
	
	private List<Usuario> usuarios;
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;
	// despues eliminar atr
	private List<Atraccion> atr;
	
	private ArrayList<Atraccion> atraccionesUsadas;
	
	public Parque(UsuarioDAO dao1, AtraccionDAO dao2) throws FileNotFoundException, SQLException {
		this.dao1 = dao1;
		this.dao2 = dao2;
		leerArchivos();
		//ofrecerProductos();

	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void leerArchivos() throws FileNotFoundException, SQLException {
		
		usuarios = dao1.findAll();
		atracciones = dao2.findAll() ;
		//promociones = dao.findAll();
		//atr ;
	}
	private void generarItinerario(Usuario usuario, List<Ofertable> productosComprados) throws FileNotFoundException {
		int puntos = 0;
		int tiempo = 0;
		System.out.println("Resumen del itinerario de: " + usuario.getNombre() + "\n");
		System.out.println("Productos Comprados:" + productosComprados.size() + "\n");

		for (Ofertable producto : productosComprados) {

			producto.getTiempoEnHoras();
			tiempo += producto.getTiempoEnHoras();
		}

		System.out.println("Horas necesarias para realizarlos:" + tiempo + "\n");

		for (Ofertable producto : productosComprados) {

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

	private int compararTiempo(Usuario o, Ofertable p) {
		return Double.compare(o.getTiempoEnHoras(), p.getTiempoEnHoras());
	}

	private boolean verificarCupo(List<Atraccion> atracciones) {
		boolean hayCupo = true;
		for (Atraccion atraccion : atracciones) {
			if (!atraccion.hayCupo()) {
				hayCupo = false;
			}
		}
		return hayCupo;
	}

	private boolean verificarRepetidosPromocion(List<Atraccion> atr1, List<Atraccion> atr2) {
		boolean bandera = false;
		for (Atraccion atraccion : atr2) {
			if (atr1.contains(atraccion)) {
				bandera = true;
			}
		}
		return bandera;
	}

	private boolean verificarRepetidosAtraccion(List<Ofertable> productos, Atraccion atr) {
		boolean bandera = false;
for (Ofertable producto : productos) {
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

	private void ofrecerProductos() throws FileNotFoundException {

		for (Usuario usuario : usuarios) {

			List<Ofertable> productosComprados = new LinkedList<Ofertable>();
			
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

	private List<Atraccion> aniadirPromocionComprada(List<Atraccion> atr, Promocion p) {
		List<Atraccion> lista = p.getAtracciones();
		for (Atraccion atraccion : lista) {
			if (!compararNombresIguales(atraccionesUsadas, atraccion)) {
				atr.add(atraccion);
			}
		}
		return atr;
	}

	private List<Atraccion> aniadirAtraccionesUsadas(List<Atraccion> atr, Atraccion a) {

		if (!compararNombresIguales(atraccionesUsadas, a)) {
			atr.add(a);
		}
		return atr;
	}


	private boolean compararNombresIguales(List<Atraccion> atracciones, Atraccion atr) {
		boolean bandera = false;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(atr.getNombre())) {
				bandera = true;
			}
		}

		return bandera;
	}

	void ofrecerPromociones(Usuario usuario, List<Ofertable> productosComprados) {

		atraccionesUsadas = new ArrayList<Atraccion>();
		List<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>();

		for (Promocion promocion : promociones) {

			if (compararPrecioPromocion(usuario, promocion) >= 0 && (compararTiempo(usuario, promocion) >= 0)
					&& verificarCupo(atraccionesUsadas)
					&& !verificarRepetidosPromocion(atraccionesCompradas, promocion.getAtracciones())) {

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
					aniadirPromocionComprada(atraccionesUsadas, promocion);
					aniadirPromocionComprada(atraccionesCompradas, promocion);
					restarCupo(atraccionesUsadas, atraccionesCompradas);
					aniadirOfertable(productosComprados, promocion);
				}
				System.out.println("----------------------------------------------");
			}
		}
	}

	void ofrecerAtracciones(Usuario usuario, List<Ofertable> productosComprados) {

		atraccionesUsadas = new ArrayList<Atraccion>();

		List<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>();

		for (Atraccion atraccion : atr) {
			if (compararPrecioAtraccion(usuario, atraccion) >= 0 && compararTiempo(usuario, atraccion) >= 0
					&& verificarCupo(atraccionesUsadas)
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
					aniadirAtraccionesUsadas(atraccionesUsadas, atraccion);

					aniadirAtraccionesUsadas(atraccionesCompradas, atraccion);

					restarCupo(atraccionesUsadas, atraccionesCompradas);
					aniadirOfertable(productosComprados, atraccion);
				}
				System.out.println("----------------------------------------------");
			}
		}
	}

	void aniadirOfertable(List<Ofertable> productosComprados, Ofertable o) {
		productosComprados.add(o);
	}

	private void restarCupo(List<Atraccion> atraccionesUsadas, List<Atraccion> atraccionesCompradas) {
		for (Atraccion atraccion : atraccionesUsadas) {
			if (compararNombresIguales(atraccionesCompradas, atraccion)) {
				atraccion.restarCupo();
			}
		}

	}
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}
}


