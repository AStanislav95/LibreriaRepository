package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class SearchByAuthorInterfaceController implements Initializable {

	@FXML
	private ListView<String> resultList;
	@FXML
	private Button Homepage;
	private static String manoscrittoSelezionato;


	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		resultList.setItems(HomepageInterfaceController.getManoscritti());
		resultList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
	    resultList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		   
			manoscrittoSelezionato = observable.getValue();
		    
		    //works
		    Stage stage = (Stage) resultList.getScene().getWindow();
		   
		    try {
		    	
		    	Parent profile = FXMLLoader.load(getClass().getResource("/view/GUI/resultsFromSearch.fxml"));
		    	Scene scene = new Scene(profile);
		    	stage.setTitle("Risultati della ricerca");
		    	stage.setScene(scene);
		    	stage.show();
		    	
		    } catch (IOException ex) {
		    	
			Logger.getLogger(SearchByAuthorInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
		    }
			
		}

	    });//end selectionModel
	    
	}
	
	
	public static String getSelectedWork() {
		return manoscrittoSelezionato;
	}

}