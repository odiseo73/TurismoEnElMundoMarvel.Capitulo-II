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

public int insert(Usuario user) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getNombre());
		statement.setDouble(2, user.getDinero());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	public int update(Usuario user) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getNombre());
		statement.setDouble(2, user.getDinero());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	
	public int delete(Usuario user) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM USERS WHERE USERNAME = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getNombre());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	
	public List<Usuario> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USERS";
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
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
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
		String sql = "SELECT * FROM USERS WHERE USERNAME LIKE ?";
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
		String nombre = result.getString("nombre");
		Double dinero = result.getDouble("dinero");
		Double tiempo = result.getDouble("tiempo");
		

		return new Usuario(nombre, dinero, tiempo);
	}


}
