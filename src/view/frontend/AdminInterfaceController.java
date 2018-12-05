package view.frontend;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import com.sun.javafx.scene.control.skin.TableHeaderRow;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.binding.StringExpression;
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
	private Button Homepage;
	@FXML
	private Button changerole;
	@FXML
	private Button Profile;
	@FXML
	private Button changetranscriber;
	@FXML
	private TableView dbtable;
	@FXML
	private Button Login;
	@FXML
	private TextField utente;
	@FXML
	private TextField ruolo;
	@FXML
	private TextField lvt;
	
	@FXML
	private Button cd0;
	@FXML
	private Button cd1;
	@FXML
	private Button TranscriberCandidatureInterface;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamburger;

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
                col.impl_setReorderable(false);
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
        }
    }

	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
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
	private void canDownload(ActionEvent e) throws Exception {
		Button b = (Button)e.getSource();
    	String testo= String.valueOf((b.getId()).charAt((b.getId()).length()-1));
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
	private void homepage(ActionEvent e) throws IOException {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}
	@FXML
	private void profile(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@FXML
	private void interfacciacandidatura(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buildData(Sql);
		  
		 try { 
		VBox box =  FXMLLoader.load(getClass().getResource("/view/GUI/Toolbar.fxml"));
	           
					
					
				if(box!=null) {
					}
					drawer.setSidePane(box);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	          
	          

	        HamburgerNextArrowBasicTransition transition = new HamburgerNextArrowBasicTransition(hamburger);
	        transition.setRate(-1);
	        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
	            transition.setRate(transition.getRate() * -1);
	            transition.play();

	            if (drawer.isOpened()) {
	            	drawer.setDisable(true);
	                drawer.close();
	            } else {
	            	drawer.setDisable(false);
	            	drawer.open();
	                
	            }
	});
	}
	

}
