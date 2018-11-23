package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ToolbarController implements Initializable {
	  @FXML
	    private JFXButton Homepage;

	    @FXML
	    private JFXButton Profile;

	    @FXML
	    private JFXButton Login;

	    @FXML
	    private JFXButton TranscriberCandidatureInterface;

	    @FXML
	    private JFXButton exit;


	    @FXML
	    private void exit(ActionEvent e) {
			Button B=(Button)e.getSource();
			Stage Stage= (javafx.stage.Stage) B.getScene().getWindow();
			Stage.close();
		}
 
	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
	private void homepage(ActionEvent e) throws IOException {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}
	@FXML
	private void profile(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void interfacciacandidatura(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}
    
    
    
    
    
}