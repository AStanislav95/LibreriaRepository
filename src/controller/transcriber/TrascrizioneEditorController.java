package controller.transcriber;

import controller.dao.PaginaDAO;
import controller.dao.TrascrizioneDAO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.ObjectContenitor;

public class TrascrizioneEditorController {

	public static boolean insertTrascrizione(int idPagina, String text, int idUtente)
			throws Exception {
		//se l'utente attivo è un trascrittore fai questo
		
			// inserisco nel db la trascrizione
			if (text != null && !text.isEmpty()) {
				TrascrizioneDAO.insertTrascrizione(idPagina, text, ObjectContenitor.utenteAttivo.getID());
			return true;
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				
				alert.setContentText("Inserire qualcosa nel campo.");

				alert.showAndWait();
				return false;
			}}
	
	public static boolean collegaTrascrizione(int idManoscritto, int idPagina, String text, int idUtente) {
		int idtra=TrascrizioneDAO.selezionaTrascrizione(idPagina,text,idUtente);
		if (idtra==-1) {
			System.out.println("errore"); 
			return false;
		}
		else {
			int idpag=PaginaDAO.selezionaPagina(idManoscritto,idPagina);
			if (idpag==-1) {
				System.out.println("errore 2");
				return false;
			}		
			else {
				TrascrizioneDAO.collegaPagina(idtra,idpag);
				return true;
			}
		}
	}
	
}
