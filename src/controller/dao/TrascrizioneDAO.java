package controller.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrascrizioneDAO {
	
	
	public static ResultSet getTrascrizioni() throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM Trascrizione");
		return rs;
	}
	
	
	public static boolean insertTrascrizione(int numPag, String text, int IDUtente) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeQuery("INSERT INTO Trascrizione(Pagina, Testo, IDUtente) values ("+ numPag + ",'" + text + "'," + IDUtente + ");" );
		return true;
	}
	
	
}
