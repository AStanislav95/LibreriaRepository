package controller.administrator;
import controller.dao.UtenteDAO;

public class GestioneBackEndController {
	
		public static boolean cambiaruolo(int id, int ruolo) {
			
			//Cambia il ruolo all'utente nel DB 
			//NON lo cambia all'utente attivo. Per avere le modifiche
			//bisognerà riavviare il sistema.
			return UtenteDAO.setRuolo(id,ruolo);
			//Ritorna true se va a buon fine, false altrimenti
			
		}
		
		
		public static boolean aggiungiPermessi(int ruolo, int permesso) {
			
			return UtenteDAO.aggiungiPermessi(ruolo,permesso);

		}
	
		public static boolean rimuoviPermessi(int ruolo, int permesso) {
			return UtenteDAO.rimuoviPermessi(ruolo, permesso);
		}
	
}
