package controller.viewer;
import controller.dao.PermessiDAO;
import controller.dao.UtenteDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.ObjectContenitor;

public class CandidarsiComeTrascrittoriController {

	public static boolean candidatura() {
	if ((ObjectContenitor.utenteAttivo.getPermessi()).getRequestTrascriber()==0)
	{ 	//Lo setta nell'utente attivo
		(ObjectContenitor.utenteAttivo.getPermessi()).setRequestTrascriber(1);
	
	//Fa la modifica sul DB
	PermessiDAO.setRichiesta(1,ObjectContenitor.utenteAttivo.getID());
	ObjectContenitor.utenteAttivo.getPermessi().setRequestTrascriber(1);
	return true;
		
	}
	
	Alert alert = new Alert(AlertType.ERROR);
	
	alert.setContentText("Hai già fatto richiesta.");

	alert.showAndWait();
	
	return false;
	}
	
	
}
