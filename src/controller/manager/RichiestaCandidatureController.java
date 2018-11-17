package controller.manager;

import controller.dao.PermessiDAO;

public class RichiestaCandidatureController {
	
	public static boolean Accetta_RifiutaRichiesta(int val, int id) {
		return PermessiDAO.setRichiesta(val, id);
	}
	
	public static boolean RichiestaAccettata(int id) {
		return PermessiDAO.AccettaRichiesta(id);
		
	}
}
