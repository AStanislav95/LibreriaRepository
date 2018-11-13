package view.frontend;

import java.net.URL;
import java.util.ResourceBundle;

import controller.viewer.RegistrazioneController;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationInterfaceController implements Initializable {

	@FXML
	private Button back;
	@FXML
	private Button register;
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;
	@FXML
	private TextField name;
	@FXML
	private TextField qualification;
	@FXML
	private TextField profession;
	@FXML
	private CheckBox showPassword;
	
	@FXML
	private PasswordField passconfirm;

	@FXML
	private void register(ActionEvent e) throws Exception {
		
		RegistrazioneController.register(email.getText(), name.getText(), password.getText(), qualification.getText(), profession.getText());
		
		
		Stage stage = (Stage) register.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Login.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void back(ActionEvent e) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/gui/Login.fxml"));

		Scene scene = new Scene(parent);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void showPassword(ActionEvent e) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {			
			
	}

}