package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.ConnectionProvider;

import productos.Itinerario;

public class ItinerarioDAO {
public int insert(Itinerario itinerario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO ITINERARIO (usuario, productosComprados, horasNecesarias, puntos) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, itinerario.getUsuario());
		statement.setString(2, itinerario.getProductos());
		statement.setDouble(3, itinerario.getHorasNecesarias());
		statement.setDouble(4, itinerario.getPuntos());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	public int update(Itinerario itinerario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE ITINERARIO SET productosComprados = ?, horasNecesarias = ?, puntos = ? WHERE USUARIO = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, itinerario.getUsuario());
		statement.setString(2, itinerario.getProductos());
		statement.setDouble(3, itinerario.getHorasNecesarias());
		statement.setDouble(4, itinerario.getPuntos());
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
		Double puntos = result.getDouble("puntos");

		return new Itinerario(usuario, productos, horasNecesarias, puntos);
	}
}
