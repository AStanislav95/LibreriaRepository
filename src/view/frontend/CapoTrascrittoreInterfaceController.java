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
		Button b = (Button) e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void submit(ActionEvent e) throws Exception {

		idPagine.remove(ind);

		pagina.refresh();

		String text = getText(editor.getHtmlText());

		// -----------Non funziona----------
		TrascrizioneEditorController.insertTrascrizione(idPagina, text, ObjectContenitor.utenteAttivo.getID());
		// ------------ !! ----------
		editor.setHtmlText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ResultSet pagineAssegnate = PaginaDAO.pagineAssegnate(ObjectContenitor.utenteAttivo.getID());

		try {
			while (pagineAssegnate.next()) {
				idPagine.add(pagineAssegnate.getInt(1));
				pagine.add(new Pagina(pagineAssegnate.getInt(1), pagineAssegnate.getString(2)));
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

				for (Pagina p : pagine) {
					if (p.getID() == arg0.getValue()) {

						try {
							img.setImage(new Image(new FileInputStream(p.getScanpath())));
						} catch (FileNotFoundException e) {

							e.printStackTrace();
						}
					}
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
