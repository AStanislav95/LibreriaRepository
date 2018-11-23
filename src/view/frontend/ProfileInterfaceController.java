package view.frontend;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import controller.viewer.CandidarsiComeTrascrittoriController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.ObjectContenitor;

public class ProfileInterfaceController implements Initializable {

	@FXML
	private Button Homepage;
	@FXML
	private Button transcriber;
	@FXML
	private Label name;
	@FXML
	private Label email;
	@FXML
	private Label password;
	@FXML
	private Label profession;
	@FXML
	private Label qualification;
	@FXML
	private Button AdminInterface1;
	@FXML
	private Button Candidate;

	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}


	
	@FXML
	private void candidate(ActionEvent e) throws Exception {
		
		CandidarsiComeTrascrittoriController.candidatura();
		
	}

	@FXML
	private void Adminpage(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		name.setText(ObjectContenitor.utenteAttivo.getName());
		email.setText(ObjectContenitor.utenteAttivo.getEmail());
		password.setText(ObjectContenitor.utenteAttivo.getPassword());
		profession.setText(ObjectContenitor.utenteAttivo.getProfession());
		qualification.setText(ObjectContenitor.utenteAttivo.getQualification());
		
		
		
	}

}