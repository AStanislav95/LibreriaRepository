package view.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.dao.TrascrizioneDAO;
import controller.manager.AssegnazioneTrascrizioniController;
import controller.transcriber.RevisioneTrascrizioneController;
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
import model.Trascrizione;

public class CapoTrascrittoreInterfaceController implements Initializable {

	@FXML
	private Button rimanda;
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
	
	private ObservableList<Trascrizione> trasc = FXCollections.observableArrayList();
	
	@FXML
	private void rimanda(ActionEvent e) throws Exception {
		
		String annotazione = getText(editor.getHtmlText());
		
		
		RevisioneTrascrizioneController.mettiAnnotazione(trasc.get(ind).getID(), annotazione);
		
		AssegnazioneTrascrizioniController.AssegnaTrascrizione(trasc.get(ind).getIDUtente(), trasc.get(ind).getidPagina());
		
		idTrascrizioni.remove(ind);
		idTrasc.refresh();

		
	}
	
	
	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b = (Button) e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void submit(ActionEvent e) throws Exception {
	
		RevisioneTrascrizioneController.accettaTrascrizione(trasc.get(ind).getidPagina(),trasc.get(ind).getID());
		
		idTrascrizioni.remove(ind);

		idTrasc.refresh();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ResultSet tr = TrascrizioneDAO.getTrascrizioniDaRevisionare();
		
		try {
			while(tr.next()) {
				
				//t.ID,t.testo,t.IDUtente,p.ID,p.scanpath
				
				trasc.add(new Trascrizione(tr.getInt(1), tr.getString(2), tr.getInt(3), tr.getInt(4), tr.getString(5)));
						
				idTrascrizioni.add(tr.getInt(1));

				
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
					
					img.setImage(new Image(new FileInputStream(trasc.get(ind).getScanPagina())));
					
					editor.setHtmlText(trasc.get(ind).getTesto());
					
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
