package controller.viewer;
import controller.dao.UtenteDAO;
import model.ObjectContenitor;

public class CandidarsiComeTrascrittoriController {

	public static boolean candidatura() {
	if ((ObjectContenitor.utenteAttivo.getPermessi()).getRequestTrascriber()==0)
	{ 	//Lo setta nell'utente attivo
		(ObjectContenitor.utenteAttivo.getPermessi()).setRequestTrascriber(1);
	
	//Fa la modifica sul DB
	UtenteDAO.setRichiesta(1,ObjectContenitor.utenteAttivo.getID());
	
	return true;
		
	}
	return false;
	}
	
	
}
