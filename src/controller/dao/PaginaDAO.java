package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaginaDAO {
	
	
	public static ResultSet listPage() throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from pagina");
		
		return rs;
	}
	
	public static ResultSet getPages(int idManoscritto) throws Exception {
		
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from pagina where Manoscritto =" + idManoscritto+ ";");
		
		return rs;
	}
	

	 public static boolean uploadPage(int numero, int manoscritto,String scanPath) {
			try {
			 
			    Connection con = ConnectionDAO.getConnection();
			    Statement stm = con.createStatement();
			    stm.executeUpdate("insert into pagina (Numero, Manoscritto, Scanpath) "
				    + "values(" + numero + "," + manoscritto +"," + "'" + scanPath + "');");

			    return true;
			} catch (Exception e) {
			    System.out.println(e.getMessage());
			    return false;
			}
		}
	
}
