package main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import dao.AtraccionDAO;
import dao.UsuarioDAO;
import lectorDeArchivos.Parque;
import usuario.Usuario;

public class Main {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	AtraccionDAO atraccionDAO = new AtraccionDAO();
	
	Parque parque = new Parque(usuarioDAO,atraccionDAO);
	
	}

}
