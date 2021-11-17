package lectorDeArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import productos.Atraccion;
import productos.Promocion;
import productos.PromocionAbsoluta;
import productos.PromocionAxB;
import productos.PromocionPorcentual;
import usuario.Usuario;

public class Lector {

	private List<Usuario> usuarios;
	private Map<String, Atraccion> atracciones;
	private List<Promocion> promociones;
// acordarse eliminar atr
	private List<Atraccion> atr;

	public Lector(String archivo, String archivo2, String archivo3) throws FileNotFoundException {
		setUsuarios(archivo);
		setAtracciones(archivo2);
		setPromociones(archivo3);

	}

	public void setUsuarios(String archivo) throws FileNotFoundException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea = br.readLine();

			usuarios = new ArrayList<Usuario>();

			while (linea != null) {
				String[] datos = linea.split(",");
				String nombre = datos[0];
				int dinero = Integer.parseInt(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				Usuario u = new Usuario(nombre, dinero, tiempo);
				usuarios.add(u);
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setAtracciones(String archivo2) throws FileNotFoundException {
		atracciones = new HashMap<String, Atraccion>();
		atr = new ArrayList<Atraccion>();

		Scanner sc = new Scanner(new File(archivo2));
		while (sc.hasNext()) {
			String[] datos = sc.nextLine().split(",");
			String nombre = datos[0];
			int precio = Integer.parseInt(datos[1]);
			double tiempoEnHoras = Double.parseDouble(datos[2]);
			int cupo = Integer.parseInt(datos[3]);
			Atraccion a = new Atraccion(nombre, precio, tiempoEnHoras, cupo);

			atracciones.put(nombre, a);
			atr.add(a);
		}
		sc.close();
	}

	public void setPromociones(String archivo3) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(archivo3));
		promociones = new ArrayList<Promocion>();

		while (sc.hasNext()) {
			String[] datos = sc.nextLine().split(",");
			String nombre = datos[0];
			String tipo = datos[1];
			int descuento = Integer.parseInt(datos[2]);
			ArrayList<Atraccion> atr = new ArrayList<Atraccion>();
			for (int i = 3; i < datos.length; i++) {
				if (atracciones.containsKey(datos[i])) {
					atr.add(atracciones.get(datos[i]));
				}
			}

			if (tipo.equals("porcentual")) {
				Promocion por = new PromocionPorcentual(nombre, descuento, atr);
				promociones.add(por);
			}

			if (tipo.equals("absoluta")) {
				Promocion abs = new PromocionAbsoluta(nombre, descuento, atr);
				promociones.add(abs);
			}
			if (tipo.equals("axb")) {
				Promocion axb = new PromocionAxB(nombre, atr);
				promociones.add(axb);
			}

		}
		sc.close();
	}

}
