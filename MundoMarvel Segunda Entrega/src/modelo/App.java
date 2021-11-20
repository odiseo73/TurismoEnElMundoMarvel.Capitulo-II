package modelo;
import java.sql.SQLException;
import java.util.List;

public class App {

	public static void main(String[] args) throws SQLException {
		UserDAO dao = new UserDAO();

		List<User> xx = dao.findAll();
		System.out.println(xx);

		User leo = dao.findByUsername("leo").get(0);
		
		leo.setPassword("contraseña");
		
		dao.update(leo);
		
		
		xx = dao.findAll();
		for (User user : xx) {
			System.out.println(user);
		}
		

		ConnectionProvider.close();

	}

}
