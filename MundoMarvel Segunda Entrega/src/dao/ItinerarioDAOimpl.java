package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.ConnectionProvider;

import productos.Itinerario;

public class ItinerarioDAOimpl {
public int insert(Itinerario itinerario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO ITINERARIO (ID, usuarios, productos, horasNecesarias, puntos) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, itinerario.getId());
		statement.setString(2, itinerario.getUsuarios());
		statement.setString(3, itinerario.getProductos());
		statement.setDouble(4, itinerario.getHorasNecesarias());
		statement.setDouble(5, itinerario.getPuntos());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	public int update(Itinerario itinerario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE ITINERARIO SET usuarios = ?, productos = ?, horasNecesarias = ?, puntos = ? WHERE ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, itinerario.getId());
		statement.setString(2, itinerario.getUsuarios());
		statement.setString(3, itinerario.getProductos());
		statement.setDouble(4, itinerario.getHorasNecesarias());
		statement.setDouble(5, itinerario.getPuntos());
		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	public List<Itinerario> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM ITINERARIO";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<Itinerario> todos = new LinkedList<Itinerario>();

		while (result.next()) {
			todos.add(toItinerario(result));
		}

		return todos;

	}
	private Itinerario toItinerario(ResultSet result) throws SQLException {
		Integer id = result.getInt("id");
		String usuarios = result.getString("usuarios");
		String productos = result.getString("usuarios");
		Double horasNecesarias = result.getDouble("usuarios");	
		Double puntos = result.getDouble("usuarios");

		return new Itinerario(id, usuarios, productos, horasNecesarias, puntos);
	}
}
