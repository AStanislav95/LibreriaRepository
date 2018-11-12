package controller.uploader;

import java.io.File;
import java.sql.ResultSet;
import controller.dao.ConnectionDAO;
import controller.dao.PaginaDAO;

public class UploadScansioniController {

	public static void uploadFile(File selectedFile, String manoscrittoSelezionato, int numPag) throws Exception {

		String url = selectedFile.toURI().toURL().toExternalForm();
		String newUrl = "/" + url.substring(5);

		ResultSet idWork = ConnectionDAO.query("select ID from Manoscritto WHERE Titolo = '" + manoscrittoSelezionato + "'");

		if (idWork.next()) {
			PaginaDAO.uploadPage(numPag, idWork.getInt(1), newUrl);
		} else {
			System.out.println("The ResultSet is empty");
		}

	}
}
