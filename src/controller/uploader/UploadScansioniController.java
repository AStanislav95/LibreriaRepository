package controller.uploader;

import java.io.File;
import java.sql.ResultSet;
import controller.dao.ConnectionDAO;
import controller.dao.PaginaDAO;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;

public class UploadScansioniController {

	
	public static boolean uploadFile(int numPag, String manoscrittoSelezionato, String pathUrl) throws Exception {
		
		for(Manoscritto m:ObjectContenitor.listaManoscritti) {
			
			if(manoscrittoSelezionato.equals(m.getTitolo())) {
			
				if(PaginaDAO.uploadPage(numPag, m.getID(), pathUrl)) {
					
					m.setListaPagine(new Pagina(numPag, m.getID(), pathUrl));
					return true;
				}	
				
			}

		}
		
		return false;
	}


	
	
}
