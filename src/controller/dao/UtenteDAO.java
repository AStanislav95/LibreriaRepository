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
		
	}catch(Exception e) {System.out.println(e); return false;}
	
		
	
}}
