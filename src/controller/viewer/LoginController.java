package controller.viewer;
import model.Utente;
import controller.dao.UtenteDAO;

public class LoginController {

	public static boolean Login() {
		
		Utente ut=UtenteDAO.login();
		if (ut!=null) {
		//Cambia scena
		}
		//else alert
	}
	
	
}
