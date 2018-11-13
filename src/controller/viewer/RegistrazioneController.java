package controller.viewer;

import controller.dao.UtenteDAO;
import model.Utente;
import model.ObjectContenitor;

public class RegistrazioneController {

	public static void register(String email, String nome, String pass, String qualif, String prof) {

		// Crea un nuovo utente
		Utente u = new Utente();
		u.setName(nome);
		u.setEmail(email);
		u.setPassword(pass);
		u.setQualification(qualif);
		u.setProfession(prof);
		u.setRole(1);
		u.setRequestTrascriber(0);
		u.setCanDownload(0);

		// Lo passa alla sessione attiva
		ObjectContenitor.utenteAttivo = u;

		// Inserisce i dati nel DB
		UtenteDAO.register(u);

	}

	public static void register(String email, String nome, String pass) {

		// Crea un nuovo utente
		Utente u = new Utente();
		u.setName(nome);
		u.setEmail(email);
		u.setPassword(pass);
		u.setQualification("sconosciuto");
		u.setProfession("sconosciuto");
		u.setRole(1);
		u.setRequestTrascriber(0);
		u.setCanDownload(0);

		// Lo passa alla sessione attiva
		ObjectContenitor.utenteAttivo = u;

		// Inserisce i dati nel DB
		UtenteDAO.register(u);

	}
}
