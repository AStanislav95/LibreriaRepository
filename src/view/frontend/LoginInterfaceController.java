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
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			
			alert.setContentText("Dati errati");

			alert.showAndWait();
		}
		
		
	}
	
	@FXML
	private void register(ActionEvent e) throws Exception {
		Stage stage = (Stage) register.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Registration.fxml"));

		Scene scene = new Scene(parent, 600, 500);
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
		
		try {
			ResultSet ms = ManoscrittoDAO.getManoscritti();
			
			while(ms.next()) {
				Manoscritto m = new Manoscritto(ms.getInt(1), ms.getInt(2), ms.getInt(3), ms.getInt(4), ms.getString(5), ms.getString(6), ms.getString(7));
				ObjectContenitor.listaManoscritti.add(m);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		//getPages
		for(Manoscritto m: ObjectContenitor.listaManoscritti) {
			try {
				//prs contiene tutte le pagine del manoscritto corrente
				
				ResultSet prs = PaginaDAO.getPages(m.getID());
				//aggiungo le pagine al manoscritto
				
				while(prs.next()) {
					
					m.setListaPagine(new Pagina(prs.getInt(2), prs.getInt(3), prs.getString(5)));
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
}
