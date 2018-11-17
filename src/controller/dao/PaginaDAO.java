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
	
	public static ResultSet getPagesTrascrizione(int idManoscritto) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery("select p.id,p.numero,p.manoscritto,p.scanpath, t.testo from pagina p, trascrizione t where p.trascrizione=t.id and p.manoscritto=" +idManoscritto);
		
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
	 
	 public static ResultSet listaScan() throws Exception {
		 
		 Connection con = ConnectionDAO.getConnection();
		 Statement stm = con.createStatement();
		 ResultSet listaScan = stm.executeQuery("select ID,Scanpath from pagina where Accettato = 0");
		 
		 return listaScan;
	 }
	 
	public static boolean accettaScan(int id) {
		
		Connection con;
		try {
			con = ConnectionDAO.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("update pagina Set Accettato = 1 where id = "+ id);
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean rifiutaScan(int id) {
		
		try {
			Connection con = ConnectionDAO.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("delete from pagina where ID = "+ id + ";");
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean isEmpty(int id) {
		try {			Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		
		return true;
		} catch (Exception e) {
			System.out.println(e); return false;
			
		}
	}
	
	public static int selezionaPagina(int numpag,int idman) {
		try {
			Connection con = ConnectionDAO.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs=stm.executeQuery("select id from pagina where numero=" + numpag + " and manoscritto= "+idman);
			rs.next();
			return rs.getInt(1);
		} 
		catch (Exception e) {
			System.out.println(e); 
			return -1;
		}
	}
}
