package controller.viewer;

import model.ObjectContenitor;
import model.Utente;
import controller.dao.UtenteDAO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

	public static boolean Login(String nome, String pass) {
		// Controlla se nel DB esiste quell'utente
		Utente u = UtenteDAO.login(nome, pass);
		if (u != null) {
			// Se esiste, inserisce l'utente come attivo
			ObjectContenitor.utenteAttivo = u;
			// Cambia scena (?) -->in LoginInterfaceController cambio scena
			return true;

		}
		return false;
	}

}
