package controller.viewer;
import controller.dao.UtenteDAO;
import controller.viewer.LoginController;
import model.ObjectContenitor;
import model.Utente;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrazioneController {

	public static void register(String email, String nome, String pass, String qualif, String prof)
			 {
		
		//Crea un nuovo utente
		Utente u=new Utente();
		u.setName(nome);
		u.setEmail(email);
		u.setPassword(pass);
		u.setQualification(qualif);
		u.setProfession(prof);
		u.setRole(1);
		u.setRequestTrascriber(0);
		u.setCanDownload(0);
		
		//Lo passa alla sessione attiva
		ObjectContenitor.utenteAttivo=u;
		
		
		//Inserisce i dati nel DB
		UtenteDAO.register(u);
		
		
		 
		}
	}

