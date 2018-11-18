package view.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.dao.PaginaDAO;
import controller.dao.TrascrizioneDAO;
import controller.transcriber.TrascrizioneEditorController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.HTMLEditor;
import model.ObjectContenitor;
import model.Pagina;

public class CapoTrascrittoreInterfaceController implements Initializable {

	@FXML
	private Button Homepage;
	@FXML
	private Button submit;

	@FXML
	private ListView<Integer> idTrasc;
	@FXML
	private ImageView img;
	@FXML
	private HTMLEditor editor;
	
	private static int ind;
	private ObservableList<Integer> idTrascrizioni = FXCollections.observableArrayList();
	private ObservableList<String> tras = FXCollections.observableArrayList();
	private ObservableList<String> scanPathTrascrizioni = FXCollections.observableArrayList();
	

	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b = (Button) e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void submit(ActionEvent e) throws Exception {

//		idPagine.remove(ind);
//
//		pagina.refresh();
//
//		String text = getText(editor.getHtmlText());
//
//		// -----------Non funziona----------
//		TrascrizioneEditorController.insertTrascrizione(idPagina, text, ObjectContenitor.utenteAttivo.getID());
//		// ------------ !! ----------
//		editor.setHtmlText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ResultSet trascrizioni = TrascrizioneDAO.getTrascrizioniDaRevisionare();
		
		try {
			while(trascrizioni.next()) {
				
				idTrascrizioni.add(trascrizioni.getInt(1));
				tras.add(trascrizioni.getString(2));
				scanPathTrascrizioni.add(trascrizioni.getString(5));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		idTrasc.setItems(idTrascrizioni);
		idTrasc.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		idTrasc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				
				ind = idTrasc.getSelectionModel().getSelectedIndex();
				
				try {
					
					img.setImage(new Image(new FileInputStream(scanPathTrascrizioni.get(ind))));
					editor.setHtmlText(tras.get(ind));
					
				} catch (FileNotFoundException e) {
				
					e.printStackTrace();
				}
				
			}
			
		});

	}//end init

	public static String getText(String htmlText) {

		String result = "";

		Pattern pattern = Pattern.compile("<[^>]*>");
		Matcher matcher = pattern.matcher(htmlText);
		final StringBuffer text = new StringBuffer(htmlText.length());

		while (matcher.find()) {
			matcher.appendReplacement(text, " ");
		}

		matcher.appendTail(text);

		result = text.toString().trim();

		return result;
	}

}
