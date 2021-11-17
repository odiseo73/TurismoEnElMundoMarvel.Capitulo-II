package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {

	public int insert(User user) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	public int update(User user) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getPassword());
		statement.setString(2, user.getUsername());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	
	public int delete(User user) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM USERS WHERE USERNAME = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
	
	public List<User> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USERS";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<User> todos = new LinkedList<User>();

		while (result.next()) {
			todos.add(toUser(result));
		}

		return todos;

	}

	public List<User> findByUsername(String pepito) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, pepito);

		ResultSet result = statement.executeQuery();

		List<User> todos = new LinkedList<User>();

		while (result.next()) {
			todos.add(toUser(result));
		}

		return todos;

	}
	
	public List<User> findByUsernameLike(String username) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%" + username + "%");

		ResultSet result = statement.executeQuery();

		List<User> todos = new LinkedList<User>();

		while (result.next()) {
			todos.add(toUser(result));
		}

		return todos;

	}

	private User toUser(ResultSet result) throws SQLException {
		String username = result.getString("username");
		String password = result.getString("password");

		return new User(username, password);
	}

}
