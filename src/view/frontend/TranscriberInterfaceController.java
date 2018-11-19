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
import model.Trascrizione;

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

	String annotazione = null;
	private ObservableList<Integer> idPagine = FXCollections.observableArrayList();
	private ObservableList<Pagina> pagine = FXCollections.observableArrayList();
	private ObservableList<Trascrizione> tr = FXCollections.observableArrayList();
	
	private ObservableList<Pagina> pagComplete = FXCollections.observableArrayList();
	
	private static int ind;
	
	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void submit(ActionEvent e) throws Exception {

		String text = getText(editor.getHtmlText());
	
		TrascrizioneEditorController.insertTrascrizione(idPagina, text, ObjectContenitor.utenteAttivo.getID());
		idPagine.remove(ind);

		pagina.refresh();

		editor.setHtmlText("");
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		
		//idPagina,Scanpath,trascrizione, annotazione	
		ResultSet rs = RevisioneTrascrizioneController.infoTrascrizioni(ObjectContenitor.utenteAttivo.getID());
		
		try {
			while(rs.next()) {
				idPagine.add(rs.getInt(1));
				
				if(rs.getString(3) != null) {
					pagComplete.add(new Pagina(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}else {
					pagComplete.add(new Pagina(rs.getInt(1), rs.getString(2), "Trascrizione non disponibile", rs.getString(4)));
				}
				
			}
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
		
		pagina.setItems(idPagine);
		pagina.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		pagina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				
				ind = pagina.getSelectionModel().getSelectedIndex();
				idPagina = arg2;


//				for(Pagina p: pagine) {
//					
//					if(p.getID() == arg0.getValue()) {
//						
//						try {
//							
//							img.setImage(new Image(new FileInputStream(p.getScanpath())));
//							editor.setHtmlText(null);
//							
//						} catch (FileNotFoundException e) {
//							
//							e.printStackTrace();
//						}
//					}
//				}
				try {
					
					img.setImage(new Image(new FileInputStream(pagComplete.get(ind).getScanpath())));
					
					if(pagComplete.get(ind).getAnnotazione() == null) {
						annotazione = "";
					}else {
						annotazione = "<br><hr> Annotazioni:<br> <b>" + pagComplete.get(ind).getAnnotazione() + "</b>";
					}
					
					
					editor.setHtmlText(pagComplete.get(ind).getTrascrizione()+ annotazione);
					
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
			}
			
		});

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