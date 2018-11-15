package view.frontend;

import controller.manager.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GestioneAssegnazioniInterfaceController implements Initializable {
	@FXML
	private Button homepage;
	@FXML
	private Button confirm;
	@FXML
	private Button profile;
	@FXML
	private TableView dbtable;
	@FXML
	private TableView dbtable1;
	@FXML
	private Button back;
	@FXML
	private TextField utente;
	@FXML
	private TextField IDpage;


	public void buildData(String SQL, TableView dbtable) {

	}

	@FXML
	private void homepage(ActionEvent e) throws Exception {
		Stage stage = (Stage) homepage.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Homepage.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Homepage");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void confirm(ActionEvent e) throws Exception {
		
		int idutente=Integer.parseInt(utente.getText());
	    int idpagina=Integer.parseInt(IDpage.getText());
	
			 if (AssegnazioneTrascrizioniController.doesitExist(idutente,idpagina))
			 { AssegnazioneTrascrizioniController.TogliTrascrizione(idutente,idpagina);}
			 else { AssegnazioneTrascrizioniController.AssegnaTrascrizione(idutente,idpagina);}
					
	}

	@FXML
	private void profile(ActionEvent e) throws Exception {
		Stage stage = (Stage) profile.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Profile.fxml"));

		Scene scene = new Scene(parent, 500, 400);
		stage.setTitle("Profile");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}