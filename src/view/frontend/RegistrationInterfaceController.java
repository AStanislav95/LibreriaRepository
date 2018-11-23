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
	private Button Login;
	@FXML
	private Button Registration;
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
		
		
		CambiaScene.CambiaStage(Login);
	}

	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {			
			
	}

}