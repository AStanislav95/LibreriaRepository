package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.viewer.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class LoginInterfaceController implements Initializable{


    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;
    
    @FXML
    private Label nameerror;
    
    @FXML
    private Label passerror;
    
    @FXML
    private Label errorelogin;
        
    @FXML
    private Button chiudi;
    
    @FXML
    private CheckBox checkpassword;
	
    
    
	@FXML
	private void chiudi(ActionEvent e) {
		
	}
	
	@FXML
	private void login() throws Exception {
		Stage stage = (Stage) login.getScene().getWindow();
		
		if(LoginController.Login(email.getText(), password.getText())) {
			
			Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Homepage.fxml"));
			
			Scene scene = new Scene(parent,1200,800);
			stage.setTitle("Homepage");
			stage.setScene(scene);
			stage.show();
		}
		
		
	}
	
	@FXML
	private void register(ActionEvent e) throws Exception {
		Stage stage = (Stage) register.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Registration.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Registrazione");
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	private void loginEnter(KeyEvent e) throws Exception {
	    	
			
	    	if(e.getCode() == KeyCode.ENTER) {
	    		login();
	    	}
	}
	
	@FXML
	private void check(ActionEvent e) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
}
