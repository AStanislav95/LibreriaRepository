package view.frontend;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdminInterfaceController implements Initializable {
	@FXML
	private Button homepage;
	@FXML
	private Button changerole;
	@FXML
	private Button profile;
	@FXML
	private Button changetranscriber;
	@FXML
	private TableView dbtable;
	@FXML
	private Button back;
	@FXML
	private TextField utente;
	@FXML
	private TextField ruolo;
	@FXML
	private TextField lvt;
	@FXML
	private Button ruolo1;
	@FXML
	private Button ruolo2;
	@FXML
	private Button ruolo3;
	@FXML
	private Button ruolo4;
	@FXML
	private Button ruolo5;
	@FXML
	private Button ruolo6;
	@FXML
	private Button ruolo7;
	@FXML
	private Button cd0;
	@FXML
	private Button cd1;
	@FXML
	private Button interfacciacandidatura;



	@FXML
	public void buildData(String SQL) {

	}

	@FXML
	private void back(ActionEvent e) throws Exception {

	}

	@FXML
	private void changerole(ActionEvent e) throws Exception {

	}

	@FXML
	private void changelvtranscriber(ActionEvent e) throws Exception {

	}

	@FXML
	private void elencoruoli(ActionEvent e) throws Exception {

	}

	@FXML
	private void canDownload(ActionEvent e) throws Exception {

	}

	@FXML
	private void profile(ActionEvent e) throws Exception {

	}

	@FXML
	private void interfacciacandidatura(ActionEvent e) throws Exception {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
