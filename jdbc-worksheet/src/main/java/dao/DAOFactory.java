package dao;

public class DAOFactory {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOimpl();

	}
	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOimpl();
	}
	
}
