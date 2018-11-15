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
	
	
	public static boolean insertAssegnazione(int IDutente, int IDpagina) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("INSERT INTO Assegnazione(IDUtente, IDPagina)  values ( "+ IDutente + ", "+ IDpagina+ ");" );
		return true;
		
	}
	
	public static boolean togliAssegnazione(int IDutente,int IDpagina) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("delete from assegnazione where IDUtente="+ IDutente + " and IDPagina="+ IDpagina+ ";" );
		con.close();
		return true;
	}
	
	public static boolean doesitExist(int IDutente,int IDpagina) throws Exception{
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs=stm.executeQuery("select * from assegnazione where IDUtente="+ IDutente + " and IDPagina=" + IDpagina);
		if(rs.next()) {return true;}
		else return false;
	}
}
