package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import usuario.Usuario;

public class UsuarioDAO implements GenericDAO<Usuario> {

	
	public int update(Usuario user) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE USUARIOS SET DINERO = ?,TIEMPODISPONIBLE = ? WHERE ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, user.getId());
		//statement.setString(2, user.getNombre());
		statement.setDouble(3, user.getDinero());
		statement.setDouble(4, user.getTiempoEnHoras());
		
		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	
	
	public List<Usuario> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USUARIOS";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<Usuario> usuarios = new LinkedList<Usuario>();

		while (result.next()) {
			usuarios.add(toUser(result));
		}

		return usuarios;

	}
	/*
	public int countAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USUARIOS";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		int s = 0;

		while (result.next()) {
			s += 1;
		}

		return s;

	}
	*/
	

	private Usuario toUser(ResultSet result) throws SQLException {
		Integer id = result.getInt("id_usuarios");
	
		String nombre = result.getString("nombre");
		Double dinero = result.getDouble("dinero");
		Double tiempo = result.getDouble("tiempoDisponible");
		

		return new Usuario(id,nombre, dinero, tiempo);
	}


}
