package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import productos.Atraccion;


public class AtraccionDAO implements GenericDAO<Atraccion> {

public int update(Atraccion atraccion) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE ATRACCIONES SET PRECIO = ?,TIEMPOENHORAS = ?, CUPODISPONIBLE = ? WHERE ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, atraccion.getId());
		//statement.setString(2, user.getNombre());
		statement.setDouble(3, atraccion.getPrecio());
		statement.setDouble(4, atraccion.getCupoDisponible());
		statement.setDouble(5, atraccion.getTiempoEnHoras());
		
		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	public List<Atraccion> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM ATRACCIONES";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<Atraccion> atracciones = new LinkedList<Atraccion>();

		while (result.next()) {
			atracciones.add(toAtraccion(result));
		}

		return atracciones;

	}


	private Atraccion toAtraccion(ResultSet result) throws SQLException {
		Integer id = result.getInt("id_atracciones");
		
		String nombre = result.getString("nombre");
		Integer precio = result.getInt("precio");
		Integer cupo = 	result.getInt("cupoDisponible");	
		Double tiempo = result.getDouble("tiempoEnHoras");
	
		return new Atraccion(id,nombre, precio, tiempo, cupo);
	}

	

}
