package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;

import productos.Itinerario;

public class ItinerarioDAO {

	
	public int update(Itinerario itinerario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE ITINERARIO SET productosComprados = ?, horasNecesarias = ?, puntosGastados = ? WHERE USUARIO = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		
		statement.setString(1, itinerario.getProductos());
		statement.setDouble(2, itinerario.getHorasNecesarias());
		statement.setDouble(3, itinerario.getPuntos());
		statement.setString(4, itinerario.getUsuario());
		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	public List<Itinerario> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM itinerario";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<Itinerario> lista = new LinkedList<Itinerario>();

		while (result.next()) {
			lista.add(toItinerario(result));
		}

		return lista;

	}
	private Itinerario toItinerario(ResultSet result) throws SQLException {
		
		String usuario = result.getString("usuario");
		String productos = result.getString("productosComprados");
		Double horasNecesarias = result.getDouble("horasNecesarias");	
		Double puntos = result.getDouble("puntosGastados");

		return new Itinerario(usuario, productos, horasNecesarias, puntos);
	}
}
