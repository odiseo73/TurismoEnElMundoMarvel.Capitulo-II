package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import productos.Atraccion;
import productos.Promocion;
import productos.PromocionAbsoluta;
import productos.PromocionAxB;
import productos.PromocionPorcentual;


public class PromocionDAO implements GenericDAO<Promocion> {

	private AtraccionDAO atraccionDAO;

	public PromocionDAO(AtraccionDAO atraccionDAO) {
		this.atraccionDAO = atraccionDAO;
	}

	public List<Promocion> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM PROMOCIONES";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<Promocion> promocion = new LinkedList<Promocion>();

		while (result.next()) {
			promocion.add(toPromocion(result));
		}

		return promocion;

	}

	private Promocion toPromocion(ResultSet result) throws SQLException {

		List<Atraccion> atracciones = this.atraccionDAO.findAll();
		Promocion prom = null;
		List<Atraccion> atr = new ArrayList<Atraccion>();

		Integer id = result.getInt("id_promociones");
		String nombre = result.getString("nombre");
		String[] lista = result.getString("listaAtracciones").split(",");
		String tipo = result.getString("tipo");
		Integer descuento = result.getInt("descuento");

		for (Atraccion atraccion : atracciones) {
			for (String nombreAtraccion : lista) {
				if (atraccion.getNombre().equals(nombreAtraccion)) {
					atr.add(atraccion);
				}
			}
		}
		if (tipo.equals("porcentual")) {
			prom = new PromocionPorcentual(id,nombre, descuento, atr);
		}

		if (tipo.equals("absoluta")) {
			prom = new PromocionAbsoluta(id,nombre, descuento, atr);

		}
		if (tipo.equals("axb")) {
			prom = new PromocionAxB(id,nombre,atr);
		}
		return prom;
	}
}
