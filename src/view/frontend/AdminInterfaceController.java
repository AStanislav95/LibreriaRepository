package view.frontend;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import controller.administrator.GestioneBackEndController;
import controller.dao.ConnectionDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdminInterfaceController implements Initializable {
	@FXML
	private Button homepage;
	@FXML
	private Button changerole;
	@FXML
	private Button profile;
	@FXML
	private Button changetranscriber;
	@FXML
	private TableView dbtable;
	@FXML
	private Button back;
	@FXML
	private TextField utente;
	@FXML
	private TextField ruolo;
	@FXML
	private TextField lvt;
	@FXML
	private Button ruolo1;
	@FXML
	private Button ruolo2;
	@FXML
	private Button ruolo3;
	@FXML
	private Button ruolo4;
	@FXML
	private Button ruolo5;
	@FXML
	private Button ruolo6;
	@FXML
	private Button ruolo7;
	@FXML
	private Button cd0;
	@FXML
	private Button cd1;
	@FXML
	private Button interfacciacandidatura;

	private ObservableList<ObservableList> data;
	private String Sql="select ID, Nome , Ruolo, LivelloTrascrittore , CanDownload  from utente";

	public void buildData(String SQL)  {
        
        data = FXCollections.observableArrayList();
        try {
         ResultSet rs = ConnectionDAO.query(SQL);
 
         
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setPrefWidth(145.25);
                col.setResizable(false);
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                       
                    }
                });
                
                dbtable.getColumns().addAll(col);
                
            }
 
          
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                 
                data.add(row);
 
            }
 
           
            dbtable.setItems(data);
        } catch (Exception exx) {
            exx.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

	@FXML
	private void back(ActionEvent e) throws Exception {
		Stage stage = (Stage) back.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Login.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void changerole(ActionEvent e) throws Exception {
		int role= Integer.parseInt(ruolo.getText());
		int IDutente=Integer.parseInt(utente.getText());
		if(role <8 && role>0 ) {
			GestioneBackEndController.cambiaruolo(IDutente,role);
    		dbtable.getColumns().clear();
			buildData(Sql);

		}else {
			Alert alert= new Alert(AlertType.ERROR);
			alert.setContentText("ID RUOLO ERRATO!!");
			alert.showAndWait();
    		
		}
	}

	@FXML
	private void changelvtranscriber(ActionEvent e) throws Exception {
		int IDutente=Integer.parseInt(utente.getText());
		int livello=Integer.parseInt(lvt.getText());
		if(livello <7 ) {
			GestioneBackEndController.Cambialvltranscriber(IDutente,livello);
    		dbtable.getColumns().clear();
			buildData(Sql);

		}else {
			Alert alert= new Alert(AlertType.ERROR);
			alert.setContentText("Livello Trascrittore ERRATO!!");
			alert.showAndWait();
    		
		}
	}

	@FXML
	private void elencoruoli(ActionEvent e) throws Exception {
		

	}

	@FXML
	private void canDownload(ActionEvent e) throws Exception {
		Button b = (Button)e.getSource();
    	String testo= String.valueOf((b.getText()).charAt((b.getText()).length()-1));
        if(testo.equals("1")) {
        GestioneBackEndController.AggiungiDownload(Integer.parseInt(utente.getText()));
          dbtable.getColumns().clear();
          buildData(Sql);
     	}else {
     	GestioneBackEndController.TogliDownload(Integer.parseInt(utente.getText()));
        dbtable.getColumns().clear();
        buildData(Sql);}

	}

	@FXML
	private void homepage() {
		
	}
	@FXML
	private void profile(ActionEvent e) throws Exception {
		Stage stage = (Stage) profile.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/GUI/Profile.fxml"));

		Scene scene = new Scene(parent, 1200, 800);
		stage.setTitle("Profile");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void interfacciacandidatura(ActionEvent e) throws Exception {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buildData(Sql);
	}

}
