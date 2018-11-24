

package view.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CambiaScene {
    
        
     public static  void  CambiaStage(Button b) throws IOException {
    	 
      String scena1 = null;
      String nome = b.getId();
    
      scena1="/view/GUI/"+nome+".fxml";
         
         Stage stage= (Stage) b.getScene().getWindow();
         Parent Scena = FXMLLoader.load(CambiaScene.class.getResource(scena1));
         if(nome.equals("Login")) {
        	 Scene scene1= new Scene(Scena,510,450);
        	
        	 scene1.getStylesheets().add("/view/GUI/style/tableview.css");
        	 scene1.getStylesheets().add("/view/GUI/style/Listview.css");
        	 scene1.getStylesheets().add("/view/GUI/style/Border.css");
        	 
        	 scene1.setFill(Color.TRANSPARENT);
        	 //stage.centerOnScreen();
        	 //stage.initStyle(StageStyle.UNDECORATED);
             stage.setResizable(false);
             stage.setTitle(nome);
             stage.setScene(scene1);
             //stage.centerOnScreen();
             stage.show();
         }else {
         Scene scene1 = new Scene(Scena,1200,800);
         scene1.getStylesheets().add("/view/GUI/style/tableview.css");
         scene1.getStylesheets().add("/view/GUI/style/Listview.css");
    	 scene1.getStylesheets().add("/view/GUI/style/Border.css");
    	 scene1.setFill(Color.TRANSPARENT);
         //stage.centerOnScreen();
         stage.setResizable(false);
         //stage.initStyle(StageStyle.UNDECORATED);
         stage.setTitle(scena1);
         stage.setScene(scene1);
         stage.centerOnScreen();
         stage.show();
         }
            
}}