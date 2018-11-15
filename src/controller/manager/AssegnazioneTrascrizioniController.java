package controller.manager;

import controller.dao.TrascrizioneDAO;
import model.ObjectContenitor;

public class AssegnazioneTrascrizioniController {
	
	
	public static boolean doesitExist(int IDutente, int IDPagina) throws Exception{
		return TrascrizioneDAO.doesitExist(IDutente,IDPagina);
	}
	
	public static boolean AssegnaTrascrizione(int IDutente,int IDpagina) throws Exception {
	//if((ObjectContenitor.utenteAttivo.getRole())==6|(ObjectContenitor.utenteAttivo.getRole())==7) {
		
		return TrascrizioneDAO.insertAssegnazione(IDutente, IDpagina);
		
	/*}else {
	return false;}
	 da inserire solo se deve essere gestito il fatto che un utente provi a fare un assegnazione;
	 
	
	*/
}
	
	public static boolean TogliTrascrizione(int IDutente, int IDpagina) throws Exception {
		
		return TrascrizioneDAO.togliAssegnazione(IDutente, IDpagina);

		
	}
	
	
}