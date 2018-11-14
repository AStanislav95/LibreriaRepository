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
	private Button back;

	private static String selectedWork;

	@FXML
	private void back(ActionEvent e) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow(); //Source Stage!!
		Parent homepage = FXMLLoader.load(getClass().getResource("/view/GUI/Homepage.fxml"));

		Scene scene = new Scene(homepage);
		stage.setTitle("Homepage");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		resultList.setItems(HomepageInterfaceController.getManoscritti());
	}

}