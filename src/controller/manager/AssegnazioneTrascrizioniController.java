package controller.manager;

import controller.dao.TrascrizioneDAO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.ObjectContenitor;

public class AssegnazioneTrascrizioniController {
	
	
	public static boolean doesitExist(int IDutente, int IDPagina) throws Exception{
		return TrascrizioneDAO.doesitExist(IDutente,IDPagina);
	}
	
	public static boolean AssegnaTrascrizione(int IDutente,int IDpagina) throws Exception {
	//if((ObjectContenitor.utenteAttivo.getRole())==6|(ObjectContenitor.utenteAttivo.getRole())==7) {
	
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setContentText("Assegnazione confermata.");

		alert.showAndWait();
		
	
		return TrascrizioneDAO.insertAssegnazione(IDutente, IDpagina);
		
	/*}else {
	return false;}
	 da inserire solo se deve essere gestito il fatto che un utente provi a fare un assegnazione;
	 
	
	*/
}
	
	public static boolean TogliTrascrizione(int IDutente, int IDpagina) throws Exception {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setContentText("Assegnazione tolta.");

		alert.showAndWait();
		return TrascrizioneDAO.togliAssegnazione(IDutente, IDpagina);

		
	}
	
	
}