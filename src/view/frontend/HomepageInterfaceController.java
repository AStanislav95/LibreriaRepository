package view.frontend;

import java.io.File;
import java.net.MalformedURLException;

import controller.Main;
import controller.uploader.UploadScansioniController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class HomepageInterfaceController {

	@FXML
	private Button selectedImage;
	@FXML
	private TextField workName;
	@FXML
	private TextField numPage;
	
	@FXML
	private void uploadFile(ActionEvent e) throws Exception {
		
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Seleziona l'immagine");

		 File selectedFile = fileChooser.showOpenDialog(Main.getStage());
		 if(selectedFile != null) {
			 UploadScansioniController.uploadFile(selectedFile, workName.getText(), Integer.parseInt(numPage.getText())); 
		 }
		
		    
		    
		 
	}
	
	
}
