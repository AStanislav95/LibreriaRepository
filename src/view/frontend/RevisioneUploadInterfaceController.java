package view.frontend;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class RevisioneUploadInterfaceController implements Initializable {
	static int idManoscritto;
	static int idPagina;
	@FXML
	private Button homepage;
	@FXML
	private Button accetta;
	@FXML
	private Button rifiuta;
	@FXML
	private Button profile;
	@FXML
	private TableView dbtable;
	@FXML
	private ListView titolo;
	@FXML
	private ListView pagina;
	@FXML
	private ImageView img;

	@FXML
	private void homepage(ActionEvent e) throws Exception {
		Stage stage = (Stage) homepage.getScene().getWindow(); //Source Stage!!
		Parent homepage = FXMLLoader.load(getClass().getResource("/view/GUI/Homepage.fxml"));

		Scene scene = new Scene(homepage);
		stage.setTitle("Homepage");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void decisione(ActionEvent e) throws Exception {

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

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}