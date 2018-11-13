package view.frontend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TranscriberInterfaceController implements Initializable {

	static int idManoscritto;
	static int idPagina;
	@FXML
	private Button back;
	@FXML
	private Button submit;
	@FXML
	private TextArea textArea;
	@FXML
	private ListView manoscritto;
	@FXML
	private ListView pagina;
	@FXML
	private ImageView img;

	@FXML
	private void back(ActionEvent e) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow(); //Source Stage!!
		Parent homepage = FXMLLoader.load(getClass().getResource("/Interface/Homepage.fxml"));

		Scene scene = new Scene(homepage);
		stage.setTitle("Homepage");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void submit(ActionEvent e) throws Exception {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}