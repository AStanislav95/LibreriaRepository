package controller.administrator;
import controller.dao.PermessiDAO;
import controller.dao.UtenteDAO;

public class GestioneBackEndController {
	
		public static boolean cambiaruolo(int id, int ruolo) {
			
			//Cambia il ruolo all'utente nel DB 
			//NON lo cambia all'utente attivo. Per avere le modifiche
			//bisognerà riavviare il sistema.
			return PermessiDAO.setRuolo(id,ruolo);
			//Ritorna true se va a buon fine, false altrimenti
			
		}
		
		
		public static boolean aggiungiPermessi(int ruolo, int permesso) {
			
			return PermessiDAO.aggiungiPermessi(ruolo,permesso);

		}
	
		public static boolean rimuoviPermessi(int ruolo, int permesso) {
			return PermessiDAO.rimuoviPermessi(ruolo, permesso);
		}
		
		public static boolean TogliDownload(int IDUtente) {
			
			return PermessiDAO.TogliDownlaod(IDUtente);
		}
		public static boolean AggiungiDownload(int IDUtente) {
			return PermessiDAO.AggiungiDownload(IDUtente);
		}
		
		public static boolean Cambialvltranscriber(int IDUtente, int livello) {
			return PermessiDAO.CambioLivelloTrascrittore(IDUtente,livello);
			
		}
	
}
