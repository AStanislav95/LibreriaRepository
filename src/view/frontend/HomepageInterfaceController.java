package view.frontend;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomepageInterfaceController implements Initializable {

	@FXML
	private TextField searchBar;
	@FXML
	private Button search;
	@FXML
	private Button profile;
	@FXML
	private Button listWorks;
	@FXML
	private Button upload;
	@FXML
	private RadioButton searchByAuthor;
	@FXML
	private RadioButton searchByName;
	@FXML
	private Button manage;
	@FXML
	private ListView listView;
	@FXML
	private Label description;
	@FXML
	private Button back;
	@FXML
	private Button gestioneassegnazione;
	@FXML
	private Button revupload;
	@FXML
	private Button selectImage;
	@FXML
	private TextField workName;
	@FXML
	private TextField numPage;
	@FXML
	private Label uploadlabel;
	@FXML
	private Label uploadlabel1;
	@FXML
	private Label uploadlabel2;
	@FXML
	private Label labelcandidatura;
	@FXML
	private Button interfacciacandidatura;

	@FXML
	private void search(ActionEvent e) throws Exception {

	}

	@FXML
	private void selectImage(ActionEvent e) throws SQLException, MalformedURLException {

	}

	@FXML
	public void profile(ActionEvent e) throws Exception {
		Stage stage = (Stage) profile.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Profile.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Profile");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void loginPage(ActionEvent e) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Login.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void listWorks(ActionEvent e) throws Exception {

	}

	@FXML
	private void upload(ActionEvent e) throws Exception {

	}

	@FXML
	private void gestioneAssegnazione(ActionEvent e) throws Exception {

	}

	@FXML
	private void revisioneupload(ActionEvent e) throws Exception {

	}

	@FXML
	private void interfacciacandidatura(ActionEvent e) throws Exception {

	}
	@FXML
	private void uploadFile(ActionEvent e) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}