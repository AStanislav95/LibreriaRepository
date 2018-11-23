package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import controller.entry;
import controller.dao.ManoscrittoDAO;
import controller.dao.PaginaDAO;
import controller.viewer.LoginController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;
import sun.misc.Launcher;


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
    private Button exit;
    
    @FXML
    private CheckBox checkpassword;
	
    @FXML
    private AnchorPane root;
    
    @FXML
    private void exit(ActionEvent e) {
		Button B=(Button)e.getSource();
		Stage Stage= (javafx.stage.Stage) B.getScene().getWindow();
		Stage.close();
	}

	
	@FXML
	private void login() throws Exception {
		
		
		if(LoginController.Login(email.getText(), password.getText())) {
			
			
			CambiaScene.CambiaStage(Homepage);
		}else {
			/*Alert alert = new Alert(AlertType.ERROR);
			
			alert.setContentText("Dati errati");

			alert.showAndWait();*/
			//EditText.PasswordWrong(email,password);
		}
		
		
	}
	
	private void loadSplashScreen() {
        try {
            entry.isSplashLoaded = true;

            StackPane pane = FXMLLoader.load(getClass().getResource(("/view/GUI/splash.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/view/GUI/Login.fxml")));
                    
                    root.getChildren().setAll(parentContent);
                } catch (IOException ex) {
                }
            });

        } catch (IOException ex) {
        }
    }
	@FXML
	private void register(ActionEvent e) throws Exception {
		/*Stage stage=(Stage) ((Button)e.getSource()).getScene().getWindow();
		Parent Scena = FXMLLoader.load(CambiaScene.class.getResource("/view/GUI/Login.fxml"));
		
		Scene scene = new Scene(Scena, 1120, 500);
		scene.getStylesheets().add("/view/GUI/style/Border.css");
		
		stage.setScene(scene);
		Registration.setVisible(false);*/
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
		   if (!entry.isSplashLoaded) {
	            loadSplashScreen();}}

		
		
		
//		try {
//			ResultSet ms = ManoscrittoDAO.getManoscritti();
//			
//			while(ms.next()) {
//				Manoscritto m = new Manoscritto(ms.getInt(1), ms.getInt(2), ms.getInt(3), ms.getInt(4), ms.getString(5), ms.getString(6), ms.getString(7));
//				ObjectContenitor.listaManoscritti.add(m);
//			}
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//		
//		//getPages
//		for(Manoscritto m: ObjectContenitor.listaManoscritti) {
//			try {
//				//prs contiene tutte le pagine del manoscritto corrente
//				
//				ResultSet prs = PaginaDAO.getPages(m.getID());
//				//aggiungo le pagine al manoscritto
//				
//				while(prs.next()) {
//					
//					m.setListaPagine(new Pagina(prs.getInt(2), prs.getInt(3), prs.getString(5)));
//				}
//				
//				
//			} catch (Exception e) {
//				
//				e.printStackTrace();
//			}
//			
//		}
		
	}


	  
	

