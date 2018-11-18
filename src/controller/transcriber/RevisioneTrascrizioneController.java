package controller.transcriber;

import java.sql.ResultSet;

import controller.dao.TrascrizioneDAO;

public class RevisioneTrascrizioneController {

	public static void accettaTrascrizione(int idpagina,int idtrascrizione) {
		
		try {	TrascrizioneDAO.accettaTrascrizione(idpagina,idtrascrizione);
			
		} catch(Exception e) {
			System.out.println(e);
			}
		}

		public static void mettiAnnotazione(int idtrascrizione, String annotazione) {
			try {TrascrizioneDAO.mettiAnnotazione(idtrascrizione,annotazione);
		}catch(Exception e) {
			System.out.println(e);
		}
		}

	public static ResultSet TrascrizioniAnnotazioniUtente(int idutente) {
		
		ResultSet rs=TrascrizioneDAO.TrascrizioniAnnotazioniUtente(idutente);
		return rs;
	}
	
}
