package view.frontend;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controller.entry;
import controller.dao.ManoscrittoDAO;
import controller.dao.PaginaDAO;
import controller.uploader.UploadScansioniController;
import controller.viewer.RicercaMetadatiController;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;

public class HomepageInterfaceController implements Initializable {

	@FXML
	private TextField searchBar;
	@FXML
	private Button search;
	@FXML
	private Button profile;
	@FXML
	private Button listWorks;
	@FXML
	private Button upload;
	@FXML
	private RadioButton searchByAuthor;
	@FXML
	private RadioButton searchByName;
	@FXML
	private Button manage;
	@FXML
	private ListView<String> listView;
	@FXML
	private Button back;
	@FXML
	private Button gestioneassegnazione;
	@FXML
	private Button revupload;
	@FXML
	private Button selectImage;
	@FXML
	private TextField workName;
	@FXML
	private TextField numPage;
	@FXML
	private Button interfacciacandidatura;

	private String url;

	private static ObservableList<Pagina> pagManoscritti = FXCollections.observableArrayList();
	private static ObservableList<String> manoscritti = FXCollections.observableArrayList();

	@FXML
	private void search(ActionEvent e) throws Exception {

		if (searchByName.isSelected() && !searchByAuthor.isSelected()) {

			if(!RicercaMetadatiController.ricercaNome(searchBar.getText()).isEmpty()) {
				pagManoscritti = RicercaMetadatiController.ricercaNome(searchBar.getText());
			
				Stage stage = (Stage) search.getScene().getWindow();
			
				Parent resultSearch = FXMLLoader.load(getClass().getResource("/view/GUI/SearchByName.fxml"));

				Scene scene = new Scene(resultSearch);
				stage.setTitle("Risultati della ricerca");
				stage.setScene(scene);
				stage.show();
			}

		} else {
			System.out.println("Nessuna corrispondeza");
		}

		if (searchByAuthor.isSelected() && !searchByName.isSelected()) {
			
				if(!RicercaMetadatiController.ricercaAutore(searchBar.getText()).isEmpty()) {
					manoscritti = RicercaMetadatiController.ricercaAutore(searchBar.getText());
					Stage stage = (Stage) search.getScene().getWindow(); 
					Parent resultSearch = FXMLLoader.load(getClass().getResource("/view/GUI/SearchByAuthor.fxml"));
					
					Scene scene = new Scene(resultSearch);
					stage.setTitle("Risultati della ricerca");
					stage.setScene(scene);
					stage.show();
				
				}
		}else {
			System.out.println("Nessuna corrispondeza");
		}

	}

	@FXML
	public void profile(ActionEvent e) throws Exception {
		Stage stage = (Stage) profile.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Profile.fxml"));

		Scene scene = new Scene(parent, 500, 400);
		stage.setTitle("Profile");
		stage.setScene(scene);
		stage.show();
	}



	@FXML
	private void listWorks(ActionEvent e) throws Exception {

	}

	@FXML
	private void upload(ActionEvent e) throws Exception {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Seleziona l'immagine");

		File selectedFile = fileChooser.showOpenDialog(entry.getStage());

		url = selectedFile.toURI().toURL().toExternalForm();
		String newUrl = "/" + url.substring(5);
		String urlUbuntu = url.substring(5);

		if (selectedFile != null) {
			UploadScansioniController.uploadFile(Integer.parseInt(numPage.getText()), workName.getText(), urlUbuntu);
			
		}

	}

	@FXML
	private void gestioneAssegnazione(ActionEvent e) throws Exception {
		Stage stage = (Stage) gestioneassegnazione.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/GestioneAssegnazioni.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Gestione Assegnazioni");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void revisioneupload(ActionEvent e) throws Exception {
		Stage stage = (Stage) revupload.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Transcriber.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Revisione Upload");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void interfacciacandidatura(ActionEvent e) throws Exception {
		Stage stage = (Stage) interfacciacandidatura.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/TranscriberCandidatureInterface.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Modulo Trascrittore");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void uploadFile(ActionEvent e) {

	}
	
	
	
	public static ObservableList<Pagina> getpagManoscritti(){
		return pagManoscritti;
	}

	public static ObservableList<String> getManoscritti(){
		return manoscritti;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		
		ObservableList<String> listWorks = FXCollections.observableArrayList();

		for (Manoscritto m : ObjectContenitor.listaManoscritti) {
			listWorks.add(m.getTitolo());
			System.out.println(m.getListaPagine().size());
		}

		listView.setItems(listWorks);
		
		
		

	}

}