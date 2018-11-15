package view.frontend;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
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
	private Button back;
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
	private Button adminUI;

	@FXML
	private void back(ActionEvent e) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Homepage.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Homepage");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void transcriber(ActionEvent e) throws Exception {

	}

	@FXML
	private void Adminpage(ActionEvent e) throws Exception {

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