package view.frontend;

import controller.dao.ConnectionDAO;
import controller.manager.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GestioneAssegnazioniInterfaceController implements Initializable {
	@FXML
	private Button Homepage;
	@FXML
	private Button confirm;
	@FXML
	private Button Profile;
	@FXML
	private TableView dbtable;
	@FXML
	private TableView dbtable1;
	@FXML
	private Button back;
	@FXML
	private TextField utente;
	@FXML
	private TextField IDpage;

	private ObservableList<ObservableList> data;
	
	public void buildData(String SQL, TableView dbtable)  {
        
        data = FXCollections.observableArrayList();
        try {
         ResultSet rs = ConnectionDAO.query(SQL);
 
         
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setPrefWidth(158);
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
	private void homepage(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void confirm(ActionEvent e) throws Exception {
		
		int idutente=Integer.parseInt(utente.getText());
	    int idpagina=Integer.parseInt(IDpage.getText());
	
			 if (AssegnazioneTrascrizioniController.doesitExist(idutente,idpagina))
			 { AssegnazioneTrascrizioniController.TogliTrascrizione(idutente,idpagina);}
			 else { AssegnazioneTrascrizioniController.AssegnaTrascrizione(idutente,idpagina);}
			String Sql="SELECT p.id, p.numero, m.titolo FROM pagina p, manoscritto m WHERE p.Trascrizione=0 and p.Manoscritto=m.ID;";
			buildData(Sql, dbtable);
			//funziona ma non si refresha.
			Sql="Select nome, ID from utente where ruolo="+4+"";
			buildData(Sql,dbtable1);
					
	}

	@FXML
	private void profile(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String Sql="SELECT p.id, p.numero, m.titolo FROM pagina p, manoscritto m, trascrizione t WHERE p.Trascrizione=0 and p.Manoscritto=m.ID and p.trascrizione=t.ID;";
		buildData(Sql, dbtable);
		Sql="Select nome, ID from utente where ruolo="+4+"";
		buildData(Sql,dbtable1);

	}

}