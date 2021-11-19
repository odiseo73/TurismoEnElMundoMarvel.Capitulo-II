package Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.junit.Test;

import dao.AtraccionDAO;
import dao.UsuarioDAO;
import lectorDeArchivos.Parque;

public class TestParque {

	@Test
	public void testLeerArchivos() throws FileNotFoundException, SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		
		Parque parque = new Parque(usuarioDAO,atraccionDAO);
		assertNotNull(parque.getUsuarios());
		assertNotNull(parque.getAtracciones());
	}

}