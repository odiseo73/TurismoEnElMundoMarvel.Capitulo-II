package dao;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import usuario.Usuario;

public class App {

	public static void main(String[] args) throws SQLException {
		UsuarioDAOimpl dao = new UsuarioDAOimpl();

		List<Usuario> xx = dao.findAll();
		System.out.println(xx);

		Usuario leo = dao.findByUsername("leo").get(0);
		
		dao.update(leo);
		
		
		xx = dao.findAll();
		for (Usuario user : xx) {
			System.out.println(user);
		}
		

		ConnectionProvider.close();

	}

}
