package view.frontend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.dao.ConnectionDAO;
import controller.dao.PaginaDAO;
import controller.dao.TrascrizioneDAO;
import controller.transcriber.RevisioneTrascrizioneController;
import controller.transcriber.TrascrizioneEditorController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;

public class TranscriberInterfaceController implements Initializable {
//Stas pagliaccio
	
	static int idManoscritto;

	static int idPagina;
	@FXML
	private Button Homepage;
	@FXML
	private Button submit;


	@FXML
	private ListView<Integer> pagina;
	@FXML
	private ImageView img;
	@FXML
	private HTMLEditor editor;


	private ObservableList<Integer> idPagine = FXCollections.observableArrayList();
	private ObservableList<Pagina> pagine = FXCollections.observableArrayList();
	private static int ind;
	
	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void submit(ActionEvent e) throws Exception {

		// rimuove l'elemento selezionato e fa il refresh della tabella
		 idPagine.remove(ind);
		// ??? E' QUESTO SOPRA A NON FAR FUNZIONARE L'INSERTTRASCRIZIONE
		pagina.refresh();
		
		String text = getText(editor.getHtmlText());
	
	//-----------Non funziona----------
		TrascrizioneEditorController.insertTrascrizione(idPagina, text, ObjectContenitor.utenteAttivo.getID());
	// ------------ !! ----------
		editor.setHtmlText("");
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		
		ResultSet pagineAssegnate = PaginaDAO.pagineAssegnate(ObjectContenitor.utenteAttivo.getID());
		
		try {
			while(pagineAssegnate.next()) {
				idPagine.add(pagineAssegnate.getInt(1));
				pagine.add(new Pagina(pagineAssegnate.getInt(1), pagineAssegnate.getString(2) ));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		pagina.setItems(idPagine);
		pagina.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		pagina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				
				ind = pagina.getSelectionModel().getSelectedIndex();
				idPagina = arg0.getValue();


				for(Pagina p: pagine) {
					if(p.getID() == arg0.getValue()) {
						
						try {
							img.setImage(new Image(new FileInputStream(p.getScanpath())));
						} catch (FileNotFoundException e) {
							
							e.printStackTrace();
						}
					}
				}
				
			}
			
		});

		
		
		
//		ObservableList<String> work = FXCollections.observableArrayList();
//		ObservableList<Integer> pag = FXCollections.observableArrayList();
//		ObservableList<Pagina> pagine = FXCollections.observableArrayList();
//
//		for (Manoscritto m : ObjectContenitor.listaManoscritti) {
//
//			work.add(m.getTitolo());
//
//		}
//
//		manoscritto.setItems(work);
//		manoscritto.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//		manoscritto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> arg0, String newValue, String oldValue) {
//			
//				pag.clear();
//				pagine.clear();
//			
//				//pagineAssegnate(idUtenteAttivo)
//				
//				for (Manoscritto m : ObjectContenitor.listaManoscritti) {
//
//					
//					if(m.getTitolo().equals(arg0.getValue())) {
//						
//					
//						for (Pagina p : m.getListaPagine()) {
//							if(p.getTrascrizione().equals("Trascrizione non disponibile")) {
//								pagine.add(p);
//								pag.add(p.getNumero());
//							}
//							
//						}
//					}
//					
//				}
//				
//				pagina.setItems(pag);
//			
//			}
//		
//			
//		});// end
//		
//		pagina.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//		pagina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
//				
//			
//				
//				for(Pagina p : pagine) {
//					
//					if(p.getNumero() ==arg0.getValue()) {
//					
//						idPagina = p.getID();
//					
//						try {
//							
//							img.setImage(new Image(new FileInputStream(p.getScanpath())));
//						} catch (FileNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//				
//			}
//
//		});

	}

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