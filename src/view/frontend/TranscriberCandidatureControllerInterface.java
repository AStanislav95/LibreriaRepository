package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TranscriberCandidatureControllerInterface implements Initializable {
	@FXML
	private Button accept;
	@FXML
	private Button decline;
	@FXML
	private TableView dbtable;
	@FXML
	private Button adminInterface;
	@FXML
	private Button homepage;
	@FXML
	private TextField utente;

	@FXML
	public void buildData(String SQL) {

	}

	@FXML
	private void candidature(ActionEvent e) throws Exception {

	}
	
	@FXML
	private void adminInterface(ActionEvent e) throws IOException {
		Stage stage = (Stage) adminInterface.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/AdminInterface1.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Profile");
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML
	private void homepage(ActionEvent e) throws Exception {
		Stage stage = (Stage) homepage.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Homepage.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Profile");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}