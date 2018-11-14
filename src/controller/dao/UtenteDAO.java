package controller.dao;
import model.Utente;
import controller.dao.ConnectionDAO;
import java.sql.*;

public class UtenteDAO {
	static Connection conn;

	
	
	public static boolean register(Utente u) {
	try{
		conn=ConnectionDAO.getConnection();
		Statement stmt=conn.createStatement();
		String email=u.getEmail();
		String nome=u.getName();
		String password=u.getPassword();
		String titolodistudio=u.getQualification();
		String professione=u.getProfession();
		int ruolo=u.getRole();
		stmt.executeUpdate("insert into utente(Email,Nome,Password,TitoloDiStudio,"
				+ "Professione,Ruolo) values ('" + email +"','"+ nome +"','" + password +"','" + titolodistudio
				+"','"+ professione +"',"+ ruolo +");");
		return true;
		
	}catch(Exception e) {System.out.println(e); return false;}}
	
	
	
	public static Utente login(String nome, String pass) {
		try {	
			//Vede se l'utente esiste
		conn=ConnectionDAO.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs;
		Utente u=null;
		rs=stmt.executeQuery("select * from utente where Nome='"+nome+ "'and Password= '"+pass+"';");
		if (!(rs.next())){//ResultSet is empty
			System.out.println("Accesso Negato");
			conn.close();
			return u;
		}
		//Costruisce l'utente se esiste
		else {System.out.println("Accesso concesso");
		u=new Utente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
				rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),
				rs.getInt(10));
		conn.close();
		return u;
		
		
		
		}
		
		
		}catch(Exception e) {System.out.println(e);  
		Utente u=new Utente(); 
		return u;}}
		
	public static boolean setRichiesta(int val, int id) {
		try {
			conn=ConnectionDAO.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("update utente set RichiestaTrascrittore= "+ val
					+ " where ID= " + id);
			return true;
		}catch(Exception e) {System.out.println(e); return false;}
		
	}
	
	
	public static boolean setRuolo(int id, int ruolo) {
		try {
			conn=ConnectionDAO.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("update utente set Ruolo="+ruolo+" where ID="+id);
			return true;
		}catch(Exception e) {System.out.println(e); return false;}
		
		
	}
	
	public static boolean aggiungiPermessi(int ruolo, int permesso) {
		try {
			conn=ConnectionDAO.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("insert into consente values ("+ruolo + "," +permesso +")");
			return true;
		}catch(Exception e) {System.out.println(e); return false;}
	}
	
	public static boolean rimuoviPermessi(int ruolo, int permesso) {
		try {
			conn=ConnectionDAO.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("delete from consente where IDRuolo="+ruolo+" and IDPermessi="+permesso+";");
			return true;
		}catch(Exception e) {System.out.println(e); return false;}
	}
	
	public static boolean AumentoLivelloTrascrittore(int IDutente) throws Exception {
		conn=ConnectionDAO.getConnection();
		Statement stmt=conn.createStatement();
		stmt.executeUpdate("update utente set LivelloTrascrittore=LivelloTrascrittore+1 where ID="+IDutente+";");
		//segnalare che scritta così  l'applicazione è soggetta a injection e quindi a manipolazione troppo facile della query nel metodo
		return true;
	}
	public static boolean DiminuzioneLivelloTrascrittore(int IDutente) throws Exception {
		conn=ConnectionDAO.getConnection();
		Statement stmt=conn.createStatement();
		stmt.executeUpdate("update utente set LivelloTrascrittore=LivelloTrascrittore-1 where ID="+IDutente+";");
		return true;
		
		
	}
	public static boolean CambioLivelloTrascrittore(int IDutente, int livello) throws Exception {
		conn=ConnectionDAO.getConnection();
		Statement stmt=conn.createStatement();
		stmt.executeUpdate("update utente set LivelloTrascrittore="+livello+" where IDRuolo="+IDutente+";");
		return true;
	}
	
	
	}
	
	
		