package controller.viewer;
import controller.dao.UtenteDAO;
import controller.viewer.LoginController;
import model.Utente;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrazioneController {

	private void register(Utente u) {
		
		UtenteDAO.register(u);
		
		
		 
		}
	}

