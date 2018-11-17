package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import controller.dao.ManoscrittoDAO;
import controller.dao.PaginaDAO;
import controller.viewer.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;


public class LoginInterfaceController implements Initializable{


    @FXML
    private Button Homepage;

    @FXML
    private Button Registration;

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
		
		
		if(LoginController.Login(email.getText(), password.getText())) {
			
			
			CambiaScene.CambiaStage(Homepage);
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			
			alert.setContentText("Dati errati");

			alert.showAndWait();
		}
		
		
	}
	
	@FXML
	private void register(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);

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
