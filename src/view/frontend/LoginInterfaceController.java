package view.frontend;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


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
    private TextField passtext;
    
    @FXML
    private Button chiudi;
    
    @FXML
    private CheckBox checkpassword;
	
	@FXML
	private void chiudi(ActionEvent e) {
		
	}
	
	@FXML
	private void login() {
		//getUserData(String name, String password)
		//DAO ->
	}
	
	@FXML
	private void register(ActionEvent e) {
		
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
