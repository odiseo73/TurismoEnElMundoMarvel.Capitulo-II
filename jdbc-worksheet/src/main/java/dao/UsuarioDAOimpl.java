package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import usuario.Usuario;

public class UsuarioDAOimpl implements UsuarioDAO {

	
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

		List<Usuario> todos = new LinkedList<Usuario>();

		while (result.next()) {
			todos.add(toUser(result));
		}

		return todos;

	}

	public List<Usuario> findByUsername(String pepito) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USUARIOS WHERE USERNAME = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, pepito);

		ResultSet result = statement.executeQuery();

		List<Usuario> todos = new LinkedList<Usuario>();

		while (result.next()) {
			todos.add(toUser(result));
		}

		return todos;

	}
	
	public List<Usuario> findByUsernameLike(String username) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USUARIOS WHERE USERNAME LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%" + username + "%");

		ResultSet result = statement.executeQuery();

		List<Usuario> todos = new LinkedList<Usuario>();

		while (result.next()) {
			todos.add(toUser(result));
		}

		return todos;

	}

	private Usuario toUser(ResultSet result) throws SQLException {
		Integer id = result.getInt("id");
		String nombre = result.getString("nombre");
		Double dinero = result.getDouble("dinero");
		Double tiempo = result.getDouble("tiempo");
		

		return new Usuario(id,nombre, dinero, tiempo);
	}


}
