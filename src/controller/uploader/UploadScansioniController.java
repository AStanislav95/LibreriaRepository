package controller.uploader;

import java.io.File;
import java.sql.ResultSet;
import controller.dao.ConnectionDAO;
import controller.dao.PaginaDAO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;

public class UploadScansioniController {

	
	public static boolean uploadFile(int numPag, String manoscrittoSelezionato, String pathUrl) throws Exception {
		
		for(Manoscritto m:ObjectContenitor.listaManoscritti) {
			
			if(manoscrittoSelezionato.equals(m.getTitolo())) {
			
				if(PaginaDAO.uploadPage(numPag, m.getID(), pathUrl)) {
					
					m.setListaPagine(new Pagina(numPag, m.getID(), pathUrl));
					

					Alert alert = new Alert(AlertType.INFORMATION);
					
					alert.setContentText("Upload completato con successo");

					alert.showAndWait();
					return true;
				}	
				
			}

		}
		
		return false;
	}


	
	
}
