package main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import dao.AtraccionDAO;
import dao.ItinerarioDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;
import lectorDeArchivos.Parque;
import usuario.Usuario;

public class Main {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	AtraccionDAO atraccionDAO = new AtraccionDAO();
	PromocionDAO promocionDAO = new PromocionDAO(atraccionDAO);
	ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
	
	Parque parque = new Parque(usuarioDAO,atraccionDAO,promocionDAO, itinerarioDAO);
	
	}

}
