package view.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.dao.PaginaDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;

public class RevisioneUploadInterfaceController implements Initializable {

	@FXML
	private Button Homepage;
	@FXML
	private Button accetta;
	@FXML
	private Button rifiuta;
	@FXML
	private Button Profile;

	@FXML
	private ListView<Integer> pagina;
	@FXML
	private ImageView img;

	private static int ind;
	private static int paginaSelezionata;

	private ObservableList<Pagina> listaPagine = FXCollections.observableArrayList();
	private ObservableList<Integer> idPagine = FXCollections.observableArrayList();

	@FXML
	private void homepage(ActionEvent e) throws Exception {
		Button b = (Button) e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void accettaScan(ActionEvent e) throws Exception {
		PaginaDAO.accettaScan(paginaSelezionata);

		idPagine.remove(ind);
		pagina.refresh();
		img.setImage(null);

	}

	@FXML
	private void rifiutaScan(ActionEvent e) throws Exception {
		PaginaDAO.rifiutaScan(paginaSelezionata);
		
		idPagine.remove(ind);
		pagina.refresh();
		img.setImage(null);

	}

	@FXML
	private void profile(ActionEvent e) throws Exception {
		Button b = (Button) e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			ResultSet pagineDaAccettare = PaginaDAO.listaScan();

			while (pagineDaAccettare.next()) {

				idPagine.add(pagineDaAccettare.getInt(1));

				listaPagine.add(new Pagina(pagineDaAccettare.getInt(1), pagineDaAccettare.getString(2)));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pagina.setItems(idPagine);
		pagina.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		pagina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				paginaSelezionata = arg0.getValue();
				for (Pagina p : listaPagine) {

					if (p.getID() == arg0.getValue()) {
						try {

							ind = pagina.getSelectionModel().getSelectedIndex();

							img.setImage(new Image(new FileInputStream(p.getScanpath())));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		});

	}

}