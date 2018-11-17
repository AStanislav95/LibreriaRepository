package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.dao.ConnectionDAO;
import controller.manager.RichiestaCandidatureController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TranscriberCandidatureControllerInterface implements Initializable {
	@FXML
	private Button accept;
	@FXML
	private Button decline;
	@FXML
	private TableView dbtable;
	@FXML
	private Button AdminInterface1;
	@FXML
	private Button Homepage;
	@FXML
	private TextField utente;
	
	private ObservableList<ObservableList> data;
	@FXML

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
	private void candidature(ActionEvent e) throws Exception {
		int x=0;
		String bottone=((Button)e.getSource()).getText();
		   
		if(bottone.equals("Accetta Candidatura")) {
			RichiestaCandidatureController.RichiestaAccettata(Integer.parseInt(utente.getText()));
			RichiestaCandidatureController.Accetta_RifiutaRichiesta(x,Integer.parseInt(utente.getText()));
		}else {
			
			RichiestaCandidatureController.Accetta_RifiutaRichiesta(x,Integer.parseInt(utente.getText()));
		}
		dbtable.getColumns().clear();
		String Sql="select  ID, Nome from utente where RichiestaTrascrittore="+1+"";
		buildData(Sql);	
		}
	
	@FXML
	private void adminInterface(ActionEvent e) throws IOException {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}
	
	
	@FXML
	private void homepage(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String Sql="select  ID, Nome from utente where RichiestaTrascrittore="+1+"";
		buildData(Sql);
	}

}