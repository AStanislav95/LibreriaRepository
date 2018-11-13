package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaginaDAO {
	


	
	public static ResultSet listPage() throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from Pagina");
		
		return rs;
	}

	 public static boolean uploadPage(int numero, int manoscritto,String scanPath) {
			try {
			 
			    Connection con = ConnectionDAO.getConnection();
			    Statement stm = con.createStatement();
			    stm.executeUpdate("insert into Page (Numero, Manoscritto, Scanpath, Trascrizione) "
				    + "values(" + numero + "," + manoscritto +"," + "'" + scanPath + "'" + ",\"Trascrizione non disponibile\")");
			   System.out.println("insert into Page (Numero, Manoscritto, Scanpath, Trascrizione) "
					    + "values(" + numero + "," + manoscritto +"," + "'" + scanPath + "'" + ",\"Trascrizione non disponibile\")");
			    return true;
			} catch (Exception e) {
			    System.out.println(e.getMessage());
			    return false;
			}
		}
	
}
