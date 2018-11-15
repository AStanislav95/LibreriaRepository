package controller.viewer;

import controller.dao.UtenteDAO;
import model.Utente;
import model.ObjectContenitor;
import model.Permessi;

public class RegistrazioneController {

	public static boolean register(String nome, String email, String pass, String qualif, String prof) {
		Permessi p= new Permessi();
		// Crea un nuovo utente
		
		
		Utente u = new Utente(nome,email,pass,qualif,prof,p);
		
		
		// Lo passa alla sessione attiva
		ObjectContenitor.utenteAttivo = u;

		
		return UtenteDAO.register(u);
		

	}

	public static void register(String email, String nome, String pass) {
		String s="Sconosciuto";
		// Crea un nuovo utente
		
		Permessi p= new Permessi();
		Utente u= new Utente(email,nome,pass,s,s,p);
	
		

		// Lo passa alla sessione attiva
		ObjectContenitor.utenteAttivo = u;

		// Inserisce i dati nel DB
		UtenteDAO.register(u);

	}
}
