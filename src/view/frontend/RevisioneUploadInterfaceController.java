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

	static int idPagina;
	static Object paginaSelezionata;
	@FXML
	private Button homepage;
	@FXML
	private Button accetta;
	@FXML
	private Button rifiuta;
	@FXML
	private Button profile;
	
	@FXML
	private ListView<Integer> pagina;
	@FXML
	private ImageView img;
	
	private ObservableList<Pagina> listaPagine = FXCollections.observableArrayList();
	private ObservableList<Integer> idPagine = FXCollections.observableArrayList();

	@FXML
	private void homepage(ActionEvent e) throws Exception {
		Stage stage = (Stage) homepage.getScene().getWindow(); //Source Stage!!
		Parent homepage = FXMLLoader.load(getClass().getResource("/view/GUI/Homepage.fxml"));

		Scene scene = new Scene(homepage,1200,800);
		stage.setTitle("Homepage");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void accettaScan(ActionEvent e) throws Exception {
		PaginaDAO.accettaScan(idPagina);
		pagina.getItems().remove(0, idPagine.size());
		img.setImage(null);
		ResultSet rs = PaginaDAO.listaScan();
		while(rs.next()) {
			idPagine.add(rs.getInt(1));
		}
		
		
		pagina.setItems(idPagine);
		
	}
	
	@FXML
	private void rifiutaScan(ActionEvent e) throws Exception {
		PaginaDAO.rifiutaScan(idPagina);
		pagina.getItems().remove(0, idPagine.size());
		img.setImage(null);
		ResultSet rs = PaginaDAO.listaScan();
		while(rs.next()) {
			idPagine.add(rs.getInt(1));
		}
		
		
		pagina.setItems(idPagine);
	
	}


	@FXML
	private void profile(ActionEvent e) throws Exception {
		Stage stage = (Stage) profile.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Profile.fxml"));

		Scene scene = new Scene(parent, 500, 400);
		stage.setTitle("Profile");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			ResultSet pagineDaAccettare = PaginaDAO.listaScan();
			
			while(pagineDaAccettare.next()) {
				
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
				paginaSelezionata = arg0;
				for (Pagina p : listaPagine) {
					
					
					if(p.getID() == arg0.getValue()) {
						try {
							idPagina = p.getID();
							System.out.println(idPagina);
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