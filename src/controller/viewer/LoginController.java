package controller.viewer;
import model.ObjectContenitor;
import model.Utente;
import controller.dao.UtenteDAO;

public class LoginController {

	public static void Login(String nome,String pass) {
	//Controlla se nel DB esiste quell'utente
		Utente u=UtenteDAO.login(nome, pass);
		if(u!=null) {
			//Se esiste, inserisce l'utente come attivo
			ObjectContenitor.utenteAttivo=u;
			
			//Cambia scena (?)
		
	
	}
	}
	
	
}
