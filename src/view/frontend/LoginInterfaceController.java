package view.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginInterfaceController {

	
	@FXML
	private void chiudi(ActionEvent e) {
		
	}
	
	@FXML
	private void login() {
		
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
}
