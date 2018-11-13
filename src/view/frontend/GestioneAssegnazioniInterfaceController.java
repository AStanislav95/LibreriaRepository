package view.frontend;

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

	}

	@FXML
	private void confirm(ActionEvent e) throws Exception {

	}

	@FXML
	private void profile(ActionEvent e) throws Exception {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}