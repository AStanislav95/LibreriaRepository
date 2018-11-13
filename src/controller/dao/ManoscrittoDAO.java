package controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManoscrittoDAO {

	
	public static boolean insertManoscritto(int pubblicazione, int anno, int secolo, String titolo, String autore, String genere) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		String str = "INSERT INTO Manoscritto(Pubblicazione,Anno,Secolo,Titolo,Autore,Genere) "
				+ "values ("+ pubblicazione+ "," + anno +"," + secolo +","+ "'" + titolo +"'," + "'" + autore + "'," + "'" + genere + "');";
		System.out.println(str);
		stm.executeQuery("INSERT INTO Manoscritto(Pubblicazione,Anno,Secolo,Titolo,Autore,Genere) "
				+ "values ("+ pubblicazione+ "," + anno +"," + secolo +","+ "'" + titolo +"'," + "'" + autore + "'," + "'" + genere + "');");
		return true;
	}

	
	
	public static ResultSet getManoscritti() throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM manoscritto");
		return rs;
	}
}
