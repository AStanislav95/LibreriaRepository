

package view.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CambiaScene {
       
        
     public static  void  CambiaStage(Button b) throws IOException {
    	 
      String scena1 = null;
      String nome = b.getId();
    
      scena1="/view/GUI/"+nome+".fxml";
       System.out.println(nome);
         
         Stage stage= (Stage) b.getScene().getWindow();
         Parent Scena = FXMLLoader.load(CambiaScene.class.getResource(scena1));
         if(nome.equals("Login")) {
        	 Scene scene1= new Scene(Scena,400,400);
        	 stage.centerOnScreen();
             stage.setResizable(false);
             stage.setTitle(nome);
             stage.setScene(scene1);
             stage.show();
         }else {
         Scene scene1 = new Scene(Scena,1200,900);
         stage.centerOnScreen();
         stage.setResizable(false);
         stage.setTitle(scena1);
         stage.setScene(scene1);
         stage.show();}
            
}}